package com.munvegi.springmvc.dao;

import com.munvegi.springmvc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;

/**
 * Created by admin on 18/07/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDAOImplTest {

    @Mock
    private Session session;

    @Mock
    private SessionFactory sessionFactory;

    @InjectMocks
    private UserDAOImpl userDAO;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSave() throws Exception {

        // Given
        User user = new User();
        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
        InOrder inOrder = Mockito.inOrder(sessionFactory, session);

        // When
        userDAO.save(user);

        // Then
        inOrder.verify(sessionFactory).getCurrentSession();
        inOrder.verify(session).persist(Matchers.any(User.class));
    }

    @Test
    public void testFindById() throws Exception {

        // Given
        final int ID = 10;
        User expected = new User();
        expected.setId(ID);
        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
        Mockito.when((session.get(User.class, ID))).thenReturn(expected);

        // When
        User actual = userDAO.findById(ID);

        // Then
        Mockito.verify(session).get(User.class, ID);
        assertThat(actual, is(expected));
    }

    @Test
    public void testDeleteById() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }
}