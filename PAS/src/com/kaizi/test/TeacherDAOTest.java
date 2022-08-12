package com.kaizi.test;

import java.util.Date;
import java.util.List;

import com.kaizi.dao.TeacherDAO;
import com.kaizi.entity.Teacher;

public class TeacherDAOTest {
    public static  void testSave(){
        String teaNum="20211001";
        String teaName="宋江";
        String teaTitle="教授";
        int teaTypeId=1;
        Date teaBtd=null;
        String pwd ="123";
        int state=1;
        int roleId=0;
        String key1="";
        int key2=0;
        Teacher t=new Teacher(teaNum,teaName,teaTitle,teaTypeId,teaBtd,pwd,state,roleId,key1,key2);
        TeacherDAO teacherDAO=new TeacherDAO();
       boolean ok= teacherDAO.save(t);
       if (ok){
           System.out.println("新增老师信息成功");
       }else{
           System.out.println("新增老师信息失败");
       }

    }
    public static  void testUpdate(){
        String teaNum="20211001";
        String teaName="小宋";
        String teaTitle="助教 ";
        int teaTypId=1;
        Date teaBtd=null;
        String pwd ="123";
        int state=1;
        int roleId=0;
        String key1="";
        int key2=0;
        Teacher t=new Teacher(teaNum,teaName,teaTitle,teaTypId,teaBtd,pwd,state,roleId,key1,key2);
        TeacherDAO teacherDAO=new TeacherDAO();
        boolean ok=teacherDAO.update(t);
        if(ok){
            System.out.println("修改老师信息成功");
        }
        else{
            System.out.println("修改老师信息失败");
        }

        }

    public static  void testDelete(){
        TeacherDAO teacherDAO=new TeacherDAO();
      boolean ok=teacherDAO.delete("20211001");
        if(ok){
            System.out.println("删除老师信息成功");
        }
        else{
            System.out.println("删除老师信息失败");
        }

    }
    public static  void testFindById(){
        TeacherDAO teacherDAO=new TeacherDAO();
        Teacher t= teacherDAO.findById("19800402");
        System.out.println(t);

    }
    public static  void testQuery(){
        TeacherDAO teacherDAO=new TeacherDAO();
        List<Teacher> ts=teacherDAO.findAll();
        System.out.println(ts.size());
        for (Teacher t:ts) {
            System.out.println(t);

        }

    }
    public static void main(String[] args) {
        //testSave();
        testQuery();
        //testFindById();
       //testUpdate();
        //testDelete();
    }
}
