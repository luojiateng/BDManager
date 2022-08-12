package com.kaizi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.kaizi.db.DBManager;
import com.kaizi.entity.Teacher;

public class TeacherDAO {
    public boolean save(Teacher t) {
        String sql="insert into teacher " +
                "  (teaNum,teaName,teaTitle,teaTypeId,teaBtd, " +
                "pwd,state,roleId,key1,key2) " +
                "values "+
                "   ('" + t.getTeaNum() + "','" +  t.getTeaName() + "'," +
                "'" + t.getTeaTitle() + "'," + t.getTeaTypeId() + "," +
                " '1980-6-2','" + t.getPwd() + "', " + t.getState() + "," +
                " " + t.getRoleId() + ", '" + t.getKey1() + "', " + t.getKey2() + ")";
        DBManager dbManager=new DBManager();
        int rows=dbManager.update(sql);
        return (rows==1);

    }

    public boolean update(Teacher t) {
        String sql="update  teacher set teaName='" + t.getTeaName() + "'," +
                        " teaTitle='" + t.getTeaTitle() + "',teaTypeId="+t.getTeaTypeId()+"," +
                        " teaBtd='2001/1/1',pwd='"+t.getPwd()+"',state="+t.getState()+"," +
                        " roleId="+t.getRoleId()+",key1='"+t.getKey1()+"',key2="+t.getKey2()+" " +
                        " where teanum='"+t.getTeaNum()+"'";
        DBManager dbManager=new DBManager();
       return (dbManager.update(sql)==1);


    }


    public List<Teacher> findAll() {
        List<Teacher> ts=new ArrayList<Teacher>();
        String sql=" select" +
                " teaNum, teaName, teatitle, teatypeid ,teabtd, " +
                "  pwd, state,roleId, key1, key2" +
                " from" +
                "  teacher";
        DBManager dbManager=new DBManager();
        ResultSet rs=dbManager.query(sql);
        try {
            while(rs.next()){
                String teaNum=rs.getString("teaNum");
                String teaName=rs.getString("teaName");
                String teaTitle=rs.getString("teaTitle");
                int teaTypId=rs.getInt("teaTypeId");
                Date teaBtd=rs.getDate("teaBtd");
                String pwd =rs.getString("pwd");
                int state=rs.getInt("state");
                int roleId=rs.getInt("roleId");
                String key1=rs.getString("key1");
                int key2=rs.getInt("key2");
               Teacher t=new Teacher(teaNum,teaName,teaTitle,teaTypId,teaBtd,pwd,state,roleId, key1,key2);
                ts.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbManager.close();
        }
        return ts;

    }
    public int  getRowCount() {
    	
    	int rowCount=0;
    	String sql="select count(*) from teacher";
    	DBManager dbManager=new DBManager();
    	ResultSet rs=dbManager.query(sql);
    	try {
			if(rs.next()) {
				rowCount=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return rowCount;
    }
    public int getPageCount(int pageSize) {
    	
    	int pageCount=0;
    	int rowCount=getRowCount();
    	pageCount=rowCount/pageSize;
    	if(rowCount%pageSize!=0) pageCount++;
    	return pageCount;
    }
    public List<Teacher> getNowPageData(int nowPage,int pageSize){
    	List<Teacher> ts=new ArrayList<Teacher>();
        String sql=" select" +
                " teaNum, teaName, teatitle, teatypeid ,teabtd, " +
                "  pwd, state,roleId, key1, key2" +
                " from" +
                "  teacher "
                + "LIMIT " + (nowPage-1) * pageSize+ ", " + pageSize;
        DBManager dbManager=new DBManager();
        ResultSet rs=dbManager.query(sql);
        try {
            while(rs.next()){
                String teaNum=rs.getString("teaNum");
                String teaName=rs.getString("teaName");
                String teaTitle=rs.getString("teaTitle");
                int teaTypId=rs.getInt("teaTypeId");
                Date teaBtd=rs.getDate("teaBtd");
                String pwd =rs.getString("pwd");
                int state=rs.getInt("state");
                int roleId=rs.getInt("roleId");
                String key1=rs.getString("key1");
                int key2=rs.getInt("key2");
               Teacher t=new Teacher(teaNum,teaName,teaTitle,teaTypId,teaBtd,pwd,state,roleId, key1,key2);
                ts.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbManager.close();
        }
        return ts;
 
    	
    }
    public Teacher findById(String id){
        Teacher t=null;
        String sql=" select" +
                " teaNum, teaName, teatitle, teatypeid ,teabtd, " +
                "  pwd, state,roleId, key1, key2" +
                " from" +
                "  teacher where " +
                "teaNum='" + id + "'";

        DBManager dbManager=new DBManager();
        ResultSet rs=dbManager.query(sql);
        try {
            if(rs.next()){
                String teaNum=rs.getString("teaNum");
                String teaName=rs.getString("teaName");
                String teaTitle=rs.getString("teaTitle");
                int teaTypId=rs.getInt("teaTypeId");
                Date teaBtd=rs.getDate("teaBtd");
                String pwd =rs.getString("pwd");
                int state=rs.getInt("state");
               int roleId=rs.getInt("roleId");
                String key1=rs.getString("key1");
                int key2=rs.getInt("key2");

                t=new Teacher(teaNum,teaName,teaTitle,teaTypId,teaBtd,pwd,state,roleId, key1,key2);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbManager.close();
        }
        return t;
    }

    public boolean delete(String id) {
        String  sql="delete from teacher where teaNum='"+id+"'";
        DBManager dbManager=new DBManager();
        return (dbManager.update(sql)==1);


    }
}
