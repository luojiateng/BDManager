package StudentManager.dao;


import StudentManager.pojo.Major;
import StudentManager.utils.DBUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MajorDao {
    DBUtil dbUtil = new DBUtil();
    Connection connection = null; //保存数据库连接的成员变量
    private PreparedStatement pstmt = null;
    FacultyDao facultyDao = new FacultyDao();

    /**
     * 得到所有专业名
     *
     * @return
     */
    public List<String> getAllMajorName() {
        ArrayList<String> majorName = new ArrayList<>();
        connection = dbUtil.getConnection();
        String sql = "select major_name from major";
        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                majorName.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return majorName;
    }


    /**
     * 新增
     */
    public int insertMajor(Major major) {
        connection = dbUtil.getConnection();
        int flag = -1;
        String sql = "insert into major (major_name, faculty_id) values (?,?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, major.getMajorName());
            pstmt.setInt(2, facultyDao.getFacultyIndex(major.getFacultyName()));
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }


    /**
     * 得到所有的班级信息
     */
    public List<Major> getAllMajor() {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select * from major_view";
        List<Major> majors = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Major major = new Major();
                major.setMajorId(resultSet.getInt(1));
                major.setMajorName(resultSet.getString(2));
                major.setStudentNumber(resultSet.getInt(3));
                major.setGirlNumber(resultSet.getInt(4));
                major.setBoyNumber(resultSet.getInt(5));
                major.setFacultyName(resultSet.getString(6));
                majors.add(major);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return majors;
    }

    /**
     * 根据名称获取
     *
     * @param name
     * @return
     */
    public List<Major> getMajorByName(String name) {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from major_view where major_view.majorName like ?";
        ArrayList<Major> majors = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Major major = new Major();
                major.setMajorId(resultSet.getInt(1));
                major.setMajorName(resultSet.getString(2));
                major.setStudentNumber(resultSet.getInt(3));
                major.setGirlNumber(resultSet.getInt(4));
                major.setBoyNumber(resultSet.getInt(5));
                major.setFacultyName(resultSet.getString(6));
                majors.add(major);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return majors;
    }


    /**
     * 获取数据库主键最大值+1
     *
     * @return
     */
    public int getIndex() {
        String sql = "SELECT IF(MAX(major_id) IS NULL, 0, MAX(major_id)) AS maxid FROM major;";
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
    public int deleteMajorByName(String name) {
        String sql = "delete from major where major_name=?";
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
    public int updataMajor(Major major) {
        String sql = "update major set major_name = ?,faculty_id=?  where major_id=?";
        int flag = -1;
        connection = dbUtil.getConnection();//获取数据库连接
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, major.getMajorName());
            pstmt.setInt(2, facultyDao.getFacultyIndex(major.getFacultyName()));
            pstmt.setInt(3, major.getMajorId());
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }

    public int getMajorIdex(String name) {
        String sql = "select major_id from major where major_name=?";
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
