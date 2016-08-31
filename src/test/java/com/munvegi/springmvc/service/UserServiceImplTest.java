package com.munvegi.springmvc.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;

import com.munvegi.springmvc.dao.UserDAO;
import com.munvegi.springmvc.model.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 15/07/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindAllUsers() throws Exception { // BDD style

        // Given
        List<User> expected = Arrays.asList(new User());
        BDDMockito.given(userDAO.findAll()).willReturn(expected);

        // When
        List<User> actual = userService.findAllUsers();

        // Then
        Mockito.verify(userDAO).findAll();
        assertThat(actual, is(expected));
    }

    @Test
    public void testFindById() throws Exception {

        final int ID = 1;
        final User user = new User(ID, "John", 30, BigDecimal.TEN );
        // stubbing
        Mockito.when(userDAO.findById(Matchers.anyInt())).thenReturn(user); // Argument matcher

        User actual = userService.findById(ID);

        // Verification
        Mockito.verify(userDAO, times(1)).findById(ID);

        assertThat(actual, is(user));
    }

    @Test
    public void testFindByName() throws Exception {

    }

    @Test
    public void testSaveUser() throws Exception {

        User user = new User(1, "John", 30, BigDecimal.TEN );

        userService.saveUser(user);

        Mockito.verify(userDAO).save(user);
    }

    @Test
    public void testUpdateUser() throws Exception {

        User user = new User(1, "John", 30, BigDecimal.TEN);

        userService.updateUser(user);

        Mockito.verify(userDAO).update(user);
    }

    @Test
    public void testDeleteUserById() throws Exception {

        int ID = 11;

        userService.deleteUserById(ID);

        Mockito.verify(userDAO).deleteById(ID);
        Mockito.verifyNoMoreInteractions(userDAO);
//        Mockito.verifyZeroInteractions(userDAO);
    }

    @Test
    public void testIsUserExist() throws Exception {

        User user = new User(1, "John", 30, BigDecimal.TEN );
        UserServiceImpl spy = Mockito.spy(userService);

        spy.isUserExist(user);

        Mockito.verify(spy).findByName(user.getName());
    }

    @Test
    public void testDeleteAllUsers() throws Exception {

    }
}