package com.example.CodeRadar.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContributionSummaryDto {
    private Long userId;
    private String githubUsername;
    private int commits;
    private int linesOfCode;
    private int pullRequests;
    private int issues;

    private double commitPercentage;
    private double locPercentage;
}
