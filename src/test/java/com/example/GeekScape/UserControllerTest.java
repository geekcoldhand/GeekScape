package com.example.GeekScape;

import com.example.GeekScape.user.UserController;
import com.example.GeekScape.user.UserRepo;
import com.example.GeekScape.user.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    private final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private UserRepo userRepo;

    @Mock
    private UserType userType;

    @BeforeEach
    void setUp() {

        userRepo.deleteAll();
    }

    @Test
    void whenFindUserByID_thenReturnUserOfId() throws Exception {
        when(userType.getEmail()).thenReturn("horatious@g.com");
        when(userType.getId()).thenReturn(1L);
        when(userType.getUsername()).thenReturn("horaHarris");

        when(userRepo.findByUsername(anyString())).thenReturn(userType);
        UserType userType1 = new UserType();

        userType1.setEmail("horatious@g.com");
        userType1.setId(1L);
        userType1.setUsername("horaHarris");

        UserType actualResponse = userRepo.createUser(userType1);

        assertNotNull(actualResponse);
        assertEquals("1L",actualResponse.getId());

    }

    @Test
    void whenPostUser_thenReturnSavedUser() throws Exception {

        //arrange
        UserType user = new UserType(3L, "Sarah@gmail.com", "sarah");

        //act
        // Mock the behavior of userRepo.createUser() method
        when(userRepo.createUser(Mockito.any(UserType.class))).thenReturn(user);
        //assertion
        MockHttpServletRequestBuilder request = post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(user));

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.email").value("Sarah@gmail.com"))
                .andExpect(jsonPath("$.username").value("sarah"));

        // Verify that the userRepo.createUser() method was called with the correct argument
        Mockito.verify(userRepo).createUser(Mockito.any(UserType.class));

        // Verify that the userRepo.findUserById() method was called with the correct argument
        Mockito.verify(userRepo).findUserById(3L);
    }


    @Test
    void whenGetAllUser_thenReturnAllUsers() throws Exception {
        UserType user = new UserType(3L, "Sarah@gmail.com", "sarah");
        UserType user1 = new UserType(4L, "eric@gmail.com", "Eric");
        UserType user2 = new UserType(5L, "rashi@gmail.com", "Rashi");
        userRepo.createUser(user);
        userRepo.createUser(user1);
        userRepo.createUser(user2);
        // Mock the behavior of userRepo.createUser() method
        when(userRepo.createUser(Mockito.any(UserType.class))).thenReturn(user);




    }


}
