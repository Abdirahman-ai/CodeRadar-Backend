package com.example.CodeRadar.repository;

import com.example.CodeRadar.entity.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContributionRepository extends JpaRepository<Contribution, Long> {
    List<Contribution> findByProjectId(Long projectId);
}

