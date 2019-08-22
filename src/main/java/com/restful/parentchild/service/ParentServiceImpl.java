package com.restful.parentchild.service;

import com.restful.parentchild.exception.BadRequestException;
import com.restful.parentchild.exception.ResourceNotFoundException;
import com.restful.parentchild.model.Person;
import com.restful.parentchild.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Override
    public Person getParentById(int id) {
        Optional<Person> person = parentRepository.findParentById(id);
        if (!person.isPresent())
            throw new ResourceNotFoundException("Could not find parent with id: " + id);
        return person.get();
    }

    @Override
    public Integer updateParent(Person person, int id) {
        if (person == null) {
            throw new BadRequestException("Empty body: Data is missing");
        } else {
            Person personToUpdate = getParentById(id);
            person.setId(personToUpdate.getId());
            parentRepository.save(person);
            return person.getId();
        }
    }

    @Override
    public Integer createParent(Person person) {
        if (person == null) {
            throw new BadRequestException("Empty body: Data is missing");
        } else {
            parentRepository.save(person);
            return person.getId();
        }
    }


}
