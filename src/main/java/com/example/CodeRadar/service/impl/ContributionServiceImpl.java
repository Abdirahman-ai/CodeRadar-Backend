package com.example.CodeRadar.service.impl;

import com.example.CodeRadar.dto.ContributionDto;
import com.example.CodeRadar.service.ContributionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContributionServiceImpl implements ContributionService {
    @Override
    public ContributionDto createContribution(ContributionDto contributionDto) {
        return null;
    }

    @Override
    public List<ContributionDto> getContributionsByProjectId(Long projectId) {
        return List.of();
    }
}
