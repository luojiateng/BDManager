package dao;


import domain.Processes;
import domain.Sign;
import utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProcessesDao {
    private DBConnect dbUtil = new DBConnect();

    /**
     * 新增事故处理
     */
    public int insertProcess(Processes process) {
        Connection connection = dbUtil.getConnection();
        Processes processes = null;
        int i = 0;
        String sql = "insert into processes (Cnumber, Trprocesses) VALUES (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, process.getCnumber());
            ps.setString(2, process.getTrpocesses());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }



    /**
     * 通过事故编号查询事故处理信息
     *
     * @param Cnumber
     * @return
     */
    public Processes getProcessByCnumebr(String Cnumber) {
        Connection connection = dbUtil.getConnection();
        Processes processes = null;
        String sql = "select * from processes where Cnumber = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Cnumber);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                processes = new Processes(resultSet.getString(1),
                        resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return processes;
    }

}
