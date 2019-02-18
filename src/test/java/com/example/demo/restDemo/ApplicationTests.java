package com.example.demo.restDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUserController() throws Exception {
        RequestBuilder requestBuilder = null;

        requestBuilder = MockMvcRequestBuilders.get("/users/");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        requestBuilder = MockMvcRequestBuilders.post("/users/")
                            .param("id", "1")
                            .param("name", "test")
                            .param("age", "20");
        mockMvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("success")));

        requestBuilder = MockMvcRequestBuilders.put("/users/1")
                .param("name", "testtest")
                .param("age", "30");
        mockMvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("success")));


        requestBuilder = MockMvcRequestBuilders.get("/users/1");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"testtest\",\"age\":30}")));

        requestBuilder = MockMvcRequestBuilders.delete("/users/1");
        mockMvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("success")));

        requestBuilder = MockMvcRequestBuilders.get("/users/");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }
}
