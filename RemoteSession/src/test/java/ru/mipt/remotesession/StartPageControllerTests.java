package ru.mipt.remotesession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import ru.mipt.remotesession.controllers.StartPageController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StartPageControllerTests {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StartPageController startPageController;

    @Test
    public void redirection() throws Exception{
        this.mockMvc.perform(get("/"))
                .andExpect(redirectedUrl("/start"));
    }

    @Test
    public void startPageView() throws Exception{
        this.mockMvc.perform(get("/start"))
                .andExpect(status().isOk())
                .andExpect(view().name("start"));
    }
}
