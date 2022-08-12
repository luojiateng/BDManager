package dao.impl;


import dao.RelationDao;
import jdk.nashorn.internal.scripts.JD;
import utils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelationDaoImpl implements RelationDao {
    @Override
    public int getRelationIdByName(String name) {
        Connection connection = JDBC.getConnection();
        PreparedStatement ps = null;
        String sql = "select * from relation where familys = ?";
        int id = 0;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC.connectionClose(connection, ps);
        }
        return id;
    }

    @Override
    public List<String> getFamilyType() {
        ArrayList<String> strings = new ArrayList<>();
        Connection connection = JDBC.getConnection();
        String sql = "select familys from relation ";
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
