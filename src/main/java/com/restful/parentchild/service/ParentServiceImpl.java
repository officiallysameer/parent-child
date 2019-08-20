package com.restful.parentchild.service;

import com.restful.parentchild.ParentRepository;
import com.restful.parentchild.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentRepository parentRepository;


    @Override
    public List<Person> getAllParents() {
        return parentRepository.findAllParents();
    }

    @Override
    public Person getParentById(int id) {
        return parentRepository.findParentById(id);
    }
}
