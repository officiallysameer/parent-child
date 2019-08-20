package com.restful.parentchild.service;

import com.restful.parentchild.ParentRepository;
import com.restful.parentchild.model.Gender;
import com.restful.parentchild.model.Person;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
public class ParentServiceImplTest {

    @Autowired
    private ParentService parentService;

    @MockBean
    private ParentRepository parentRepository;

    @Before
    public void setUp() {
        List<Person> parentList = new ArrayList<>();
        parentList.add(new Person(true, "Mr", "John", "Smith", "john@smith.com",
                "1978-07-13", Gender.male, "second name", null));

        Mockito.when(parentRepository.findAll())
                .thenReturn(parentList);
    }

    @Test
    public void getAllParents() {

        List<Person> parentList = parentService.getAllParents();
        assertThat(parentList, hasSize(1));
    }

    @TestConfiguration
    static class ParentServiceImplTestContextConfiguration {

        @Bean
        public ParentService parentService() {
            return new ParentServiceImpl();
        }
    }
}