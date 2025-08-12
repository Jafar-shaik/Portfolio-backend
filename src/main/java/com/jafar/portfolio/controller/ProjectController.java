package com.jafar.portfolio.controller;

import com.jafar.portfolio.entity.Project;
import com.jafar.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        Project addedProject = projectService.addProject(project);
        return ResponseEntity.ok(addedProject);
    }

    @GetMapping("/{title}") // This will be used later 😎😎
    public Project getProjectByTitle(@PathVariable String title){
        return projectService.getProjectByTitle(title);
    }

    @GetMapping
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @DeleteMapping("/{_id}")
    public ResponseEntity<?> deleteProject(@PathVariable String _id){
        projectService.deleteProject(_id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public void deleteAll(){
        projectService.deleteAll();
    }

}
