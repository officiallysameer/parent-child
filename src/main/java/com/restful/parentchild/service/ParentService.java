package com.restful.parentchild.service;

import com.restful.parentchild.model.Person;

public interface ParentService {

    Integer createParent(Person person);

    Person getParentById(int id);

    Integer updateParent(Person person, int id);
}
