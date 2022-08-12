package dao.impl;


import dao.TitleDao;
import org.junit.Test;
import pojo.Title;
import utils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TitleDaoImpl implements TitleDao {
    @Override
    public int insertTitle(Title title) {
        String sql = "insert into title (titleName) VALUES (?)";
        return JDBC.update(sql, title.getTitleName());

    }

    @Override
    public int deleteTitle(String name) {
        String sql = "delete from title where titleName =?";
        return JDBC.update(sql, name);
    }

    @Override
    public int updataTitle(String oldname, String newname) {
        Connection connection = JDBC.getConnection();//获取数据库连接
        //根据旧名称查询id
        String sqla = "select titleNumber from title where titleName = ?";
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
        String sql = "update department set titleName = ? where titleNumber =?";
        return JDBC.update(sql, newname, id);
    }

    @Override
    public List<String> getAllTitleName() {
        ArrayList<String> strings = new ArrayList<>();
        Connection connection = JDBC.getConnection();
        String sql = "select titleName from title";
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
        String sql = "SELECT IF(MAX(titleNumber) IS NULL, 0, MAX(titleNumber)) AS maxid FROM title;";
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
    public int getTitleIdByName(String name) {
        Connection connection = JDBC.getConnection();
        String sql = "select titleNumber from title where titleName =?";
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
