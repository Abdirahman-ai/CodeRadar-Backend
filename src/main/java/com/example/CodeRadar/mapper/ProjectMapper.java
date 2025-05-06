package com.example.CodeRadar.mapper;

import com.example.CodeRadar.dto.ProjectDto;
import com.example.CodeRadar.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { ContributionMapper.class })
public interface ProjectMapper {

    @Mapping(source = "contributions", target = "contributions")
    ProjectDto entityToDto(Project project);
    Project dtoToEntity(ProjectDto projectDto);
    List<ProjectDto> entitiesToDto(List<Project> projects);
}

