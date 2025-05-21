package com.example.CodeRadar.service;

import com.example.CodeRadar.dto.GitHubImportRequestDto;
import com.example.CodeRadar.dto.ProjectDto;
import com.example.CodeRadar.entity.GitHubImportRequest;

import java.util.List;

public interface ProjectService {
    ProjectDto createProject(ProjectDto projectDto);
    List<ProjectDto> getAllProjects();
    ProjectDto getProjectById(Long id);

    ProjectDto importFromGitHub(GitHubImportRequestDto request);

}


