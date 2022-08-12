package dao.impl;


import dao.TeacherAPDao;
import pojo.TeacherAp;
import utils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherAPDaoImpl implements TeacherAPDao {
    @Override
    public int saveAP(TeacherAp teacherAp) {
        String sql = "insert into award_punish (teacherNumber, type, time, `describe`) VALUES (?,?,?,?)";

        return JDBC.update(sql, teacherAp.getTeacherId(), teacherAp.getType(), teacherAp.getTime(),
                teacherAp.getDescribe());
    }

    @Override
    public List<TeacherAp> getTeacherAPByAPID(String name) {
        ArrayList<TeacherAp> teacherAps = new ArrayList<>();

        Connection connection = JDBC.getConnection();
        String sql = "select * from teacherap where teacherName =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                TeacherAp teacherAp = new TeacherAp(resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5) + "",
                        resultSet.getString(6));
                teacherAps.add(teacherAp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacherAps;
    }

    @Override
    public int deleteTeacherAP(Integer id) {
        String sql = "delete from award_punish where apNumber = ?";
        return JDBC.update(sql, id);
    }
}
