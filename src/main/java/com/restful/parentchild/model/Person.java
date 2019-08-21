package com.restful.parentchild.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean isParent = Boolean.FALSE;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "second_name")
    private String secondName;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "parent_children",
            joinColumns =
            @JoinColumn(name = "parent_id", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "child_id", referencedColumnName = "ID"))
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Person> children;

    public Person() {
    }

    public Person(boolean isParent, String title, String firstName, String lastName, String emailAddress,
                  String dateOfBirth, Gender gender, String secondName, List<Person> children) {
        this.isParent = isParent;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.secondName = secondName;
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public Boolean isParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender.name();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }
}
