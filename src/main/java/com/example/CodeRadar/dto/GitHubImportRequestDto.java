package com.example.CodeRadar.dto;


import lombok.Data;

@Data
public class GitHubImportRequestDto {
    private String repoUrl;
    private String personalAccessToken; // optional (for private repos or rate limit)
}
