package StudentManager.dao;


import StudentManager.pojo.Faculty;
import StudentManager.utils.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDao {
    DBUtil dbUtil = new DBUtil();
    Connection connection = null; //保存数据库连接的成员变量
    private PreparedStatement pstmt = null;

    /**
     * 得到所有的院系名
     */
    public List<String> getAllFacultyName() {
        ArrayList<String> facultyName = new ArrayList<>();
        connection = dbUtil.getConnection();
        String sql = "select faculty_name from faculty";
        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                facultyName.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return facultyName;
    }


    /**
     * 新增
     */
    public int insertFaculty(Faculty faculty) {
        connection = dbUtil.getConnection();
        int flag = -1;
        String sql = "insert into faculty (faculty_name) values (?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, faculty.getFacultyName());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }


    /**
     * 得到所有的学院信息
     */
    public List<Faculty> getAllFaculty() {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select * from faculty_view";
        List<Faculty> facultys = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Faculty faculty = new Faculty();
                faculty.setFacultyId(resultSet.getInt(1));
                faculty.setFacultyName(resultSet.getString(2));
                faculty.setStudentNumber(resultSet.getInt(3));
                faculty.setGrilNumber(resultSet.getInt(4));
                faculty.setBoyNumber(resultSet.getInt(5));
                facultys.add(faculty);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return facultys;
    }

    /**
     * 根据名称获取
     *
     * @param name
     * @return
     */
    public List<Faculty> getFacultyByName(String name) {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from faculty_view  where faculty_view.faculty_name like ?";
        ArrayList<Faculty> faculties = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "%"+ name+"%");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Faculty faculty = new Faculty();
                faculty.setFacultyId(resultSet.getInt(1));
                faculty.setFacultyName(resultSet.getString(2));
                faculty.setStudentNumber(resultSet.getInt(3));
                faculty.setGrilNumber(resultSet.getInt(4));
                faculty.setBoyNumber(resultSet.getInt(5));
                faculties.add(faculty);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return faculties;
    }


    /**
     * 获取数据库主键最大值+1
     *
     * @return
     */
    public int getIndex() {
        String sql = "SELECT IF(MAX(faculty_id) IS NULL, 0, MAX(faculty_id)) AS maxid FROM faculty;";
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

    /**
     * 删除
     */
    public int deleteFacultyByName(String name) {
        String sql = "delete from faculty where faculty_name=?";
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


    /**
     * 更新信息
     */
    public int updataFaculty(Faculty faculty) {
        String sql = "update faculty set faculty_name = ? where faculty_id=?";
        int flag = -1;
        connection = dbUtil.getConnection();//获取数据库连接
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, faculty.getFacultyName());
            pstmt.setInt(2, faculty.getFacultyId());
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }

    public int getFacultyIndex(String name) {
        String sql = "select faculty_id from faculty where faculty_name=?";
        int flag = 0;
        ResultSet resultSet;
        connection = dbUtil.getConnection();//获取数据库连接
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
}
