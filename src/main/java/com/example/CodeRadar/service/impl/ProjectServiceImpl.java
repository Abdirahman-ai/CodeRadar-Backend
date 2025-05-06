package com.example.CodeRadar.service.impl;

import com.example.CodeRadar.dto.ContributionDto;
import com.example.CodeRadar.dto.ProjectDto;
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
import com.example.CodeRadar.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final ContributionMapper contributionMapper;
    private final UserRepository userRepository;

    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        if (projectDto.getName() == null || projectDto.getRepoUrl() == null) {
            throw new BadRequestException("Missing project name or repository URL.");
        }

        Project newProject = new Project();
        newProject.setName(projectDto.getName());
        newProject.setRepoUrl(projectDto.getRepoUrl());

        // Save project first to get ID
        projectRepository.save(newProject);

        // Handle contributions if provided
        if (projectDto.getContributions() != null) {
            List<Contribution> contributions = new ArrayList<>();

            for (ContributionDto dto : projectDto.getContributions()) {
                User user = userRepository.findById(dto.getUserId())
                        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + dto.getUserId()));

                Contribution contribution = contributionMapper.dtoToEntity(dto);
                contribution.setUser(user);
                contribution.setProject(newProject);
                contributions.add(contribution);
            }

            newProject.setContributions(contributions);
            projectRepository.saveAndFlush(newProject);
        }

        return projectMapper.entityToDto(newProject);
    }


    @Override
    public List<ProjectDto> getAllProjects() {
        List<Project> allProjects = projectRepository.findAll();
        if (allProjects.isEmpty()) {
            throw new ResourceNotFoundException("There are currently no projects in the database.");
        }
        return projectMapper.entitiesToDto(allProjects);
    }

    @Override
    public ProjectDto getProjectById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if(project.isEmpty()){
            throw new ResourceNotFoundException("Project with project id: " + id + " does not exist");
        }

        return projectMapper.entityToDto(project.get());
    }
}
