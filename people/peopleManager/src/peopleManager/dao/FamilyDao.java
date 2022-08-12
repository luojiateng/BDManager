package peopleManager.dao;


import org.junit.Test;
import peopleManager.bean.Education;
import peopleManager.bean.Family;
import peopleManager.utils.DBConnected;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FamilyDao {
    DBConnected dbUtil = new DBConnected();
    Connection connection = null;
    PreparedStatement pstmt = null;

    /**
     * 得到教师的家人信息
     *
     * @return
     */
    public List<Family> getFamily(String name) {
        ArrayList<Family> families = new ArrayList<>();
        connection = dbUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select * from people.tea_family where tea_name = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Family family = new Family();
                family.setTeacherId(resultSet.getInt(1));
                family.setTeacherName(resultSet.getString(2));
                family.setRelation(resultSet.getString(3));
                family.setMamberName(resultSet.getString(4));
                families.add(family);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return families;
    }

    /**
     * 新增教师家庭关系
     */
    public int insertFamily(Integer id, String relation, String name) {
        connection = dbUtil.getConnection();
        String sqla = "select fam_id from people.fam_type where fam_type_name = ?";
        int r = 0;
        try {
            PreparedStatement pa = connection.prepareStatement(sqla);
            pa.setString(1, relation);
            ResultSet r1 = pa.executeQuery();
            while (r1.next()) {
                r = r1.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        int i = 0;
        String sql = "insert into people.family (teacher_id, home_member, memer_name) VALUES (?,?,?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setInt(2, r);
            pstmt.setString(3, name);
            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return i;
    }

    /**
     * 得到所有的家庭关系
     */
    public List<String> getFamilyType() {
        ArrayList<String> strings = new ArrayList<>();
        connection = dbUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from people.fam_type";
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
     * 更新家庭信息
     *
     * @param relation
     * @param name
     * @return
     */
    public int updataFamily(Integer tid, String relation, String name) {
        connection = dbUtil.getConnection();//获取数据库连接
        //根据旧名称查询id
        String sqla = "select fam_id from people.fam_type where fam_type_name = ?";
        int id = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqla);
            preparedStatement.setString(1, relation);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //根据id对名称进行修改
        String sql = "update people.family set memer_name = ? where teacher_id=? and home_member = ?";
        int flag = -1;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, tid);
            pstmt.setInt(3, id);
            flag = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }

}
