package com.example.CodeRadar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long id;
    private String name;
    private String repoUrl;
    private List<ContributionDto> contributions; // Optional: ill include contributions if needed
}
