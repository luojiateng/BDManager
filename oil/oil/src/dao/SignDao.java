package dao;

import domain.Accident;
import domain.Sign;
import utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SignDao {
    private DBConnect dbUtils = new DBConnect();

    /**
     * 新增事故征兆
     *
     * @param sign
     * @return
     */
    public int insertSign(Sign sign) {
        Connection connection = dbUtils.getConnection();
        String sql = "insert into sign (Cnumber, Time, Symbol) VALUES (?,?,?)";
        int i = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sign.getCnumber());
            ps.setString(2, sign.getTime());
            ps.setString(3, sign.getSymbol());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }


    /**
     * 通过事故编号和发生征兆（after before）查询
     */
    public List<Sign> getSignBy(String Cnumebr, String time) {
        ArrayList<Sign> signs = new ArrayList<>();
        String sql = "select * from sign where Cnumber =? and time  =?";
        Connection connection = dbUtils.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Cnumebr);
            ps.setString(2, time);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Sign sign = new Sign(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
                signs.add(sign);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return signs;
    }

    /**
     * 得到所有的事故征兆
     *
     * @return
     */
    public List<String> getAllSign() {
        Connection connection = dbUtils.getConnection();
        ArrayList<String> strings = new ArrayList<>();
        String sql = "select Symbol from sign";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                strings.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
