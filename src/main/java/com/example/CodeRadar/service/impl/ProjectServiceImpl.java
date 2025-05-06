package com.example.CodeRadar.service.impl;

import com.example.CodeRadar.dto.ProjectDto;
import com.example.CodeRadar.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        return null;
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        return List.of();
    }

    @Override
    public ProjectDto getProjectById(Long id) {
        return null;
    }
}
