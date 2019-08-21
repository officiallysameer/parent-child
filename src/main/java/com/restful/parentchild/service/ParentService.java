package com.restful.parentchild.service;

import com.restful.parentchild.model.Person;

import java.util.List;

public interface ParentService {

    List<Person> getAllParents();

    Integer createParent(Person person);

    Person getParentById(int id);

    Integer updateParent(Person person, int id);
}
