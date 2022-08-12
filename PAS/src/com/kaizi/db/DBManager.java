package com.kaizi.db;




import java.sql.*;

public class  DBManager {
    private Connection con =null;
    private Statement sta =null;
    private ResultSet rs=null;
    public int update(String sql){
        System.out.println(sql);
        int rows=0;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/pas";
            con= DriverManager.getConnection(url,"root","abc123");
            sta=con.createStatement();
            rows=sta.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            this.close();
        }
        return rows;
    }
    public ResultSet query(String sql){
        System.out.println(sql);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/pas";
            con= DriverManager.getConnection(url,"root","abc123");
            sta=con.createStatement();
             rs=sta.executeQuery(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rs;
    }
    public  void  close(){
        try {
            if(rs!=null){
                rs.close();
                rs=null;
            }
            if(sta!=null){
                sta.close();
                sta=null;
            }
            if(con!=null){
                con.close();
                con=null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
