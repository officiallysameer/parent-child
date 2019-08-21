package com.restful.parentchild;

import com.restful.parentchild.controller.ParentController;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentChildApplicationTests {

    @Autowired
    private ParentController controller;

	@Test
	public void contextLoads() {
        MatcherAssert.assertThat(controller, Matchers.is(notNullValue()));
    }


}
