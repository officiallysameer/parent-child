package com.restful.parentchild.controller;

import com.restful.parentchild.model.Parents;
import com.restful.parentchild.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParentController {

    @Autowired
    ParentService parentService;


    @GetMapping(path = "/parents")
    @ResponseBody
    public List<Parents> getAllParents() {
        return parentService.getAllParents();
    }
}
