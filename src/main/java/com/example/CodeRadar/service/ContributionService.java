package com.example.CodeRadar.service;

import com.example.CodeRadar.dto.ContributionDto;
import com.example.CodeRadar.dto.ContributionSummaryDto;

import java.util.List;

public interface ContributionService {
    ContributionDto createContribution(ContributionDto contributionDto);
    List<ContributionDto> getContributionsByProjectId(Long projectId);
    List<ContributionSummaryDto> getContributionSummaryByProjectId(Long projectId);

    List<ContributionDto> getAllContributions();
}
