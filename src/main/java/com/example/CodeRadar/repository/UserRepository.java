package com.example.CodeRadar.repository;

import com.example.CodeRadar.entity.Contribution;
import com.example.CodeRadar.entity.Project;
import com.example.CodeRadar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByGithubUsername(String githubUsername);
    Optional<User> findByEmail(String email);
}

