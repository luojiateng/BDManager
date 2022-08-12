package peopleManager.dao;


import peopleManager.bean.Department;
import peopleManager.utils.DBConnected;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TitleDao {
    DBConnected dbUtil = new DBConnected();
    Connection connection = null;
    PreparedStatement pstmt = null;

    public int insert(String name) {
        connection = dbUtil.getConnection();
        int i = 0;
        String sql = "insert into people.title (titleName) VALUES (?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return i;
    }

    public int delete(String name) {
        String sql = "delete from people.title where titleName=?";
        int flag = -1;
        connection = dbUtil.getConnection();//获取数据库连接
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }


    public int updata(String oldname, String newname) {
        connection = dbUtil.getConnection();//获取数据库连接
        //根据旧名称查询id
        String sqla = "select titleId from people.title where titleName = ?";
        int id = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqla);
            preparedStatement.setString(1, oldname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //根据id对名称进行修改
        String sql = "update people.title set titleName = ? where titleId=?";
        int flag = -1;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, newname);
            pstmt.setInt(2, id);
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }


    /**
     * 得到职称名称
     */
    public List<String> getTitleName() {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from people.title ";
        List<String> titltNames = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                String titltName = resultSet.getString(2);
                titltNames.add(titltName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return titltNames;
    }

    /**
     * 返回主键最大加一
     */
    public int getIndex() {
        String sql = "SELECT IF(MAX(titleId) IS NULL, 0, MAX(titleId)) AS maxid FROM people.title;";
        connection = dbUtil.getConnection();//获取数据库连接
        ResultSet resultSet = null;
        int flag = 0;
        try {
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                flag = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag + 1;
    }

}
