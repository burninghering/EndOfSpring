package com.fastcampus.ch3;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class) //ac를 자동으로 만들어줌
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"}) //xml 경로 지정해주기
public class UserDaoImplTest extends TestCase {

    @Autowired
    UserDao userDao;

    @Test
    public void testDeleteUser() {
    }

    @Test
    public void testSelectUser() {
    }

    @Test
    public void testInsertUser() {
    }

    @Test
    public void testUpdateUser() throws Exception{
        Calendar cal = Calendar.getInstance();
        cal.clear(); //모든 시간 필드 초기화
        cal.set(2023,3,29); //날짜만 넣기

        userDao.deleteAll();

        User user = new User("asdf","1111","abc","aaa@aaa.com",new Date(cal.getTimeInMillis()), "fb",new Date());
        int rowCnt=userDao.insertUser(user);
        assertTrue(rowCnt==1);

        user.setPwd("4321");
        user.setEmail("bbb@bbb.com");
        rowCnt=userDao.updateUser(user);
        assertTrue(rowCnt==1);


        User user2 = userDao.selectUser(user.getId());

        System.out.println("user = " + user);
        System.out.println("user2 = " + user2);

        assertTrue(user.equals(user2));

    }
}