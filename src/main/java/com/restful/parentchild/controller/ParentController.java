package com.restful.parentchild.controller;

import com.restful.parentchild.model.Person;
import com.restful.parentchild.response.Response;
import com.restful.parentchild.service.ChildrenService;
import com.restful.parentchild.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParentController {

    @Autowired
    ParentService parentService;

    @Autowired
    ChildrenService childrenService;

    @GetMapping(path = "/parents")
    public List<Person> getAllParents() {
        return parentService.getAllParents();
    }

    @GetMapping(path = "/parents/{id}")
    public Person getParentById(@PathVariable("id") int id) {
        return parentService.getParentById(id);
    }

    @PostMapping(path = "/parents")
    @ResponseStatus(HttpStatus.CREATED)
    public Response createNewParent(@RequestBody Person person) {
        person.setParent(Boolean.TRUE);
        return new Response(parentService.createParent(person), "Parent Created Successfully");

    }

    @PutMapping(path = "/parents/{id}")
    public Response updateParent(@RequestBody Person person, @PathVariable("id") int id) {
        person.setParent(Boolean.TRUE);
        return new Response(parentService.updateParent(person, id), "Parent Updated Successfully");

    }

    @PutMapping(path = "/children/{id}")
    public Response updateChild(@RequestBody Person person, @PathVariable("id") int id) {
        person.setParent(Boolean.FALSE);
        return new Response(childrenService.updateChild(person, id), "Child Updated Successfully");

    }

}
