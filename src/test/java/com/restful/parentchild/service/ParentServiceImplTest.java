package com.restful.parentchild.service;

import com.restful.parentchild.ParentRepository;
import com.restful.parentchild.exception.ResourceNotFoundException;
import com.restful.parentchild.model.Gender;
import com.restful.parentchild.model.Person;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

@RunWith(SpringRunner.class)
public class ParentServiceImplTest {

    @Autowired
    private ParentService parentService;

    @MockBean
    private ParentRepository parentRepository;

    @Before
    public void setUp() {
        List<Person> parentList = new ArrayList<>();
        parentList.add(new Person(true, "Mr", "John", "Smith",
                "john@smith.com", "1978-07-13", Gender.male, "second name",
                null));

        Mockito.when(parentRepository.findAllParents())
                .thenReturn(parentList);

        Mockito.when(parentRepository.findParentById(99))
                .thenReturn(Optional.of(new Person(true, "Mr", "Peter", "Rabbit",
                        "peter@peter.com", "1978-07-13", Gender.male, "second name",
                        null)));

        Mockito.when(parentRepository.findParentById(-1))
                .thenReturn(Optional.empty());

//        Mockito.when(parentRepository.save(any()))
//                .thenReturn(new Person());
    }

    @Test
    public void getAllParents() {

        List<Person> parentList = parentService.getAllParents();
        assertThat(parentList, Matchers.hasSize(1));
    }

    @Test
    public void getParentById() {

        Person person = parentService.getParentById(99);
        assertThat(person, hasProperty("firstName", Matchers.equalTo("Peter")));
    }


    @Test(expected = ResourceNotFoundException.class)
    public void getParentByWrongId() {
        Person person = parentService.getParentById(-1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void createNewParent_withEmptyBody() {
        Person person = null;
        parentService.createParent(person);
    }

    @TestConfiguration
    static class ParentServiceImplTestContextConfiguration {

        @Bean
        public ParentService parentService() {
            return new ParentServiceImpl();
        }
    }
}