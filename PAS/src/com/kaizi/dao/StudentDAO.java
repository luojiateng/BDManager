package com.kaizi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kaizi.db.DBManager;
import com.kaizi.entity.Student;
import com.kaizi.entity.Teacher;

public class StudentDAO {
    public boolean update(Student s) {
        String sql="update  student set  clsId= " + s.getClsId() + " ,stuName='" + s.getStuName() + "'," +
                "stuBtd='2001-1-16',pwd='" + s.getPwd() + "',state=" + s.getState() + ",sex=" + s.getSex() + "," +
                "roleId=" + s.getRoleId() + ",key1='" + s.getKey1() + "',key2=" + s.getKey2() + " where stuNum='" + s.getStuNum() + "' ";
        DBManager dbManager=new DBManager();
        return (dbManager.update(sql)==1);


    }

    public boolean save(Student s) {
        String sql = "insert into student " +
                "  (stuNum,clsId,stuName,stuBtd,pwd, " +
                "state,sex,roleId,key1,key2) " +
                "values " +
                "   ('" + s.getStuNum() + "','" + s.getClsId() + "'," +
                "'" + s.getStuName() + "', '2001-1-16' ," +
                " '" + s.getPwd() + "', " + s.getState() + ", " + s.getSex() + "," +
                " " + s.getState() + ", '" + s.getKey1() + "', " + s.getKey2() + ")";
        DBManager dbManager = new DBManager();
        int rows = dbManager.update(sql);
        return (rows == 1);

    }

    public static boolean delete(String id) {
        String sql = "delete from student where stuNum='" + id + "'";
        DBManager dbManager = new DBManager();
        return (dbManager.update(sql) == 1);
    }
    public static List<Student> findAll() {
        List<Student> ts=new ArrayList<Student>();
        String sql=" select" +
                " stuNum, clsId , stuName, stuBtd ,pwd, " +
                "  state,sex,roleId, key1, key2" +
                " from" +
                "  student";
        DBManager dbManager=new DBManager();
        ResultSet rs=dbManager.query(sql);
        try {
            while(rs.next()){
                String stuNum=rs.getString(1);
                int clsId=rs.getInt(2);
                String stuName=rs.getString(3);
                Date stuBtd=rs.getDate(4);
                String pwd =rs.getString(5);
                int  state=rs.getInt(6);
                int sex=rs.getInt(7);
                int roleId=rs.getInt(8);
                String key1=rs.getString(9);
                int key2=rs.getInt(10);
                Student s=new Student(stuNum,clsId,stuName, (java.sql.Date) stuBtd,pwd,state,sex,roleId, key1,key2);
                ts.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbManager.close();
        }
        return ts;

    }
    public Student findById(String id){
        Student s=null;
        String sql=" select" +
                "  stuNum, clsId, stuName, stuBtd , pwd , " +
                "  state,sex,roleId, key1, key2" +
                "  from " +
                "  student where " +
                "  stuNum='" + id + "'";

        DBManager dbManager=new DBManager();
        ResultSet rs=dbManager.query(sql);
        try {
            if(rs.next()){
                String stuNum=rs.getString(1);
                int clsId=rs.getInt(2);
                String stuName=rs.getString(3);
                Date stuBtd=rs.getDate(4);
                String pwd =rs.getString(5);
                int  state=rs.getInt(6);
                int sex=rs.getInt(7);
                int roleId=rs.getInt(8);
                String key1=rs.getString(9);
                int key2=rs.getInt(10);
                s=new Student(stuNum,clsId,stuName, (java.sql.Date) stuBtd,pwd,state,sex,roleId, key1,key2);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbManager.close();
        }
        return s;
    }
}
