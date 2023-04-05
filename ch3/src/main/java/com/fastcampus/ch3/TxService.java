package com.fastcampus.ch3;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TxService {

    @Autowired
    A1Dao a1Dao;

    @Autowired
    B1Dao b1Dao;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class) //하나의 트랜잭션 안에 묶임
    public void insertA1WithTx() throws Exception{
        a1Dao.insert(1,100); //성공
        insertB1WithTx();
        a1Dao.insert(2,200); //성공
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void insertB1WithTx() throws Exception {
        b1Dao.insert(1,100); //성공
        b1Dao.insert(2,200); //실패
    }

    public void insertA1WithoutTx() throws Exception{
        a1Dao.insert(1,100);
        a1Dao.insert(1,200);
    }

    @Transactional(rollbackFor = Exception.class) //이 어노테이션이 있어야 Exception과 그 자손들이 롤백이 된다.
//    @Transactional //RuntimeException, Error만 rollback한다.
    public void insertA1WithTxFail() throws Exception{
        a1Dao.insert(1,100); //성공
        a1Dao.insert(1,200); //실패
    }

    @Transactional
    public void insertA1WithTxSuccess() throws Exception{
        a1Dao.insert(1,100);
        a1Dao.insert(2,200);
    }
}
