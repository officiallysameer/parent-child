package com.restful.parentchild.service;

import com.restful.parentchild.model.Person;

import java.util.List;
import java.util.Optional;

public interface ParentService {

    List<Person> getAllParents();

    Optional<Person> getParentById(int id);
}
