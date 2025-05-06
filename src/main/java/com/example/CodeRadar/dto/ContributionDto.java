package com.example.CodeRadar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContributionDto {
    private Long id;
    private int commits;
    private int pullRequests;
    private int issues;
    private int linesOfCode;
    private Long userId;
    private Long projectId;
}

