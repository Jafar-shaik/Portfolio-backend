package com.jafar.portfolio.service;

import com.jafar.portfolio.entity.Project;
import com.jafar.portfolio.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project addProject(Project project){
        return projectRepository.save(project);
    }

    public Project getProjectByTitle(String title){
        Project project = projectRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Project not found with title " + title));
        return project;
    }

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProject(String id){
        projectRepository.deleteById(id);
    }

    public void deleteAll(){
        projectRepository.deleteAll();
    }
}
