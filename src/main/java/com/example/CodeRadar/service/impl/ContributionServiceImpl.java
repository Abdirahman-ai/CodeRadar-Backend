package com.example.CodeRadar.service.impl;

import com.example.CodeRadar.dto.ContributionDto;
import com.example.CodeRadar.dto.ContributionSummaryDto;
import com.example.CodeRadar.entity.Contribution;
import com.example.CodeRadar.entity.Project;
import com.example.CodeRadar.entity.User;
import com.example.CodeRadar.exception.BadRequestException;
import com.example.CodeRadar.exception.ResourceNotFoundException;
import com.example.CodeRadar.mapper.ContributionMapper;
import com.example.CodeRadar.mapper.ProjectMapper;
import com.example.CodeRadar.repository.ContributionRepository;
import com.example.CodeRadar.repository.ProjectRepository;
import com.example.CodeRadar.repository.UserRepository;
import com.example.CodeRadar.service.ContributionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ContributionServiceImpl implements ContributionService {

    private final ContributionRepository contributionRepository;
    private final ContributionMapper contributionMapper;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Override
    public ContributionDto createContribution(ContributionDto contributionDto) {
        if (contributionDto.getProjectId() == null || contributionDto.getUserId() == null) {
            throw new BadRequestException("Missing projectId or userId");
        }

        User user = userRepository.findById(contributionDto.getUserId())
                .orElseThrow(() -> new BadRequestException("User not found with id: " + contributionDto.getUserId()));

        Project project = projectRepository.findById(contributionDto.getProjectId())
                .orElseThrow(() -> new BadRequestException("Project not found with id: " + contributionDto.getProjectId()));

        Contribution contribution = new Contribution();
        contribution.setUser(user);
        contribution.setProject(project);
        contribution.setCommits(contributionDto.getCommits());
        contribution.setPullRequests(contributionDto.getPullRequests());
        contribution.setIssues(contributionDto.getIssues());
        contribution.setLinesOfCode(contributionDto.getLinesOfCode());

        contributionRepository.save(contribution);

        return contributionMapper.entityToDto(contribution);
    }

    @Override
    public List<ContributionDto> getContributionsByProjectId(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new BadRequestException("Project with id: " + projectId + " does not exist!"));

        List<Contribution> contributions = project.getContributions();
        if (contributions == null || contributions.isEmpty()) {
            throw new BadRequestException("There are no contributions for this project!");
        }

        return contributionMapper.entitiesToDto(contributions);
    }

    @Override
    public List<ContributionSummaryDto> getContributionSummaryByProjectId(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

        List<Contribution> contributions = project.getContributions();
        if (contributions == null || contributions.isEmpty()) {
            throw new ResourceNotFoundException("No contributions found for this project");
        }

        int totalCommits = 0;
        int totalLoc = 0;

        // Group contributions by userId
        Map<Long, ContributionSummaryDto> summaryMap = new HashMap<>();

        for (Contribution contribution : contributions) {
            Long userId = contribution.getUser().getId();

            ContributionSummaryDto summary = summaryMap.getOrDefault(userId, new ContributionSummaryDto());
            summary.setUserId(userId);
            summary.setGithubUsername(contribution.getUser().getGithubUsername());

            // Add up values
            summary.setCommits(summary.getCommits() + contribution.getCommits());
            summary.setLinesOfCode(summary.getLinesOfCode() + contribution.getLinesOfCode());
            summary.setPullRequests(summary.getPullRequests() + contribution.getPullRequests());
            summary.setIssues(summary.getIssues() + contribution.getIssues());

            summaryMap.put(userId, summary);

            totalCommits += contribution.getCommits();
            totalLoc += contribution.getLinesOfCode();
        }

        // Calculate percentages
        for (ContributionSummaryDto summary : summaryMap.values()) {
            if (totalCommits > 0) {
                summary.setCommitPercentage((summary.getCommits() * 100.0) / totalCommits);
            }
            if (totalLoc > 0) {
                summary.setLocPercentage((summary.getLinesOfCode() * 100.0) / totalLoc);
            }
        }

        return new ArrayList<>(summaryMap.values());
    }

    @Override
    public List<ContributionDto> getAllContributions() {
        List<Contribution> contributions = contributionRepository.findAll();
        return contributionMapper.entitiesToDto(contributions);
    }
}

