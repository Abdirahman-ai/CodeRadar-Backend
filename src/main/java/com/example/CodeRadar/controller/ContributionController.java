package com.example.CodeRadar.controller;
import com.example.CodeRadar.dto.ContributionDto;
import com.example.CodeRadar.dto.ContributionSummaryDto;
import com.example.CodeRadar.service.ContributionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/contributions")
@RequiredArgsConstructor
public class ContributionController {

    private final ContributionService contributionService;

    @PostMapping
    public ResponseEntity<ContributionDto> createContribution(@RequestBody ContributionDto contributionDto) {
        return ResponseEntity.ok(contributionService.createContribution(contributionDto));
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<ContributionDto>> getContributionsByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(contributionService.getContributionsByProjectId(projectId));
    }

    @GetMapping("/summary/project/{projectId}")
    public ResponseEntity<List<ContributionSummaryDto>> getContributionSummary(@PathVariable Long projectId) {
        return ResponseEntity.ok(contributionService.getContributionSummaryByProjectId(projectId));
    }

}

