package com.example.CodeRadar.service;

import com.example.CodeRadar.dto.ContributionDto;

import java.util.List;

public interface ContributionService {
    ContributionDto createContribution(ContributionDto contributionDto);
    List<ContributionDto> getContributionsByProjectId(Long projectId);
}
