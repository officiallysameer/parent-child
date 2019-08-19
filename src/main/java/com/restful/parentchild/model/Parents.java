package com.restful.parentchild.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity
public class Parents {

    @Id
    private String id;
    private String title;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "second_name")
    private String secondName;

    @OneToMany
    @JoinTable(name = "children",
            joinColumns =
            @JoinColumn(name = "parent_id", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "child_id", referencedColumnName = "ID"))
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Parents> children;

    public Parents(String title, String firstName, String lastName, String emailAddress, String dateOfBirth, String secondName, List<Parents> children) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.secondName = secondName;
        this.children = children;
    }

    public String getId() {
        return id;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Parents> getChildren() {
        return children;
    }

    public void setChildren(List<Parents> children) {
        this.children = children;
    }
}
