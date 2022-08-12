package peopleManager.dao;


import org.junit.Test;
import peopleManager.bean.Teacher;
import peopleManager.utils.DBConnected;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {
    DBConnected dbUtil = new DBConnected();
    Connection connection = null;
    PreparedStatement pstmt = null;

    /**
     * 从视图中查询教师的部门信息
     */
    public List<Teacher> selectAll() {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from people.tea_dept";
        List<Teacher> teachers = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Teacher teacher = new Teacher();
                teacher.setTeacherId(resultSet.getInt(1));
                teacher.setTeacherName(resultSet.getString(2));
                teacher.setGender(resultSet.getString(3));
                teacher.setEmail(resultSet.getString(4));
                teacher.setDeptName(resultSet.getString(5));
                teacher.setTitle(resultSet.getString(6));
                teacher.setPosition(resultSet.getString(7));
                teachers.add(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return teachers;
    }

    /**
     * 通过姓名查询
     *
     * @return
     */
    public List<Teacher> selectOne(String name) {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from people.tea_dept where tea_name like ?";
        List<Teacher> teachers = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Teacher teacher = new Teacher();
                teacher.setTeacherId(resultSet.getInt(1));
                teacher.setTeacherName(resultSet.getString(2));
                teacher.setGender(resultSet.getString(3));
                teacher.setEmail(resultSet.getString(4));
                teacher.setDeptName(resultSet.getString(5));
                teacher.setTitle(resultSet.getString(6));
                teacher.setPosition(resultSet.getString(7));
                teachers.add(teacher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return teachers;
    }

    /**
     * 删除教师信息
     *
     * @param name
     * @return
     */
    public int delete(String name) {
        String sql = "delete from people.teacher where tea_name=?";
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
     * 更新教师信息
     *
     * @param teacher
     * @return
     */
    public int updataTeacher(Teacher teacher) {
        connection = dbUtil.getConnection();//获取数据库连接
        //根据旧名称查询id
        String sqla = "select dep_id from people.dept where depName = ?";
        String sqlb = "select titleId from people.title where titleName = ?";
        String sqlc = "select positionId from people.postion where positionName = ?";
        int d = 0;
        int t = 0;
        int p = 0;
        try {
            PreparedStatement pa = connection.prepareStatement(sqla);
            PreparedStatement pb = connection.prepareStatement(sqlb);
            PreparedStatement pc = connection.prepareStatement(sqlc);
            pa.setString(1, teacher.getDeptName());
            pb.setString(1, teacher.getTitle());
            pc.setString(1, teacher.getPosition());
            ResultSet r1 = pa.executeQuery();
            ResultSet r2 = pb.executeQuery();
            ResultSet r3 = pc.executeQuery();

            while (r1.next()) {
                d = r1.getInt(1);
            }

            while (r2.next()) {
                t = r2.getInt(1);
            }

            while (r3.next()) {
                p = r3.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //根据id对名称进行修改
        String sql = "update people.teacher set tea_name = ? ,gender=? ,email=? ,dept_id=? ,postion_id=? ,title_id= ? where tea_id = ?";
        int flag = -1;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, teacher.getTeacherName());
            pstmt.setString(2, teacher.getGender());
            pstmt.setString(3, teacher.getEmail());
            pstmt.setInt(4, d);
            pstmt.setInt(5, p);
            pstmt.setInt(6, t);
            pstmt.setInt(7, teacher.getTeacherId());
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }




    /**
     * 新增教师
     *
     * @param teacher
     * @return
     */
    public int insertTeacher(Teacher teacher) {
        connection = dbUtil.getConnection();//获取数据库连接
        //根据旧名称查询id
        String sqla = "select dep_id from people.dept where depName = ?";
        String sqlb = "select titleId from people.title where titleName = ?";
        String sqlc = "select positionId from people.postion where positionName = ?";
        int d = 0;
        int t = 0;
        int p = 0;
        try {
            PreparedStatement pa = connection.prepareStatement(sqla);
            PreparedStatement pb = connection.prepareStatement(sqlb);
            PreparedStatement pc = connection.prepareStatement(sqlc);

            pa.setString(1, teacher.getDeptName());
            pb.setString(1, teacher.getTitle());
            pc.setString(1, teacher.getPosition());

            ResultSet r1 = pa.executeQuery();
            ResultSet r2 = pb.executeQuery();
            ResultSet r3 = pc.executeQuery();

            while (r1.next()) {
                d = r1.getInt(1);
            }

            while (r2.next()) {
                t = r2.getInt(1);
            }

            while (r3.next()) {
                p = r3.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        //根据id对名称进行修改
        String sql = "insert into people.teacher (tea_name, gender, email, dept_id, postion_id, title_id) VALUES (?,?,?,?,?,?)";
        int flag = -1;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, teacher.getTeacherName());
            pstmt.setString(2, teacher.getGender());
            pstmt.setString(3, teacher.getEmail());
            pstmt.setInt(4, d);
            pstmt.setInt(5, p);
            pstmt.setInt(6, t);
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;

    }

    /**
     * 返回主键最大值，然后+1，作为新的id
     */
    public int getIndex() {
        String sql = "SELECT IF(MAX(tea_id) IS NULL, 0, MAX(tea_id)) AS maxid FROM people.teacher;";
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
