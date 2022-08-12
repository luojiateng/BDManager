package com.kaizi.dao;

import java.sql.*;

import com.kaizi.db.DBManager;

public class TeacherDAO_old {
    public void save(){
        String sql="insert into teacher(teaNum,teaName,teaTitle,teaTypeId,teaBtd,pwd,static,roleId)values('19920002','王天航','导员',1,'1992/1/1',1,1,1)";
        DBManager dbManager = new DBManager();
        int rows = dbManager.update(sql);
        if (rows == 1) {
            System.out.println("新增老师信息成功");
        } else {
            System.out.println("新增老师信息失败");
        }



    }
    public void update(){
        String sql="update teacher set teaNum='19920001',teaName='李天太',teaTitle='校长',teaTypeId=1,teaBtd='2001/1/16',pwd=5,static=1,roleId=1   where teaNum=19920001";
        DBManager dbManager = new DBManager();
        int rows = dbManager.update(sql);
        if (rows == 1) {
            System.out.println("修改老师信息成功");
        } else {
            System.out.println("修改老师信息失败");
        }


    }
    public void delete(){
        String sql="delete from teacher where teaNum=19920002";
        DBManager dbManager = new DBManager();
        int rows = dbManager.update(sql);
        if (rows == 1) {
            System.out.println("删除老师信息成功");
        } else {
            System.out.println("删除老师信息失败");
        }


    }
    public void query(){
        String sql = "select teaNum,teaName,teaTitle,teaTypeId,teaBtd pwd,static roleId from teacher";
        DBManager dbManager = new DBManager();
        ResultSet rs = dbManager.query(sql);
        try {
            while(rs.next()){
                int teaNum=rs.getInt(1);
                String teaName=rs.getString(2);
                String teaTitle=rs.getString(3);
                int teaTypeId=rs.getInt(4);
                Date teaBtd=rs.getDate(5);
                String pwd=rs.getString(6);
               // int state=rs.getInt(7);
                //int roleId=rs.getInt(8);
                System.out.println(teaNum+","+teaName+","+teaTitle+","+teaTypeId+","+teaBtd+","+pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbManager.close();
        }


    }

}
