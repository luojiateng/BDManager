package com.kaizi.test;

import java.util.List;

import com.kaizi.dao.RestPwdDAO;
import com.kaizi.entity.RestPwd;

public class RestPwdDAOTest {
    public static void testSave(){
        String stuNum="202007010103";
        String question1="我是谁";
        String answer1="刘恺暄";
        String question2="我今年多大";
        String answer2="20";
        String question3="我在几班";
        String answer3="计科6班";
        int  requestCount=3;
        RestPwd pwd=new RestPwd(stuNum,question1,answer1,question2,answer2,question3,answer3,requestCount);
        RestPwdDAO restPwdDAO=new RestPwdDAO();
        boolean ok=restPwdDAO.save(pwd);
        if (ok){
            System.out.println("新增密码信息成功");
        }else{
            System.out.println("新增密码信息失败");
        }

    }
    public static  void testUpdate(){
        String stuNum="202007010103";
        String question1="我生日";
        String answer1="2001-1-16";
        String question2="我年龄";
        String answer2="20";
        String question3="我叫啥";
        String answer3="刘恺暄";
        int requestCount=3;
        RestPwd pwd=new RestPwd(stuNum,question1,answer1,question2,answer2,question3,answer3,requestCount);
        RestPwdDAO restPwdDAO=new RestPwdDAO();
        boolean ok=restPwdDAO.update(pwd);
        if(ok){
            System.out.println("修改密码信息成功");
        }
        else{
            System.out.println("修改密码信息失败");
        }
    }
    public static  void testQuery(){
        RestPwdDAO restPwdDAO=new RestPwdDAO();
        List<RestPwd> ts=restPwdDAO.query();
        System.out.println(ts.size());
        for (RestPwd pwd:ts) {
            System.out.println(pwd);
        }
    }
    public static  void testFindById(){
        RestPwdDAO restPwdDAO=new RestPwdDAO();
        RestPwd pwd=restPwdDAO.findById("202007010101");
        System.out.println(pwd);

    }

    public static void main(String[] args) {
       // testSave();
        //testQuery();
       //
        testUpdate();
    }
}
