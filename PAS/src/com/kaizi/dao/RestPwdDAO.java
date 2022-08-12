package com.kaizi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kaizi.db.DBManager;
import com.kaizi.entity.RestPwd;
import com.kaizi.entity.Teacher;

public class RestPwdDAO {
    public boolean save(RestPwd pwd){
        String sql="insert into RestPwd(stuNum,question1,answer1,question2,answer2,question3,answer3,requestCount)values" +
                "('"+pwd.getStuNum()+"','"+pwd.getQuestion1()+"','"+pwd.getAnswer1()+"','"+pwd.getQuestion2()+"','"+pwd.getAnswer2()+"','"+pwd.getQuestion3()+"','"+pwd.getAnswer3()+"','"+pwd.getRequestCount()+"')";
        DBManager dbManager=new DBManager();
        int rows=dbManager.update(sql);
        return (rows==1);
    }
    public boolean update(RestPwd pwd) {
        String sql="update restPwd set stuNum='" + pwd.getStuNum() + "', question1='" + pwd.getQuestion1() + "', " +
                "answer1='" + pwd.getAnswer1() + "', question2='" + pwd.getQuestion2() + "', answer2='" + pwd.getAnswer2() + "'," +
                "question3='" + pwd.getQuestion3() + "', answer3='" + pwd.getQuestion3() + "', requestCount=" + pwd.getRequestCount() + " ";
        DBManager dbManager=new DBManager();
        return (dbManager.update(sql)==1);
    }

    public boolean delete(RestPwd pwd) {
        return false;
    }
   public List<RestPwd> query(){
       List<RestPwd> ts=new ArrayList<RestPwd>();
        String sql="select stuNum,question1,answer1,question2,answer2,question3,answer3,requestCount from restPwd";
        DBManager dbManager=new DBManager();
       ResultSet rs=dbManager.query(sql);
       {
           try {
               while(rs.next()){
                   String stuNum=rs.getString(1);
                   String question1=rs.getString(2);
                   String answer1=rs.getString(3);
                   String question2=rs.getString(4);
                   String answer2=rs.getString(5);
                   String question3=rs.getString(6);
                   String answer3=rs.getString(7);
                   int requestCount=rs.getInt(8);
                   RestPwd pwd=new RestPwd(stuNum,question1,answer1,question2,answer2,question3,answer3,requestCount);
                   ts.add(pwd);
               }

           } catch (SQLException e) {
               e.printStackTrace();
           }finally {
               dbManager.close();
           }
           return ts;

       }

    }
    public RestPwd findById(String id){
        RestPwd pwd=null;
        String sql="select stuNum,question1,answer1,question2,answer2,question3,answer3,requestCount from restPwd where stuNum='"+id+"'";
        DBManager dbManager=new DBManager();
        ResultSet rs=dbManager.query(sql);
        try {
            if(rs.next()){
                String stuNum=rs.getString(1);
                String question1=rs.getString(2);
                String answer1=rs.getString(3);
                String question2=rs.getString(4);
                String answer2=rs.getString(5);
                String question3=rs.getString(6);
                String answer3=rs.getString(7);
                int requestCount=rs.getInt(8);
                pwd=new RestPwd(stuNum,question1,answer1,question2,answer2,question3,answer3,requestCount);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pwd;

    }
}

