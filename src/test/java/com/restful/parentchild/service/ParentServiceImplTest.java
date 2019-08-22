package com.restful.parentchild.service;

import com.restful.parentchild.exception.BadRequestException;
import com.restful.parentchild.exception.ResourceNotFoundException;
import com.restful.parentchild.model.Gender;
import com.restful.parentchild.model.Person;
import com.restful.parentchild.repository.ParentRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ParentServiceImplTest {

    @Autowired
    private ParentService parentService;

    @MockBean
    private ParentRepository parentRepository;

    @Before
    public void setUp() {
        Person savedPerson = new Person(true, "Mr", "Reed", "Croft",
                "reed.croft@bbc.com", "1987-07-13", Gender.male, "second name",
                null);
        savedPerson.setId(11);

        Mockito.when(parentRepository.findParentById(99))
                .thenReturn(Optional.of(new Person(true, "Mr", "Peter", "Rabbit",
                        "peter@peter.com", "1978-07-13", Gender.male, "second name",
                        null)));

        Mockito.when(parentRepository.findParentById(11))
                .thenReturn(Optional.of(savedPerson));

        Mockito.when(parentRepository.findParentById(-1))
                .thenReturn(Optional.empty());

        Mockito.when(parentRepository.save(any()))
                .thenReturn(savedPerson);
    }

    @Test
    public void getParentByIdTest() {

        Person person = parentService.getParentById(99);
        assertThat(person, hasProperty("firstName", Matchers.equalTo("Peter")));
    }


    @Test(expected = ResourceNotFoundException.class)
    public void getParentByWrongIdTest() {

        Person person = parentService.getParentById(-1);
    }

    @Test(expected = BadRequestException.class)
    public void createNewParentWithEmptyBodyTest() {

        Person person = null;
        parentService.createParent(person);
    }

    @Test
    public void updateParentTest() {

        Person person = new Person(true, "Mr", "Peter", "Rabbit",
                "peter@peter.com", "1978-07-13", Gender.male, "second name",
                null);
        Integer updatedId = parentService.updateParent(person, 11);
        assertThat(updatedId, is(11));
    }

    @Test(expected = BadRequestException.class)
    public void updateParentWithEmptyBoodyTest() {

        Person person = null;
        Integer updatedId = parentService.updateParent(person, 11);
    }

    @TestConfiguration
    static class ParentServiceImplTestContextConfiguration {

        @Bean
        public ParentService parentService() {
            return new ParentServiceImpl();
        }
    }
}