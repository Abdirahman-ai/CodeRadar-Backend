package com.example.CodeRadar.service.impl;

import com.example.CodeRadar.dto.ContributionDto;
import com.example.CodeRadar.service.GitHubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GitHubServiceImpl implements GitHubService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<ContributionDto> fetchContributions(String owner, String repo, String token) {
        String url = String.format("https://api.github.com/repos/%s/%s/contributors", owner, repo);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/vnd.github+json");

        if (token != null && !token.isBlank()) {
            headers.setBearerAuth(token);
        }

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<List> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                List.class
        );

        List<ContributionDto> contributions = new ArrayList<>();

        if (response.getStatusCode() == HttpStatus.OK) {
            List<Map<String, Object>> data = response.getBody();

            if (data != null) {
                for (Map<String, Object> contributor : data) {
                    String username = (String) contributor.get("login");
                    Integer commitCount = (Integer) contributor.get("contributions");

                    ContributionDto dto = new ContributionDto();
                    dto.setCommits(commitCount);
                    dto.setGithubUsername(username);
                    dto.setLinesOfCode(0); // optional, we don't have LOC yet
                    dto.setPullRequests(0);
                    dto.setIssues(0);

                    contributions.add(dto);
                }
            }
        }

        return contributions;
    }
}
