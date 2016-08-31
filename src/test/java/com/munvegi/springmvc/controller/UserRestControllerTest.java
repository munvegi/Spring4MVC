package com.munvegi.springmvc.controller;

import com.munvegi.springmvc.model.User;
import com.munvegi.springmvc.service.UserService;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by admin on 02/08/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserRestControllerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserRestController controller;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testListAllUsers_emptyList() throws Exception {

        //given

        // when
        ResponseEntity<List<User>> actual = controller.listAllUsers();

        // then
        Mockito.verify(userService).findAllUsers();
        assertThat(actual, is(new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT)));
        assertThat(actual.getStatusCode(), is(HttpStatus.NO_CONTENT));
    }

    @Test
    public void testListAllUsers_nonEmptyList() throws Exception {

        // given
        List<User> users = Arrays.asList(new User());
        Mockito.when(userService.findAllUsers()).thenReturn(users);

        // when
        ResponseEntity<List<User>> actual = controller.listAllUsers();

        // then
        Mockito.verify(userService).findAllUsers();
        assertThat(actual.getBody(), is(users));
        assertThat(actual.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void testGetUser() throws Exception {

    }

    @Test
    public void testCreateUser() throws Exception {

    }

    @Test
    public void testUpdateUser() throws Exception {

    }

    @Test
    public void testDeleteUser() throws Exception {

    }

    @Test
    public void testDeleteAllUsers() throws Exception {

    }
}