package com.kaizi.dao;




import java.sql.*;

import com.kaizi.db.DBManager;

public class LessonDAO_old {
    public void save() {
        String sql = "insert into lesson(lesName,context,score,hours)values('设计模式','编程34计',4,56)";
        DBManager dbManager = new DBManager();
        int rows = dbManager.update(sql);
        if (rows == 1) {
            System.out.println("新增课程信息成功");
        } else {
            System.out.println("新增课程信息失败");
        }

    }

    public void update() {
        String sql = "update lesson set lesName='设计模式',context='编程孙子兵法',score=5,hours=30   where lesId=19";
        DBManager dbManager = new DBManager();
        int rows = dbManager.update(sql);
        if (rows == 1) {
            System.out.println("修改课程信息成功");
        } else {
            System.out.println("修改课程信息失败");
        }
    }

    public void delete() {
        String sql = "delete from lesson where lesId=7";
        DBManager dbManager = new DBManager();
        int rows = dbManager.update(sql);
        if (rows == 1) {
            System.out.println("删除课程信息成功");
        } else {
            System.out.println("删除课程信息失败");
        }
    }

    public void query() {
        String sql = "select lesId,lesName,context,score,hours from lesson";
        DBManager dbManager = new DBManager();
        ResultSet rs = dbManager.query(sql);
        try {
            while(rs.next()){
               int lesId=rs.getInt(1);
                String lesName=rs.getString(2);
                String context=rs.getString(3);
                int score=rs.getInt(4);
                int hours=rs.getInt(5);
                System.out.println(lesId+","+lesName+","+context+","+score+","+hours);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbManager.close();
        }


    }
}


