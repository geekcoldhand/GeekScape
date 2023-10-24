package com.example.GeekScape;

import com.example.GeekScape.user.UserController;
import com.example.GeekScape.user.UserType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Mock
    private UserController userController;

    @Mock
    private UserType userType;

    @Test
    public void testGetAllUsers() {
        var userList = List.of(userType);
        when(userController.getAllUsers()).thenReturn(userList);
        var actual = userController.getAllUsers();
        assert (actual != null);
    }

    @Test
    public void testGetUserFromId(){
        Long id = 11L;
        when(userController.getUserById(id))
                .thenReturn(userType);
        var actual = userController.getUserById(id);
        assert (actual !=null);

    }
}
