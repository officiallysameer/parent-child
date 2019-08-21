package com.restful.parentchild.repository;

import com.restful.parentchild.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Person, Long> {

    @Query(value = "SELECT * FROM Person p  WHERE p.is_parent=true and p.id=(:id)", nativeQuery = true)
    Optional<Person> findParentById(@Param("id") int id);

    @Query(value = "SELECT * FROM Person p  WHERE p.is_parent=true", nativeQuery = true)
    List<Person> findAllParents();
}
