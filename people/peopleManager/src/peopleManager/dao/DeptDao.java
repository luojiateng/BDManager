package peopleManager.dao;


import peopleManager.bean.Department;
import peopleManager.utils.DBConnected;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDao {
    DBConnected dbUtil = new DBConnected();
    Connection connection = null;
    PreparedStatement pstmt = null;

    /**
     * 新增部门信息
     *
     * @param name
     * @return
     */
    public int insert(String name) {
        connection = dbUtil.getConnection();
        int i = 0;
        String sql = "insert into people.dept (depName) VALUES (?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return i;
    }

    /**
     * 删除已有的部门通过name
     *
     * @param name
     * @return
     */
    public int delete(String name) {
        String sql = "delete from people.dept where depName=?";
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
     * 更新部门
     *
     * @param oldname
     * @param newname
     * @return
     */
    public int updata(String oldname, String newname) {
        connection = dbUtil.getConnection();//获取数据库连接
        //根据旧名称查询id
        String sqla = "select dep_id from dept where depName = ?";
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
        //根据id对名称进行修改
        String sql = "update people.dept set depName = ? where dep_id=?";
        int flag = -1;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, newname);
            pstmt.setInt(2, id);
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }

    /**
     * 通过部门名查询部门各种职称人数
     */
    public List<Department> getAllDep(String name) {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "call people.dept_show(?)";
        List<Department> departments = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Department department = new Department();
                department.setDeptId(resultSet.getInt(1));
                department.setDeptName(resultSet.getString(2));
                department.setTitle(resultSet.getString(3));
                department.setTeaNumber(resultSet.getInt(4));
                departments.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return departments;
    }

    /**
     * 得到部门名称
     */
    public List<String> getDepName() {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from dept";
        List<String> departments = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                String departmentname = resultSet.getString(2);
                departments.add(departmentname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return departments;
    }

    /**
     * 返回设置的
     *
     * @return
     */
    public int getIndex() {
        String sql = "SELECT IF(MAX(dep_id) IS NULL, 0, MAX(dep_id)) AS maxid FROM people.dept;";
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
