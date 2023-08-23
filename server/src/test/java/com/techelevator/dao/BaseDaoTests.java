package com.techelevator.dao;

import com.techelevator.tenmo.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestingDatabaseConfig.class)
public abstract class BaseDaoTests {
    protected static User USER_1;
    protected static User USER_2;
    protected static User USER_3;

    @Before
    public void createUsers(){
        USER_1.setId(1111);
        USER_1.setUsername("username1");
        USER_1.setPassword("abcdefgh");

        USER_2.setId(1112);
        USER_2.setUsername("username2");
        USER_2.setPassword("abcdefgh");

        USER_3.setId(1113);
        USER_3.setUsername("username3");
        USER_3.setPassword("abcdefgh");
    }



    @Autowired
    protected DataSource dataSource;

    /* After each test, we rollback any changes that were made to the database so that
     * everything is clean for the next test */
    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

}
