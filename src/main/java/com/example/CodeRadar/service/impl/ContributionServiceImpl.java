package com.example.CodeRadar.service.impl;

import com.example.CodeRadar.dto.ContributionDto;
import com.example.CodeRadar.entity.Contribution;
import com.example.CodeRadar.entity.Project;
import com.example.CodeRadar.entity.User;
import com.example.CodeRadar.exception.BadRequestException;
import com.example.CodeRadar.mapper.ContributionMapper;
import com.example.CodeRadar.mapper.ProjectMapper;
import com.example.CodeRadar.repository.ContributionRepository;
import com.example.CodeRadar.repository.ProjectRepository;
import com.example.CodeRadar.repository.UserRepository;
import com.example.CodeRadar.service.ContributionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}

