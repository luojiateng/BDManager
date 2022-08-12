package dao.impl;


import dao.SchoolDao;
import org.junit.Test;
import utils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolDaoImpl implements SchoolDao {
    @Override
    public int getSchoolIdByName(String name) {
        String sql = "select schoolNumber from school where schoolName =?";
        int flag = 0;
        ResultSet resultSet;
        Connection connection = JDBC.getConnection();//获取数据库连接
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                flag = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.connectionClose(connection, pstmt);
        }
        return flag;
    }

    @Override
    public List<String> getAllSchoolName() {
        ArrayList<String> strings = new ArrayList<>();
        Connection connection = JDBC.getConnection();
        String sql = "select schoolName from school";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                strings.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strings;
    }

}
