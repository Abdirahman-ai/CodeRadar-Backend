package com.example.CodeRadar.service;

import com.example.CodeRadar.dto.ContributionDto;

import java.util.List;

public interface GitHubService {
    List<ContributionDto> fetchContributions(String owner, String repo, String token);
}
