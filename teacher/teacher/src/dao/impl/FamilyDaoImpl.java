package dao.impl;


import dao.FamilyDao;
import pojo.Family;
import utils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FamilyDaoImpl implements FamilyDao {

    @Override
    public int saveTeacherFamily(Family family) {
        String sql = "insert into family (teacherNumber, relation, fName) VALUES (?,?,?)";
        return JDBC.update(sql, family.getTeacherNumber(), new RelationDaoImpl().getRelationIdByName(family.getFamilys()), family.getfName());
    }

    @Override
    public int updataTeacherFamily(Family family) {
        String sql = "update family set fName = ? where teacherNumber =? and relation = ?";
        return JDBC.update(sql, family.getfName(), family.getTeacherNumber(), new RelationDaoImpl().getRelationIdByName(family.getFamilys()));
    }

    @Override
    public int deleteTeacherFamily(Integer id, String type) {
        String sql = "delete from family where teacherNumber =  ? and relation = ?";
        return JDBC.update(sql, id, new RelationDaoImpl().getRelationIdByName(type));
    }

    @Override
    public List<Family> getTeacherFamliyByName(String name) {
        ArrayList<Family> families = new ArrayList<>();
        Connection connection = JDBC.getConnection();
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;//加载填充后的SQL语句，得到结果集
        String sql = "select * from familyinfo where teacherName = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {//指针下移，指向“表中的某一行”
                Family family = new Family();
                family.setTeacherNumber(resultSet.getInt(1));
                family.setTeacherName(resultSet.getString(2));
                family.setFamilys(resultSet.getString(3));
                family.setfName(resultSet.getString(4));
                families.add(family);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return families;
    }


}
