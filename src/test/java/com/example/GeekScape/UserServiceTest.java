package com.example.GeekScape;

import com.example.GeekScape.user.UserService;
import com.example.GeekScape.user.UserType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


    @Mock
    private UserService userService;
    @Mock
    private UserType userType;


    @BeforeEach
    void setUp() {

    }

    @Test
    void whenFindUserByID_thenReturnUserOfId() throws Exception {
        var userId = 3L;
        userType.setId(3L);

        when(userType.getId()).thenReturn(userId);
        when(userService.getById(userId)).thenReturn(userType);

        assertThat(userType.getId()).isEqualTo(3L);
        assertThat(userService.getById(userId)).isEqualTo(userType);

    }

    @Test
    void whenPostUser_thenReturnSavedUser() throws Exception {
        userType.setEmail("horatious@g.com");
        userType.setId(3L);

        var userTypeName = "horaHarris";

        when(userType.getUsername()).thenReturn(userTypeName);
        assertThat("horaHarris").isEqualTo(userType.getUsername());
    }


    @Test
    void whenGetAllUser_thenReturnAllUsers() throws Exception {
        var allUsers = List.of(userType);

        when(userService.add(any(UserType.class))).thenReturn(userType);
        when(userService.allUsers()).thenReturn(allUsers);

        assertThat(userService.add(userType)).isEqualTo(userType);
        assertThat(userService.allUsers()).isEqualTo(allUsers);


    }


}
