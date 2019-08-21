package com.restful.parentchild.service;

import com.restful.parentchild.ParentRepository;
import com.restful.parentchild.exception.ResourceNotFoundException;
import com.restful.parentchild.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Person> person = parentRepository.findParentById(id);
        if (!person.isPresent())
            throw new ResourceNotFoundException("Could not find parent with id: " + id);
        return person.get();
    }

    public Integer createParent(Person person) {
        if (person == null) {
            throw new ResourceNotFoundException("Empty body: Data is missing");
        } else {
            parentRepository.save(person);
            return person.getId();
        }
    }
}
