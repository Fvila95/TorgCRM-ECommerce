package ru.torgcrm.ecommerce.shop.controllers.rest.admin;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.torgcrm.ecommerce.shop.models.Project;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/admin/projects")
public class AdminProjectsController {
    @CrossOrigin
    @RequestMapping
    public @ResponseBody List<Project> get() {
        int i = 0;
        List<Project> projects = Stream.generate(Project::new).limit(10).collect(Collectors.toList());
        for (Project p : projects) {
            i++;
            p.setId(new Long(i));
            p.setDomain("Domain");
            p.setTemplate("Template");
        }
        return projects;
    }
}
