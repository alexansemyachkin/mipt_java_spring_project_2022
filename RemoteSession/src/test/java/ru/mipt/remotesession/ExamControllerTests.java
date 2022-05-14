package ru.mipt.remotesession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
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
import ru.mipt.remotesession.controllers.ExamController;
import ru.mipt.remotesession.dto.UserDTO;
import ru.mipt.remotesession.models.*;
import ru.mipt.remotesession.service.classes.PossibleAnswersServiceImpl;
import ru.mipt.remotesession.service.classes.QuestionServiceImpl;
import ru.mipt.remotesession.service.classes.SubjectServiceImpl;
import ru.mipt.remotesession.service.classes.UserServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExamControllerTests {
    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Autowired
    private PossibleAnswersServiceImpl possibleAnswersService;

    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private SubjectServiceImpl subjectService;


    @MockBean
    private UserServiceImpl userService;

    @Test
    public void redirectToExam() throws Exception{
        for (Subject subject: subjectService.findAll()) {
            this.mockMvc.perform(get("/home/subjects/subject{subjectId}/exam", subject.getId()))
                    .andExpect(redirectedUrl("exam/test"));
        }
    }

    @Test
    public void examProcessContinues() throws Exception{
        Subject testSubject = subjectService.findSubjectById(1);
        Exam testExam = new Exam();
        testExam.setSubject(testSubject);
        testExam.setQuestionList(testSubject.getQuestionList());
        this.mockMvc.perform(get("/home/subjects/subject{subjectId}/exam/test", testExam.getSubject().getId()).flashAttr("exam", testExam))
                .andExpect(status().isOk())
                .andExpect(model().attribute("exam", testExam))
                .andExpect(view().name("exam"));

    }

    @Test
    public void examProcessFinishes() throws Exception{
        Subject testSubject = subjectService.findSubjectById(1);
        Exam testExam = new Exam();
        testExam.setSubject(testSubject);
        testExam.setQuestionList(testSubject.getQuestionList());
        testExam.setGivenAnswerCounter(testSubject.getQuestionList().size());
        this.mockMvc.perform(get("/home/subjects/subject{subjectId}/exam/test", testExam.getSubject().getId()).flashAttr("exam", testExam))
                .andExpect(status().isOk())
                .andExpect(model().attribute("exam", testExam))
                .andExpect(view().name("exam_completed"));
    }

    @Test
    public void sendRightAnswer() throws Exception{
        Subject testSubject = subjectService.findSubjectById(1);
        Exam testExam = new Exam();
        testExam.setSubject(testSubject);
        testExam.setQuestionList(testSubject.getQuestionList());
        testExam.setGivenAnswerCounter(testSubject.getQuestionList().size());
        testExam.setCurrentQuestion(testExam.getQuestionList().get(1));
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(testExam);
        this.mockMvc.perform(post("/home/subjects/subject{subjectId}/exam/test", testExam.getSubject().getId())
                    .flashAttr("exam", testExam)
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json))
                .andExpect(redirectedUrl("/home/subjects/subject" + testExam.getSubject().getId() + "/exam/test"));
    }

    @Test
    @WithMockUser("test@gmail.com")
    public void examCompleted() throws Exception {
        Subject testSubject = subjectService.findSubjectById(1);
        Exam testExam = new Exam();
        testExam.setSubject(testSubject);
        testExam.setQuestionList(testSubject.getQuestionList());
        testExam.setGivenAnswerCounter(testSubject.getQuestionList().size());
        testExam.setCurrentQuestion(testExam.getQuestionList().get(1));
        User user = new User("name", "email", 120, "password", new ArrayList<>());
        ObjectMapper objectMapper = new ObjectMapper();
        String userJson = objectMapper.writeValueAsString(user);
        String examJson = objectMapper.writeValueAsString(testExam);
        Mockito.when(userService.update(Mockito.any(UserDTO.class))).thenReturn(user);
        this.mockMvc.perform(post("/home/subjects/subject{subjectId}/exam/completed", testExam.getSubject().getId())
                    .sessionAttr("user", user)
                        .flashAttr("exam", testExam)
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(userJson)
                    .content(examJson))
                .andExpect(redirectedUrl("/home"));
    }


}
