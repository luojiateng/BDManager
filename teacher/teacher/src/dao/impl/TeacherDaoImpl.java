package dao.impl;


import dao.TeacherDao;
import org.junit.Test;
import pojo.Teacher;
import utils.JDBC;
import utils.MyDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    @Override
    public int saveTeacher(Teacher teacher) {
        String sql = "insert into teacher  (teacherName, gender, birth, email, deptNumber, postionNumber, titleNumber) VALUES (?,?,?,?,?,?,?)";
        return JDBC.update(sql, teacher.getTeacherName(),
                teacher.getSex(), MyDate.CaseTime(teacher.getBirth()),
                teacher.getEmail(),
                new DeptDaoImpl().getDeptIdByName(teacher.getDeptName()),
                new PostionDaoImpl().getPostIdByName(teacher.getPositionName()),
                new TitleDaoImpl().getTitleIdByName(teacher.getTitlName())
        );
    }

    @Override
    public List<Teacher> getAllTeacher() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        Connection connection = JDBC.getConnection();
        String sql = "select * from teacherinfo ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Teacher teacher = new Teacher(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getDate(4) + "",
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getString(8));
                teachers.add(teacher);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    @Override
    public List<Teacher> getTeacherByName(String name) {
        ArrayList<Teacher> teachers = new ArrayList<>();
        Connection connection = JDBC.getConnection();
        String sql = "select * from teacherinfo where teacherName like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Teacher teacher = new Teacher(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getDate(4) + "",
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getString(8));
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }


    @Override
    public int getNewTeacherId() {
        Connection connection = JDBC.getConnection();
        String sql = "SELECT IF(MAX(teacherNumber) IS NULL, 0, MAX(teacherNumber)) AS maxid FROM teacher;";
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
    public int updataTeacher(Teacher teacher) {
        String sql = "update teacher set teacherName = ? ,gender = ?,birth = ? ,email =?," +
                "deptNumber =?,postionNumber=?,titleNumber =? where teacherNumber =?";


        return JDBC.update(sql,
                teacher.getTeacherName(),
                teacher.getSex(),
                MyDate.CaseTime(teacher.getBirth()),
                teacher.getEmail(),
                new DeptDaoImpl().getDeptIdByName(teacher.getDeptName()),
                new PostionDaoImpl().getPostIdByName(teacher.getPositionName()),
                new TitleDaoImpl().getTitleIdByName(teacher.getTitlName()),
                teacher.getTeacherID()
        );
    }

    @Override
    public int deletTeacherByName(String name) {
        String sql = "delete from teacher where teacherName = ?";
        return JDBC.update(sql, name);
    }
}
