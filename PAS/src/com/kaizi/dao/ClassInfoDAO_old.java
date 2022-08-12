package com.kaizi.dao;

import java.sql.*;

import com.kaizi.db.DBManager;

public class ClassInfoDAO_old {
    public void save(){
        String sql="insert into ClassInfo(ClsName,grade,stuCount,teaNum)values('计科6班','2020/1/1',38,19800201)";
        DBManager dbManager = new DBManager();
        int rows = dbManager.update(sql);
        if (rows == 1) {
            System.out.println("新增班级信息成功");
        } else {
            System.out.println("新增班级信息失败");
        }

    }
    public void update(){
        String sql="update classInfo set clsName='计类6班',grade='2020/1/1',stuCount=40,teaNum=19800201   where clsId=38";
        DBManager dbManager = new DBManager();
        int rows = dbManager.update(sql);
        if (rows == 1) {
            System.out.println("修改班级信息成功");
        } else {
            System.out.println("修改班级信息失败");
        }

    }
    public void delete(){
        String sql="delete from classInfo where clsId=56";
        DBManager dbManager = new DBManager();
        int rows = dbManager.update(sql);
        if (rows == 1) {
            System.out.println("删除班级信息成功");
        } else {
            System.out.println("删除班级信息失败");
        }

    }
    public void query(){
        String sql = "select clsId,clsName,grade,stuCount,teaNum key1,key2 from classInfo";
        DBManager dbManager = new DBManager();
        ResultSet rs = dbManager.query(sql);
        try {
            while(rs.next()){
                int clsId=rs.getInt(1);
                String clsName=rs.getString(2);
                String grade=rs.getString(3);
                int stuCount=rs.getInt(4);
                int teaNum=rs.getInt(5);
                String key1=rs.getString(6);
                //int key2=rs.getInt(7);
                System.out.println(clsId+","+clsName+","+grade+","+stuCount+","+teaNum+","+key1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbManager.close();
        }


    }

    private class SQLServerDriver {
    }
}
