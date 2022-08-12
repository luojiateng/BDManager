package dao.impl;


import dao.DeptDao;
import org.junit.Test;
import pojo.Department;
import utils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {

    @Override
    public int insertDept(Department department) {
        String sql = "insert into department (deptName) VALUES (?)";
        return JDBC.update(sql, department.getDeptName());
    }

    @Override
    public int deleteDept(String name) {
        String sql = "delete from department where deptName = ?";
        return JDBC.update(sql, name);
    }

    @Override
    public int updataDept(String oldname, String newDepName) {
        Connection connection = JDBC.getConnection();//获取数据库连接
        //根据旧名称查询id
        String sqla = "select deptNumber from department where deptName = ?";
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
        String sql = "update department set deptName = ? where deptNumber =?";
        return JDBC.update(sql, newDepName, id);
    }

    @Override
    public List<String> getAllDeptName() {
        ArrayList<String> strings = new ArrayList<>();
        Connection connection = JDBC.getConnection();
        String sql = "select deptName from department";
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
    public List<Department> getAllDeptInfo(String name) {
        ArrayList<Department> departments = new ArrayList<>();
        Connection connection = JDBC.getConnection();
        String sql = "call deptInfo(?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Department department = new Department(resultSet.getInt(1), resultSet.getString(2)
                        , resultSet.getString(3), resultSet.getInt(4));
                departments.add(department);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }


    @Override
    public int getDeptIdByName(String name) {
        Connection connection = JDBC.getConnection();
        String sql = "select deptNumber from department where deptName =?";
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


    @Override
    public int getNextIndex() {
        Connection connection = JDBC.getConnection();
        String sql = "SELECT IF(MAX(deptNumber) IS NULL, 0, MAX(deptNumber)) AS maxid FROM department;";
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
}
