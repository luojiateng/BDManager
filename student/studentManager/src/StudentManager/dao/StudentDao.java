package StudentManager.dao;

import StudentManager.pojo.Student;
import StudentManager.utils.DBUtil;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    DBUtil dbUtil = new DBUtil();
    Connection connection = null; //保存数据库连接的成员变量
    private PreparedStatement pstmt = null;
    ClassDao classDao = new ClassDao();

    /**
     * 增加学生的信息
     */
    public int insertStudent(Student student) {
        connection = dbUtil.getConnection();
        int flag = -1;
        String sql = "insert into student (stu_name, gender, class_id) values (?,?,?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, student.getStudentName());
            pstmt.setString(2, student.getGender());
            pstmt.setInt(3, classDao.getClassIdex(student.getClassInfo()));
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }


    /**
     * 查询学生信息通过姓名
     */
    public List<Student> getStudentByName(String name) {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from allstu_view  where studentName like ?";
        //a or  1=1
        ArrayList<Student> students = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");
            resultSet = pstmt.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();//得到元数据
            int columnCount = rsmd.getColumnCount();//得到一个结果的列数
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Student student = new Student();
                student.setStudentId(resultSet.getInt(1));
                student.setStudentName(resultSet.getString(2));
                student.setGender(resultSet.getString(3));
                student.setClassInfo(resultSet.getString(4));
                student.setMajor(resultSet.getString(5));
                student.setFaculty(resultSet.getString(6));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return students;
    }


    /**
     * 查询所有学生信息
     */
    public List<Student> getAllStudent() {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from allstu_view";
        List<Student> students = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Student student = new Student();
                student.setStudentId(resultSet.getInt(1));
                student.setStudentName(resultSet.getString(2));
                student.setGender(resultSet.getString(3));
                student.setClassInfo(resultSet.getString(4));
                student.setMajor(resultSet.getString(5));
                student.setFaculty(resultSet.getString(6));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return students;
    }


    /**
     * 修改学生信息
     */
    public int updataStudent(Student student) {
        String sql = "update student set stu_name = ?, gender= ?, class_id =? where  stu_id=?";
        int flag = -1;
        connection = dbUtil.getConnection();//获取数据库连接
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, student.getStudentName());
            pstmt.setString(2, student.getGender());
            pstmt.setInt(3, classDao.getClassIdex(student.getClassInfo()));
            pstmt.setInt(4, student.getStudentId());
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }


    /**
     * 删除学生信息通过学生姓名
     */
    public int deleteStudent(String name) {
        String sql = "delete from student where stu_name=?";
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
     * 返回当前主键的最大值+1，为新的学号
     *
     * @return
     */
    public int getIndex() {
        String sql = "SELECT IF(MAX(stu_id) IS NULL, 0, MAX(stu_id)) AS maxid FROM student;";
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


}
