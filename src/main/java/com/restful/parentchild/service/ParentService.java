package com.restful.parentchild.service;

import com.restful.parentchild.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParentService {

    List<Person> getAllParents();

    Integer createParent(Person person);

    Person getParentById(int id);
}
