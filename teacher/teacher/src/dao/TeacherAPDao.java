package dao;


import pojo.TeacherAp;

import java.util.List;

public interface TeacherAPDao {
    /**
     * 新增教师奖惩
     */
    int saveAP(TeacherAp teacherAp);

    /**
     * 查询教师的奖惩信息
     */
    List<TeacherAp> getTeacherAPByAPID(String name);

    /**
     * 通过奖惩编号删除教师奖惩信息
     */
    int deleteTeacherAP(Integer id);

}
