package com.restful.parentchild.repository;

import com.restful.parentchild.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChildrenRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT * FROM Person p  WHERE p.is_parent=false and p.id=(:id)", nativeQuery = true)
    Optional<Person> findChildById(@Param("id") int id);

}