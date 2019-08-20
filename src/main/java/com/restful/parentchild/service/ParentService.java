package com.restful.parentchild.service;

import com.restful.parentchild.model.Person;

import java.util.List;

public interface ParentService {

    List<Person> getAllParents();

    Person getParentById(int id);
}
