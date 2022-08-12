package peopleManager.dao;

import peopleManager.utils.DBConnected;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDao {
    DBConnected dbUtil = new DBConnected();
    Connection connection = null;
    PreparedStatement pstmt = null;

    public int insert(String name) {
        connection = dbUtil.getConnection();
        int i = 0;
        String sql = "insert into people.postion (positionName) VALUES (?)";
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

    public int delete(String name) {
        String sql = "delete from people.postion where positionName=?";
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


    public int updata(String oldname, String newname) {
        connection = dbUtil.getConnection();//获取数据库连接
        //根据旧名称查询id
        String sqla = "select positionId from people.postion where positionName = ?";
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
        String sql = "update people.postion set positionName = ? where positionId=?";
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
     * 得到职务名称
     */
    public List<String> getPositionName() {
        connection = dbUtil.getConnection();
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select *  from people.postion ";
        List<String> Positions = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                String Position = resultSet.getString(2);
                Positions.add(Position);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(connection, pstmt, resultSet);
        }
        return Positions;
    }

    /**
     * 返回主键最大加一
     */
    public int getIndex() {
        String sql = "SELECT IF(MAX(positionId) IS NULL, 0, MAX(positionId)) AS maxid FROM people.postion;";
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
