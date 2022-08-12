package peopleManager.dao;


import org.junit.Test;
import peopleManager.bean.PunishAward;
import peopleManager.utils.DBConnected;
import peopleManager.utils.DateCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PADao {
    DBConnected dbUtil = new DBConnected();
    Connection connection = null;

    /**
     * 通过姓名获得教师的奖惩信息
     *
     * @param name
     * @return
     */
    public List<PunishAward> getAllpa(String name) {
        ArrayList<PunishAward> punishAwards = new ArrayList<>();
        connection = dbUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select * from people.tea_ap where tea_name = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                PunishAward punishAward = new PunishAward();
                punishAward.setApId(resultSet.getInt(1));
                punishAward.setTeacherId(resultSet.getInt(2));
                punishAward.setTeacherName(resultSet.getString(3));
                punishAward.setType(resultSet.getString(4));
                punishAward.setTime(resultSet.getString(5));
                punishAward.setDescribe(resultSet.getString(6));
                punishAwards.add(punishAward);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return punishAwards;
    }

    /**
     * 奖惩信息删除通过奖惩编号
     */
    public int delePA(Integer id) {
        String sql = "delete from people.award_punish where ap_id = ?";
        int flag = -1;
        connection = dbUtil.getConnection();//获取数据库连接
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return flag;
    }

    /**
     * 新增奖惩信息
     */
    public int insertPA(PunishAward punishAward) {
        connection = dbUtil.getConnection();//获取数据库连接
        String sqla = "select ap_id from people.ap_type where ap_type = ?";
        int t = 0;
        try {
            PreparedStatement pa = connection.prepareStatement(sqla);
            pa.setString(1, punishAward.getType());
            ResultSet r1 = pa.executeQuery();

            while (r1.next()) {
                t = r1.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement pstmt = null;
        int i = 0;
        String sql = "insert into people.award_punish (teacher_id, type, time, `desc`) VALUES (?,?,?,?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, punishAward.getTeacherId());
            pstmt.setInt(2, t);
            pstmt.setDate(3, DateCase.CaseTime(punishAward.getTime()));
            pstmt.setString(4, punishAward.getDescribe());
            i = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt);
        }
        return i;

    }
}
