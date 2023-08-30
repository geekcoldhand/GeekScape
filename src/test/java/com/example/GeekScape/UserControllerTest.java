package com.example.GeekScape;

import com.example.GeekScape.user.UserRepo;
import com.example.GeekScape.user.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepo userRepo;


    private MockHttpServletRequestBuilder request;

    @BeforeEach
    void setUp() {
        // Add any necessary setup code here
    }

    @Test
    void whenGetUsers_thenReturnUsers() throws Exception {
        UserType user = new UserType(1L, "john@gmail.com", "John");
        UserType user2 = new UserType(2L, "eli@gmail.com", "Eli");
        // Mock the behavior of userRepo.createUser() method

        Mockito.when(userRepo.createUser(Mockito.any(UserType.class))).thenReturn(0);

        MockHttpServletRequestBuilder request = get("/all-users")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void whenPostUser_thenReturnSavedUser() throws Exception {
        UserType user = new UserType(3L, "Sarah@gmail.com", "sarah");
        // Mock the behavior of userRepo.createUser() method
        Mockito.when(userRepo.createUser(Mockito.any(UserType.class))).thenReturn(1);

        MockHttpServletRequestBuilder request = post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 3, \"email\": \"Sarah@gmail.com\", \"username\": \"sarah\"}");

                mockMvc.perform(request).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(user.getId()))
                .andExpect(jsonPath("$.email").value(user.getEmail()))
                .andExpect(jsonPath("$.username").value(user.getUsername()));
    }

    @Test
    void whenFindUserByID_thenUserFoundById() throws Exception{
        UserType user = new UserType(4L, "eric@gmail.com", "Eric");
        UserType user2 = new UserType(5L, "rashi@gmail.com", "Rashi");
        userRepo.createUser(user);
        userRepo.createUser(user2);

        // Mock the behavior of userRepo.findUserById() method
        Mockito.when(userRepo.findUserById(4L)).thenReturn(user);

        MockHttpServletRequestBuilder request = get("/users/{id}", 4L)
                .contentType(MediaType.APPLICATION_JSON);



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
        Mockito.when(userRepo.createUser(Mockito.any(UserType.class))).thenReturn(1);




    }


}
