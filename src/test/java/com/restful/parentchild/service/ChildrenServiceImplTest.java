package com.restful.parentchild.service;

import com.restful.parentchild.exception.BadRequestException;
import com.restful.parentchild.exception.ResourceNotFoundException;
import com.restful.parentchild.model.Gender;
import com.restful.parentchild.model.Person;
import com.restful.parentchild.repository.ChildrenRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ChildrenServiceImplTest {

    @Autowired
    private ChildrenService childrenService;

    @MockBean
    private ChildrenRepository childrenRepository;

    @Before
    public void setUp() {
        Person savedChild = new Person(false, null, "Little", "George",
                "george@little.com", "2007-07-13", Gender.male, "second name",
                null);
        savedChild.setId(11);

        Mockito.when(childrenRepository.findChildById(11))
                .thenReturn(Optional.of(savedChild));

        Mockito.when(childrenRepository.findChildById(-1))
                .thenReturn(Optional.empty());

        Mockito.when(childrenRepository.save(any()))
                .thenReturn(savedChild);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void updateChildWithWrongId() {
        Person person = new Person(false, null, "Peppa", "Pig",
                "peppa.pig@sty.com", "2010-07-13", Gender.female, "second name",
                null);
        Integer updatedId = childrenService.updateChild(person, -1);
    }

    @Test
    public void updateChildTest() {

        Person person = new Person(false, null, "Peppa", "Pig",
                "peppa.pig@sty.com", "2010-07-13", Gender.female, "second name",
                null);
        Integer updatedId = childrenService.updateChild(person, 11);
        assertThat(updatedId, is(11));
    }

    @Test(expected = BadRequestException.class)
    public void updateParentWithEmptyBoodyTest() {

        Person person = null;
        Integer updatedId = childrenService.updateChild(person, 11);
    }
}