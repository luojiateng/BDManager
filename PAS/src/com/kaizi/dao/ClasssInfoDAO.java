package com.kaizi.dao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kaizi.db.DBManager;
import com.kaizi.entity.ClassInfo;
import com.kaizi.entity.Lesson;

public class ClasssInfoDAO {
    public boolean save(ClassInfo c){
        String sql="insert into ClassInfo(clsName,grade,stuCount,teaNum,key1,key2)values('" + c.getClsName() + "','2020/1/1',"+c.getStuCount()+",'"+c.getTeaNum()+"','" + c.getKey1() + "',"+c.getKey2()+")";
        DBManager dbManager=new DBManager();
        int rows=dbManager.update(sql);
        return (rows==1);

    }
    public boolean update(ClassInfo c) {
        String sql="update classInfo set clsName= '" + c.getClsName() + "', grade = '2020-01-01', " +
                                        " stuCount = " + c.getStuCount() + ", teaNum = '" + c.getTeaNum() + "', " +
                                        " key1 = '" + c.getKey1() + ", key2 = " + c.getKey2() + "'" +
                                        " where clsId = " + c.getClsId() + "";
        DBManager dbManager=new DBManager();
        return (dbManager.update(sql)==1);

    }

    public boolean delete(ClassInfo c) {
        return false;
    }
    public List<ClassInfo> query(){
        List<ClassInfo> ts=new ArrayList<ClassInfo>();
        String sql="select clsId, clsName, grade, stuCount, teaNum, key1, key2 from classInfo";
        DBManager dbManager=new DBManager();
        ResultSet rs=dbManager.query(sql);
        try {
            while(rs.next()){
                int clsId= rs.getInt("clsId");
                String clsName= rs.getString("clsName");
                Date grade=rs.getDate("grade");
                int stuCount=rs.getInt("stuCount");
                String tesNum=rs.getString("teaNum");
                String key1=rs.getString("key1");
                int key2=rs.getInt("key2");
                ClassInfo c= new ClassInfo(clsId, clsName, grade, stuCount, tesNum,key1,key2);
                ts.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbManager.close();
        }
        return ts;


    }
    public ClassInfo findById(String id){

        String sql="select clsId, clsName, grade, stuCount, teaNum, key1, key2 from classInfo where clsId='" + id + "'";
        ClassInfo c = null;
        DBManager dbManager=new DBManager();
        ResultSet rs=dbManager.query(sql);
        try {
            if(rs.next()){
                int clsId=rs.getInt(1);
                String clsName=rs.getString(2);
                Date grade=rs.getDate(3);
                int stuCount=rs.getInt(4);
                String teaNum=rs.getString(5);
                String key1=rs.getString(6);
                int key2=rs.getInt(7);
                c =new ClassInfo(clsId,clsName,grade,stuCount,teaNum,key1,key2);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbManager.close();
        }
        return c;
    }
    public boolean delete(String id) {
        String  sql="delete from classInfo where clsId='"+id+"'";
        DBManager dbManager=new DBManager();
        return (dbManager.update(sql)==1);


    }

    }

