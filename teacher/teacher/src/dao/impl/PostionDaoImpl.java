package dao.impl;


import dao.PostionDao;
import jdk.nashorn.internal.scripts.JD;
import org.junit.Test;
import pojo.Postion;
import utils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostionDaoImpl implements PostionDao {

    @Override
    public int insertPostion(String position) {
        String sql = "insert into position ( positionName) VALUES (?)";
        return JDBC.update(sql, position);
    }


    @Override
    public int deletePostion(String name) {
        String sql = "delete from position where positionName =?";
        return JDBC.update(sql, name);
    }

    @Override
    public int updataPostion(String oldPosition, String newPosition) {
        Connection connection = JDBC.getConnection();//获取数据库连接
        //根据旧名称查询id
        String sqla = "select positionNumber from position where positionName = ?";
        int id = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqla);
            preparedStatement.setString(1, oldPosition);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "update position set positionName = ? where positionNumber =?";
        return JDBC.update(sql, newPosition, id);
    }

    @Override
    public List<String> getAllPostionName() {
        ArrayList<String> strings = new ArrayList<>();
        Connection connection = JDBC.getConnection();
        String sql = "select positionName from position";
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


    @Override
    public int getNextIndex() {
        Connection connection = JDBC.getConnection();
        String sql = "SELECT IF(MAX(positionNumber) IS NULL, 0, MAX(positionNumber)) AS maxid FROM position;";
        int id = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id + 1;
    }

    @Override
    public int getPostIdByName(String name) {
        Connection connection = JDBC.getConnection();
        String sql = "select positionNumber from position where positionName =?";
        int id = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
