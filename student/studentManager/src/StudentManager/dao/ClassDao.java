package StudentManager.dao;


import StudentManager.pojo.ClassInfo;
import StudentManager.utils.DBUtil;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDao {
    DBUtil dbUtil = new DBUtil();
    Connection connection = null; //保存数据库连接的成员变量
    private PreparedStatement pstmt = null;
    MajorDao majorDao = new MajorDao();

    /**
     * 新增
     */
    public int insertClass(ClassInfo classInfo) {
        connection = dbUtil.getConnection();
        int flag = -1;
        String sql = "insert into classinfo (name, major_id) values (?,?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, classInfo.getClassName());
            pstmt.setInt(2, majorDao.getMajorIdex(classInfo.getMajor()));

            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }

    /**
     * 得到全部名称
     *
     * @return
     */
    public List<String> getAllClassName() {
        ArrayList<String> classname = new ArrayList<>();
        connection = dbUtil.getConnection();
        String sql = "select name from classinfo";
        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                classname.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classname;
    }


    /**
     * 得到所有的班级信息
     *
     * @return
     */
    public List<ClassInfo> getAllClass() {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from class_view";
        List<ClassInfo> classInfos = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                ClassInfo classInfo = new ClassInfo();
                classInfo.setClassId(resultSet.getInt(1));
                classInfo.setClassName(resultSet.getString(2));
                classInfo.setStudentNumber(resultSet.getInt(3));
                classInfo.setMajor(resultSet.getString(4));
                classInfo.setFaculty(resultSet.getString(5));
                classInfos.add(classInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return classInfos;
    }


    /**
     * 根据名获取
     *
     * @param name
     * @return
     */
    public List<ClassInfo> getClassByName(String name) {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from class_view where className like ?";
        ArrayList<ClassInfo> classInfos = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,"%"+ name+"%");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                ClassInfo classInfo = new ClassInfo();
                classInfo.setClassId(resultSet.getInt(1));
                classInfo.setClassName(resultSet.getString(2));
                classInfo.setStudentNumber(resultSet.getInt(3));
                classInfo.setMajor(resultSet.getString(4));
                classInfo.setFaculty(resultSet.getString(5));
                classInfos.add(classInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return classInfos;
    }


    /**
     * 获取数据库主键最大值
     *
     * @return
     */
    public int getIndex() {
        String sql = "SELECT IF(MAX(class_id) IS NULL, 0, MAX(class_id)) AS maxid FROM classinfo;";
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
     * 删除，通过班级名
     */
    public int deleteClassByName(String name) {
        String sql = "delete from classinfo where name=?";
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
    public int updataClass(ClassInfo classInfo) {
        String sql = "update classinfo set name=? ,major_id=? where class_id =?";
        int flag = -1;
        connection = dbUtil.getConnection();//获取数据库连接
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, classInfo.getClassName());
            pstmt.setInt(2, majorDao.getMajorIdex(classInfo.getMajor()));
            pstmt.setInt(3, classInfo.getClassId());
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }

    /**
     * 得到相应班级的班级id
     */
    public int getClassIdex(String name) {
        String sql = "select class_id from classinfo where name=?";
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
