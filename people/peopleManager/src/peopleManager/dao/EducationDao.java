package peopleManager.dao;


import org.junit.Test;
import peopleManager.bean.Education;
import peopleManager.utils.DBConnected;
import peopleManager.utils.DateCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDao {
    DBConnected dbUtil = new DBConnected();
    Connection connection = null;

    /**
     * 新增教育经历
     *
     * @param id
     * @param type
     * @param school
     * @param begin  开始时间
     * @param end    结束时间
     * @return
     */
    public int insertEdu(Integer id, String type, String school, String begin, String end) {
        connection = dbUtil.getConnection();
        PreparedStatement pstmt = null;
        int i = 0;
        String sql = "insert into people.tea_edu (tea_id, edu_type, school_id, btime, etime) VALUES (?,?,?,?,?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setInt(2, getTypeId(type));
            pstmt.setInt(3, getSchoolId(school));
            pstmt.setDate(4, DateCase.CaseTime(begin));
            pstmt.setDate(5, DateCase.CaseTime(end));
            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return i;
    }


    /**
     * 得到教师的教育信息
     *
     * @return
     */
    public List<Education> getEducation(String name) {
        ArrayList<Education> educations = new ArrayList<>();
        connection = dbUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select * from people.tea_education where tea_name = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Education education = new Education();
                education.setTeacherId(resultSet.getInt(1));
                education.setTeacherName(resultSet.getString(2));
                education.setSchool(resultSet.getString(3));
                education.setEducation(resultSet.getString(4));
                education.setBeginTiem(resultSet.getDate(5));
                education.setEndTime(resultSet.getDate(6));
                educations.add(education);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return educations;
    }


    /**
     * 得到所有的学校名
     */
    public List<String> getSchoolType() {
        ArrayList<String> strings = new ArrayList<>();
        connection = dbUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from people.school";
        try {
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                String str = resultSet.getString(2);
                strings.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return strings;
    }

    /**
     * 得到所有的教育经历
     */
    public List<String> getEduType() {
        ArrayList<String> strings = new ArrayList<>();
        connection = dbUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from people.edu_type";
        try {
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                String edu = resultSet.getString(2);
                strings.add(edu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return strings;
    }

    /**
     * 更新教师的教育经历
     *
     * @param id
     * @param grade
     * @param school
     * @param begin
     * @param end
     * @return
     */
    public int updataEdu(Integer id, String type, String school, String begin, String end) {
        connection = dbUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "update people.tea_edu set school_id = ?,btime = ?,etime = ? where tea_id = ? and edu_type = ? ";
        int i = 0;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, getSchoolId(school));
            pstmt.setDate(2, DateCase.CaseTime(begin));
            pstmt.setDate(3, DateCase.CaseTime(end));
            pstmt.setInt(4, id);
            pstmt.setInt(5, getTypeId(type));
            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return i;
    }

    /**
     * 通过学校名获得学校id
     */
    public int getSchoolId(String name) {
        String sql = "select school_id from people.school where school_name=?";
        int flag = 0;
        ResultSet resultSet;
        connection = dbUtil.getConnection();//获取数据库连接
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
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }

    /**
     * 通过学历名获得学历id
     */
    public int getTypeId(String name) {
        String sql = "select edu_id from people.edu_type where edu_name=?";
        int flag = 0;
        ResultSet resultSet = null;
        connection = dbUtil.getConnection();//获取数据库连接
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
            dbUtil.close(connection, pstmt, resultSet);
        }
        return flag;
    }


}
