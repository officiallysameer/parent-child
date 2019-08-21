package com.restful.parentchild.service;

import com.restful.parentchild.exception.BadRequestException;
import com.restful.parentchild.exception.ResourceNotFoundException;
import com.restful.parentchild.model.Person;
import com.restful.parentchild.repository.ChildrenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChildrenServiceImpl implements ChildrenService {

    @Autowired
    private ChildrenRepository childrenRepository;


    @Override
    public Person getChildById(int id) {
        Optional<Person> person = childrenRepository.findChildById(id);
        if (!person.isPresent())
            throw new ResourceNotFoundException("Could not find child with id: " + id);
        return person.get();
    }

    @Override
    public Integer updateChild(Person person, int id) {
        if (person == null) {
            throw new BadRequestException("Empty body: Data is missing");
        } else {
            Person personToUpdate = getChildById(id);
            person.setId(personToUpdate.getId());
            childrenRepository.save(person);
            return person.getId();
        }
    }
}
