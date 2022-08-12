package com.kaizi.test;

import java.sql.Date;
import java.util.List;

import com.kaizi.dao.StudentDAO;
import com.kaizi.dao.TeacherDAO;
import com.kaizi.entity.Student;
import com.kaizi.entity.Teacher;

public class StudentDAOTest {
    public static  void testSave(){
        String stuNum="202110018";
        int clsId=59;
        String stuName="刘恺暄";
        Date stuBtd=null;
        String pwd ="123";
        int state=1;
        int sex=1;
        int roleId=0;
        String key1="";
        int key2=0;
        Student s=new Student(stuNum,clsId,stuName,stuBtd,pwd,state,sex,roleId,key1,key2);
        StudentDAO studentDAO=new StudentDAO();
        boolean ok= studentDAO.save(s);
        if (ok){
            System.out.println("新增学生信息成功");
        }else{
            System.out.println("新增学生信息失败");
        }


    }
    public static  void testDelete(){
        StudentDAO studentDAO=new StudentDAO();
        boolean ok=StudentDAO.delete("20211001    ");
        if(ok){
            System.out.println("删除学生信息成功");
        }
        else{
            System.out.println("删除学生信息失败");
        }

    }
    public static  void testUpdate(){
        String stuNum="20211001    ";
        int clsId=38;
        String stuName="lkz";
        Date stuBtd=null;
        String pwd ="321";
        int state=1;
        int sex= 1;
        int roleId=0;
        String key1="";
        int key2=0;
        Student s=new Student(stuNum,clsId,stuName,stuBtd,pwd,state,sex,roleId,key1,key2);
        StudentDAO studentDAO=new StudentDAO();
        boolean ok=studentDAO.update(s);
        if(ok){
            System.out.println("修改学生信息成功");
        }
        else{
            System.out.println("修改学生信息失败");
        }

    }
    public static  void testFindAll(){
        StudentDAO studentDAO=new StudentDAO();
        List<Student> ts=StudentDAO.findAll();
        System.out.println(ts.size());
        for (Student s:ts) {
            System.out.println(s);
        }
    }
    public static  void testFindById(){
        StudentDAO studentDAO=new StudentDAO();
        Student s= studentDAO.findById("202007030329");
        System.out.println(s);

    }


    public static void main(String[] args) {
        //testSave();
        //testDelete();
        //testUpdate();
        //testFindAll();
        testFindById();
    }

}
