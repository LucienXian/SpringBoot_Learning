package com.example.demo.hello;

import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class BlogPropertiesTest {
    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void getHello() throws Exception {
        Assert.assertEquals(blogProperties.getName(), "Lucien");
        Assert.assertEquals(blogProperties.getTitle(), "Spring Boot");
    }
}
