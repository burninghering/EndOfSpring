package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class B1Dao {

    @Autowired
    DataSource ds;

    public int insert(int key, int value) throws Exception{
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
//            conn = ds.getConnection();
            conn= DataSourceUtils.getConnection(ds);

            pstmt = conn.prepareStatement("insert into b1 values(?,?)");
            pstmt.setInt(1,key);
            pstmt.setInt(2,value);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
//            close(conn,pstmt); //커넥션을 닫으면 트랜잭션이 종료되므로
            close(pstmt); //pstmt만 닫는다
            DataSourceUtils.releaseConnection(conn,ds); //트랜잭션매니저가 close할지 말지 알아서 판단
        }

    }

    private void close(AutoCloseable... acs) {
        for(AutoCloseable ac :acs)
            try { if(ac!=null) ac.close(); } catch(Exception e) { e.printStackTrace(); }
    }

    public void deleteAll() throws Exception{
        Connection conn = DataSourceUtils.getConnection(ds); //deletAll은 Tx와 별개로 동작하므로, Connection conn = ds.getConnection();으로 해야한다
        String sql="delete from a1";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
        close(pstmt);
    }
}
