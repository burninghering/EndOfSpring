package com.fastcampus.ch3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class) //ac를 자동으로 만들어줌
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"}) //xml 경로 지정해주기
public class A1DaoTest {

    @Autowired
    A1Dao a1Dao;

    @Autowired
    DataSource ds;

    @Autowired
    DataSourceTransactionManager tm;

    @Test
    public void insertTest() throws Exception{
        //TxManager를 생성
//        PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
        TransactionStatus status=tm.getTransaction(new DefaultTransactionDefinition());
        //Tx 시작
        try {
            a1Dao.deleteAll();
            a1Dao.insert(1,100);
            a1Dao.insert(2,200);
            tm.commit(status); //성공하면 커밋
        } catch (Exception e) {
            e.printStackTrace();
            tm.rollback(status); //예외가 발생하면 롤백
        } finally {
        }
    }

}