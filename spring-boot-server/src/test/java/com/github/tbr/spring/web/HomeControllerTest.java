package com.github.tbr.spring.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController homeController = new HomeController();
        MockMvc mocMvc = MockMvcBuilders.standaloneSetup(homeController).build();
        mocMvc.perform(get("/")).andExpect(MockMvcResultMatchers.view().name("home"));
    }
}
