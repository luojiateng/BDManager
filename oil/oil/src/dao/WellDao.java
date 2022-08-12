package dao;

import domain.Well;
import utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WellDao {
    private DBConnect dbUtil = new DBConnect();

    /**
     * 新增油田的事故
     *
     * @param well
     * @return
     */
    public int insertWellAccient(Well well) {
        Connection connection = dbUtil.getConnection();
        int i = 0;
        String sql = "insert into well (cnumber, wnumber, oname) VALUES (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, well.getCnumber());
            ps.setInt(2, well.getWnumber());
            ps.setString(3, well.getOilName());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }


    /**
     * 获得这类事故下一个编号，比如有p01类型事故有p01001,p01002，那么返回的字符串应该是p01003
     *
     * @param encoding
     * @return
     */
    public String getAccidentId(String encoding) {
        Connection connection = dbUtil.getConnection();
        String sql = "select count(*),cnumber from well where cnumber like ?";
        int count = 0;
        String oldNumber = "";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, '%' + encoding + '%');
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
                oldNumber = resultSet.getString(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //进行字符串的拼接，获得下一个事故编码
        int numLength = (count + "").length();//将数字拼接成字符串，然后获得数字的长度
        String substring = oldNumber.substring(0, oldNumber.length() - numLength);//对查出来的事故编号截取
        String newNumber = substring + (count + 1);//对值进行加1，然后再次进行字符串的拼接
        return newNumber;
        /**
         * 加入查出来的p01类型事故已经有两个了p01001 p01002 ，count为2，查出来的oldNumber为p01001，
         * 2的长度为1,对oldNumber进行截取从0到6-1的子字符串:p0100，然后将count+1，count等于3,
         * 然后进行字符串的拼接p0100+3  -> p01003 这就是新的事故类型编码，确保了这些值的唯一性
         */
    }



}
