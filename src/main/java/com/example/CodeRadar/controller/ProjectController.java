package com.example.CodeRadar.controller;

import com.example.CodeRadar.dto.GitHubImportRequestDto;
import com.example.CodeRadar.dto.ProjectDto;
import com.example.CodeRadar.entity.GitHubImportRequest;
import com.example.CodeRadar.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/github-import")
    public ResponseEntity<ProjectDto> importFromGitHub(@RequestBody GitHubImportRequestDto request) {
        return ResponseEntity.ok(projectService.importFromGitHub(request));
    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.createProject(projectDto));
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }
}
