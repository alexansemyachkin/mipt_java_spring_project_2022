package ru.mipt.remotesession;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.mipt.remotesession.dto.QuestionDTO;
import ru.mipt.remotesession.dto.SubjectDTO;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.models.PossibleAnswers;
import ru.mipt.remotesession.models.Question;
import ru.mipt.remotesession.models.Subject;
import ru.mipt.remotesession.models.User;
import ru.mipt.remotesession.service.classes.QuestionServiceImpl;
import ru.mipt.remotesession.service.classes.SubjectServiceImpl;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminHomePageControllerTests {
    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    QuestionServiceImpl questionService;

    @MockBean
    SubjectServiceImpl subjectService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @WithUserDetails("admin@phystech.edu")
    public void homePageViewUser() throws Exception {
        this.mockMvc.perform(get("/admin/home"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin_home"));
    }

    @Test
    @WithMockUser("admin@phystech.edu")
    public void addSubject() throws Exception{
        Subject subject = new Subject("test");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(subject);
        Mockito.when(subjectService.save(Mockito.any(SubjectDTO.class))).thenReturn(subject);
        this.mockMvc.perform(post("/admin/home/addSubject")
                        .flashAttr("subject", subject)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(redirectedUrl("/admin/home"));
    }

    @Test
    @WithMockUser("admin@phystech.edu")
    public void addQuestion() throws Exception{
        Subject subject = new Subject("testSubject");
        Question question = new Question("toAnswer", 1, subject, null);
        PossibleAnswers possibleAnswers= new PossibleAnswers("test1", "test2", "test3", "test4", question);
        question.setPossibleAnswers(possibleAnswers);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(question);
        Mockito.when(questionService.save(Mockito.any(QuestionDTO.class))).thenReturn(question);
        this.mockMvc.perform(post("/admin/home/addQuestion")
                        .flashAttr("question", question)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(redirectedUrl("/admin/home"));
    }
}
