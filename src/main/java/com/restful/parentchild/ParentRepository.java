package com.restful.parentchild;

import com.restful.parentchild.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Person, Long> {

    ////TODO modify query
    @Query()
    Person findById(int id);
}
