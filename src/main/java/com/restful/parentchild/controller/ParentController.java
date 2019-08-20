package com.restful.parentchild.controller;

import com.restful.parentchild.model.Person;
import com.restful.parentchild.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParentController {

    @Autowired
    ParentService parentService;


    @GetMapping(path = "/parents")
    public List<Person> getAllParents() {

        return parentService.getAllParents();
    }

    @GetMapping(path = "/parents/{id}")
    public Person getParentById(@PathVariable("id") int id) {
        return parentService.getParentById(id);
    }

}
