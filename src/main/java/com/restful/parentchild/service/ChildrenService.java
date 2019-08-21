package com.restful.parentchild.service;

import com.restful.parentchild.model.Person;

public interface ChildrenService {

    Person getChildById(int id);

    Integer updateChild(Person person, int id);
}
