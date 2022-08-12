package dao;


import domain.Accident;
import utils.DBConnect;
import utils.MyData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccidentDao {
    /**
     * 实例化这个类，可以调用其中的数据库连接方法
     */
    private DBConnect dbUtil = new DBConnect();

    /**
     * @param accident
     * @return
     */
    public int insertAccident(Accident accident) {
        Connection connection = dbUtil.getConnection();
        String ap = "select Encoding_id from encoding where  Apattern =?";
        int encoding = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ap);
            preparedStatement.setString(1, accident.getApattern());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                encoding = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "insert into accident (Cnumber, Indepth, Endepth, Encoding, Gfloor, Stratum, Octime, Retime, Lossmoney, pass) VALUES (?,?,?,?,?,?,?,?,?,?)";
        int i = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, accident.getcNumber());
            ps.setString(2, accident.getInDepth());
            ps.setString(3, accident.getEndDepth());
            ps.setInt(4, encoding);
            ps.setString(5, accident.getGfloor());
            ps.setString(6, accident.getStratum());
            ps.setDate(7, MyData.caseTime(accident.getOctime()));
            ps.setDate(8, MyData.caseTime(accident.getRetime()));
            ps.setString(9, accident.getLossMoney());
            ps.setString(10, accident.getPass());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 通过事故编号查询事故信息
     *
     * @param Cnumber
     * @return
     */
    public Accident getAccidentByCnumber(String Cnumber) {
        Connection connection = dbUtil.getConnection();//获取数据库连接
        Accident accident = null;
        String sql = "select * from well_accident where Cnumber =? ";//设置SQL语句
        try {
            PreparedStatement ps = connection.prepareStatement(sql);//加载SQL语句
            ps.setString(1, Cnumber);//向SQL语句中的占位符‘？’填充数据
            ResultSet resultSet = ps.executeQuery();//执行SQL语句，当执行查询的时候，就会获取一个结果集
            while (resultSet.next()) {//对这个结果集进行遍历，得到结果集的数据，并使用实体类进行填充对数据的保存
                accident = new Accident(resultSet.getString(1),
                        resultSet.getInt(2), resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getString(8),
                        resultSet.getDate(9) + "", resultSet.getDate(10) + "",
                        resultSet.getString(11), resultSet.getString(12),
                        resultSet.getString(13));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return accident;
    }

    /**
     * 得到所有的事故信息
     *
     * @return
     */
    public List<Accident> getAllAccident() {
        ArrayList<Accident> accidents = new ArrayList<>();
        Connection connection = dbUtil.getConnection();
        Accident accident = null;
        String sql = "select * from well_accident ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                accident = new Accident(resultSet.getString(1),
                        resultSet.getInt(2), resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getString(8),
                        resultSet.getDate(9) + "", resultSet.getDate(10) + "",
                        resultSet.getString(11), resultSet.getString(12),
                        resultSet.getString(13));
                accidents.add(accident);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return accidents;
    }


    /**
     * 通过井号查询事故信息
     *
     * @param Wnumber
     * @return
     */
    public List<Accident> getAccidentByWnumber(Integer Wnumber) {
        ArrayList<Accident> accidents = new ArrayList<>();
        Connection connection = dbUtil.getConnection();
        Accident accident = null;
        String sql = "select * from well_accident where wnumber =? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Wnumber);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                accident = new Accident(resultSet.getString(1),
                        resultSet.getInt(2), resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getString(8),
                        resultSet.getDate(9) + "", resultSet.getDate(10) + "",
                        resultSet.getString(11), resultSet.getString(12),
                        resultSet.getString(13));
                accidents.add(accident);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return accidents;
    }


    /**
     * 根据油田名查询事故信息
     *
     * @return
     */
    public List<Accident> getAccidentByOname(String Oname) {
        ArrayList<Accident> accidents = new ArrayList<>();
        Connection connection = dbUtil.getConnection();
        Accident accident = null;
        String sql = "select * from well_accident where oname =? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Oname);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                accident = new Accident(resultSet.getString(1),
                        resultSet.getInt(2), resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getString(8),
                        resultSet.getDate(9) + "", resultSet.getDate(10) + "",
                        resultSet.getString(11), resultSet.getString(12),
                        resultSet.getString(13));
                accidents.add(accident);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return accidents;
    }

    /**
     * 根据时间段查询事故信息
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    public List<Accident> getAccidentByDate(String beginTime, String endTime) {
        ArrayList<Accident> accidents = new ArrayList<>();
        Connection connection = dbUtil.getConnection();
        Accident accident = null;
        String sql = "select * from well_accident where Octime > ? and Retime< ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, MyData.caseTime(beginTime));
            ps.setDate(2, MyData.caseTime(endTime));
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                accident = new Accident(resultSet.getString(1),
                        resultSet.getInt(2), resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6),
                        resultSet.getString(7), resultSet.getString(8),
                        resultSet.getDate(9) + "", resultSet.getDate(10) + "",
                        resultSet.getString(11), resultSet.getString(12),
                        resultSet.getString(13));
                accidents.add(accident);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return accidents;
    }

    /**
     * 通过油田名 进行事故数量统计
     */
    public int getAccidentCountByOilName(String oilName) {
        Connection connection = dbUtil.getConnection();
        int count = 0;
        String sql = "call show_oliAccient(?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, oilName);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    /**
     * 通过油井名进行事故数量统计
     */
    public int getAccidentCountByWell(Integer wellId) {
        Connection connection = dbUtil.getConnection();
        int count = 0;
        String sql = "call show_wellAccident(?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, wellId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 通过事故编号 对事故持续时间进行统计
     */
    public String getAccidentTimeDiff(String Cnumber) {
        Connection connection = dbUtil.getConnection();
        String time = "";
        String sql = "call dateDiff(?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Cnumber);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                time = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return time;
    }


    /**
     * 获得所有的事故内容
     */
    public List<String> getAllApattern() {
        ArrayList<String> strings = new ArrayList<>();
        Connection connection = dbUtil.getConnection();
        String sql = "select Apattern from encoding";
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

    /**
     * 通过类型获得类型编码
     *
     * @return
     */
    public String getEncodingByAppttern(String appttern) {
        Connection connection = dbUtil.getConnection();
        String sql = "select Encoding_id from encoding where Apattern = ?";
        String id = "";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, appttern);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

}
