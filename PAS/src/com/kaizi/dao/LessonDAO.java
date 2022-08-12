package com.kaizi.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kaizi.db.DBManager;
import com.kaizi.entity.Lesson;
import com.kaizi.entity.Teacher;

public class LessonDAO {
    public boolean save(Lesson l){
        String sql="insert into lesson(lesName,score,context,hours)values('" + l.getLesName() + "'," + l.getScore() + ",'"+l.getContext()+"',"+l.getHours()+")";
        DBManager dbManager=new DBManager();
        int rows=dbManager.update(sql);
        return (rows==1);
    }
    public boolean update(Lesson l) {
        String sql="update lesson set lesName='" + l.getLesName() + "'," +
                " context='" + l.getContext() + "', score=" + l.getScore() + "," +
                " hours=" + l.getHours() + " where lesId=" + l.getLesId() + " ";
        DBManager dbManager=new DBManager();
        return (dbManager.update(sql)==1);
    }

    public boolean delete(int id) {
        String sql="delete from lesson where lesId="+id+"";
        DBManager dbManager=new DBManager();

        return (dbManager.update(sql)==1);
    }
    public List<Lesson> query(){
        List<Lesson> ts=new ArrayList<Lesson>();
        String sql="select lesId,lesName,score,context, hours from lesson";
        DBManager dbManager=new DBManager();
        ResultSet rs=dbManager.query(sql);
        try {
            while(rs.next()){
                int lesId= rs.getInt("lesId");
                String lesName= rs.getString("lesName");
                String context=rs.getString("context");
                int score=rs.getInt("score");
                int hours =rs.getInt("hours");
                Lesson l= new Lesson(lesId, lesName, context, score, hours);
                ts.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbManager.close();
        }
        return ts;

    }
    public Lesson findById(String id){

        String sql="select lesId,lesName,score,context from lesson where lesId='" + id + "'";
        Lesson l = null;
        DBManager dbManager=new DBManager();
        ResultSet rs=dbManager.query(sql);
        try {
            if(rs.next()){
                int lesId=rs.getInt("lesId");
                String lesName=rs.getString("lesName");

                String context=rs.getString("context");
                int score=rs.getInt("score");
                int hours = rs.getInt(5);
                l =new Lesson(lesId, lesName, context, score, hours);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbManager.close();
        }
        return l;
    }


}
