package com.example.CodeRadar.mapper;

import com.example.CodeRadar.dto.ContributionDto;
import com.example.CodeRadar.entity.Contribution;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContributionMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "project.id", target = "projectId")
    ContributionDto entityToDto(Contribution contribution);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "projectId", target = "project.id")
    Contribution dtoToEntity(ContributionDto contributionDto);

    List<Contribution> dtoToEntities(List<ContributionDto> contributionDto);
    List<ContributionDto> entitiesToDto(List<Contribution> contributions);
}

