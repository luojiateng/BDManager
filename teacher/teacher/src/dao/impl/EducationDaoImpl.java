package dao.impl;


import dao.EducationDao;
import pojo.Education;
import utils.JDBC;
import utils.MyDate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EducationDaoImpl implements EducationDao {

    @Override
    public int saveTeacherEdu(Education education) {
        Connection connection = JDBC.getConnection();
        PreparedStatement pstmt = null;
        int i = 0;
        String sql = "insert into education_exper (teacherNumber, educationNumber, schoolNumber, begin, end) VALUES (?,?,?,?,?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, education.getTeacherNumber());
            pstmt.setInt(2, new RelationDaoImpl().getRelationIdByName(education.getEduName()));
            pstmt.setInt(3, new SchoolDaoImpl().getSchoolIdByName(education.getSchoolName()));
            pstmt.setDate(4, MyDate.CaseTime(education.getBegin()));
            pstmt.setDate(5, MyDate.CaseTime(education.getEnd()));
            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.connectionClose(connection, pstmt);
        }
        return i;
    }

    @Override
    public int updataTeacherEdu(Education education) {
        String sql = "update education_exper set schoolNumber = ? ,begin =? ,end =? where educationNumber = ? and teacherNumber =?";

        return JDBC.update(sql, new SchoolDaoImpl().getSchoolIdByName(education.getSchoolName()),
                MyDate.CaseTime(education.getBegin()), MyDate.CaseTime(education.getEnd())
                , education.getTeacherNumber());
    }

    @Override
    public List<Education> getTeacherEduByName(String name) {
        ArrayList<Education> educations = new ArrayList<>();
        Connection connection = JDBC.getConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select * from teacheredu where teacherName = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Education education = new Education();
                education.setTeacherNumber(resultSet.getInt(1));
                education.setTeacherName(resultSet.getString(2));
                education.setEduName(resultSet.getString(3));
                education.setBegin(resultSet.getDate(4) + "");
                education.setEnd(resultSet.getDate(5) + "");
                education.setSchoolName(resultSet.getString(6));
                educations.add(education);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBC.connectionClose(connection, pstmt, resultSet);
        }
        return educations;
    }

    @Override
    public int deleteTeacherEdu(String name, String type) {
        String sql = "delete from education_exper where educationNumber = ? and teacherNumber = ?";
        return JDBC.update(sql, name, type);
    }
}
