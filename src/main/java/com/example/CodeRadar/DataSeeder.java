package com.example.CodeRadar;

import com.example.CodeRadar.entity.Contribution;
import com.example.CodeRadar.entity.Project;
import com.example.CodeRadar.entity.User;
import com.example.CodeRadar.repository.ContributionRepository;
import com.example.CodeRadar.repository.ProjectRepository;
import com.example.CodeRadar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final ContributionRepository contributionRepository;

    @Override
    public void run(String... args) throws Exception {
        // Skip seeding if users already exist
        if (!userRepository.findAll().isEmpty()) return;

        // Create users
        User alice = new User(null, "alice", "Alice Doe", "alice@example.com", "password123", new ArrayList<>());
        User bob = new User(null, "bob", "Bob Smith", "bob@example.com", "password123", new ArrayList<>());


        userRepository.saveAll(Arrays.asList(alice, bob));

        // Create project
        Project project = new Project();
        project.setName("CodeRadar Demo");
        project.setRepoUrl("https://github.com/example/coderadar");
        project = projectRepository.save(project);

        // Create contributions
        Contribution c1 = new Contribution(null, 10, 2, 1, 500, alice, project);
        Contribution c2 = new Contribution(null, 7, 1, 1, 320, bob, project);

        contributionRepository.saveAll(Arrays.asList(c1, c2));

        // Update project with contributions (optional, if not bidirectional)
        project.setContributions(Arrays.asList(c1, c2));
        projectRepository.save(project);

        System.out.println("✔️ Seeded test data: 2 users, 1 project, 2 contributions");
    }
}
