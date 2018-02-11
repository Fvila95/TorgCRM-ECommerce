package ru.torgcrm.ecommerce.shop.controllers.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.torgcrm.ecommerce.shop.models.Project;
import ru.torgcrm.ecommerce.shop.repository.ProjectRepository;

import java.util.List;

@RestController
@RequestMapping("/api/admin/projects")
public class AdminProjectsController {

    @Autowired
    private ProjectRepository projectRepository;

    @CrossOrigin
    @RequestMapping
    public @ResponseBody
    List<Project> get() {
        return projectRepository.findAll();
    }

    @CrossOrigin
    @PutMapping(consumes = {"application/json"})
    public @ResponseBody
    Project create(@RequestBody Project project) {
        return this.projectRepository.save(project);
    }

    @CrossOrigin
    @PostMapping(consumes = {"application/json"})
    public @ResponseBody
    Project update(@RequestBody Project project) {
        return this.projectRepository.save(project);
    }

    @CrossOrigin
    @GetMapping("/details/{id}")
    public @ResponseBody
    Project getById(@PathVariable(name = "id") Long projectId) {
        return projectRepository.findById(projectId);
    }

    @CrossOrigin
    @DeleteMapping("{id}")
    public @ResponseBody
    void delete(@PathVariable(name = "id") Long projectId) {
        this.projectRepository.delete(projectId);
    }
}
