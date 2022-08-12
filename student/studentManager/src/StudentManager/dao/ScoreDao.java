package StudentManager.dao;


import StudentManager.pojo.Score;
import StudentManager.utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreDao {
    DBUtil dbUtil = new DBUtil();
    Connection connection = null; //保存数据库连接的成员变量
    private PreparedStatement pstmt = null;

    /**
     * 得到某人的所有课程信息
     *
     * @param name
     * @return
     */
    public List<Score> getAllScore(String name) {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select * from stu_score where stu_name = ?";
        ArrayList<Score> scores = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            resultSet = pstmt.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();//得到元数据
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Score score = new Score(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getDouble(4));
                scores.add(score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return scores;
    }

    /**
     * 得到所有的课程名
     *
     * @return
     */
    public List<String> getAllCourseName() {
        ArrayList<String> strings = new ArrayList<>();
        connection = dbUtil.getConnection();
        String sql = "select course_name from course";
        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                strings.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strings;

    }

    /**
     * 得到所有课程的序号
     *
     * @return
     */
    public List<Integer> getAllCourseId() {
        ArrayList<Integer> integers = new ArrayList<>();
        connection = dbUtil.getConnection();
        String sql = "select course_id from course";
        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                integers.add(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return integers;
    }

    /**
     * 通过课程名获取课程id
     *
     * @param name
     * @return
     */
    public int getCourseId(String name) {
        connection = dbUtil.getConnection();
        String sql = "select course_id from course where  course_name=?";
        int a = 0;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                a = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    /**
     * 新增学生成绩
     *
     * @param score
     * @return
     */
    public int insertScore(Score score) {
        connection = dbUtil.getConnection();
        int i = 0;
        String sql = "insert into score (stu_id, course_id, score) VALUES (?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, score.getStuId());
            pstmt.setInt(2, getCourseId(score.getCourseName()));
            pstmt.setDouble(3, score.getScore());
            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 通过学号和课程名删除成绩*
     *
     * @param stu_id
     * @param course
     * @return
     */
    public int deletScore(int stu_id, String course) {
        connection = dbUtil.getConnection();//获取数据库连接
        String sqla = "select course_id from course where course_name = ?";
        int cid = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqla);
            preparedStatement.setString(1, course);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cid = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "delete from score where stu_id =? and course_id =?";
        int flag = -1;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, stu_id);
            pstmt.setInt(2, cid);
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }

}
