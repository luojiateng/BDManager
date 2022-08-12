package dao;


import pojo.Family;

import java.util.List;

public interface FamilyDao {
    /**
     * 新增教师家庭信息
     */
    int saveTeacherFamily(Family family);

    /**
     * 更新教师的家庭信息
     */
    int updataTeacherFamily(Family family);

    /**
     * 删除教师家庭信息通过姓名和关系
     */
    int deleteTeacherFamily(Integer id, String type);

    /**
     * 查询教师的所有家庭关系
     */
    List<Family> getTeacherFamliyByName(String name);


}
