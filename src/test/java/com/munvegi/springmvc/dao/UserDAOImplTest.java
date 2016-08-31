package com.munvegi.springmvc.dao;

import com.munvegi.springmvc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;

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
        inOrder.verify(session).save(Matchers.any(User.class));
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

    @Test
    public void findByName() throws Exception {

        // Given
        String name = "John";
        User user = new User();
        user.setName(name);
        Query query = Mockito.mock(Query.class);
        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
        Mockito.when(session.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(user);

        // When
        User actual = userDAO.findByName(name);

        // Then
        Mockito.verify(session).createQuery("from User where name = :name");
        Mockito.verify(query).setParameter("name", name);
        assertThat(actual, is(user));
    }

    @Test
    public void findByName_NoUser_ReturnNull() throws Exception {

        // Given
        String name = "John";
        User user = new User();
        user.setName(name);
        Query query = Mockito.mock(Query.class);
        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
        Mockito.when(session.createQuery(anyString())).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenThrow(new RuntimeException());

        // When
        User actual = userDAO.findByName(name);

        // Then
        Mockito.verify(session).createQuery("from User where name = :name");
        assertNull(actual);
        assertThat(actual, is(nullValue()));
    }
}