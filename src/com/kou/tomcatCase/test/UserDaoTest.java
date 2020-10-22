package com.kou.tomcatCase.test;

import com.kou.tomcatCase.dao.UserDao;
import com.kou.tomcatCase.domain.User;
import org.junit.Test;

/**
 * @author JIAJUN KOU
 */
public class UserDaoTest {

    @Test
    public void testLogin(){
        User logUser=new User();
        logUser.setUsername("zhangsan");
        logUser.setPassword("12345");

        UserDao dao=new UserDao();
        User user = dao.login(logUser);
        System.out.println(user);

    }
}
