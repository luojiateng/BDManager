package com.kaizi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kaizi.db.DBManager;
import com.kaizi.entity.CourseArrangement;

public class CourseArrangementDAO {
    public boolean save(CourseArrangement ca){
      String sql="insert into courseArrangement(lesId,teaNum,clsId,year,semester)values(" + ca.getLesId() + "," + ca.getTeaNum() + "," + ca.getClsId() + "," + ca.getYear() + "," + ca.getSemester() + ")";
        DBManager dbManager=new DBManager();
        int rows=dbManager.update(sql);
        return (rows==1);
    }
    public  boolean update(CourseArrangement ca){
         String sql="";
        return false;
    }
    public boolean delete(CourseArrangement ca){
        return false;
    }
    public List<CourseArrangement> query() {
        List<CourseArrangement> ts=new ArrayList<CourseArrangement>();
        String sql="select caId,lesId,teaNum,clsId,year,semester from courseArrangement";
        DBManager dbManager=new DBManager();
        ResultSet rs=dbManager.query(sql);
        try {
            while(rs.next()){
                int caId=rs.getInt(1);
                int lesId= rs.getInt(2);
                String teaNum= rs.getString(3);
                int clsId=rs.getInt(4);
                int year=rs.getInt(5);
                int semester=rs.getInt(6);
                CourseArrangement ca= new CourseArrangement(caId,lesId,teaNum,clsId,year,semester);
                ts.add(ca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbManager.close();
        }
        return ts;


    }
    public CourseArrangement findById(int id){


        String sql="select caId,lesId,teaNum,clsId,year,semester from courseArrangement where caId=" + id + " ";
        CourseArrangement ca = null;
        DBManager dbManager=new DBManager();
        ResultSet rs=dbManager.query(sql);
        try {
            if(rs.next()){
                int caId=rs.getInt(1);
                int lesId= rs.getInt(2);
                String teaNum= rs.getString(3);
                int clsId=rs.getInt(4);
                int year=rs.getInt(5);
                int semester=rs.getInt(6);
                 ca= new CourseArrangement(caId,lesId,teaNum,clsId,year,semester);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbManager.close();
        }
        return ca;
    }



}
