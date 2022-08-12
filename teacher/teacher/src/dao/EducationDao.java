package dao;


import pojo.Education;

import java.util.List;

public interface EducationDao {
    /**
     * 新增教师教育经历
     */
    int saveTeacherEdu(Education education);

    /**
     * 修改教师教育经历
     */
    int updataTeacherEdu(Education education);

    /**
     * 查询教师教育经历
     */
    List<Education> getTeacherEduByName(String name);

    /**
     * 删除教师教育经历经历
     */
    int deleteTeacherEdu(String name, String type);
}
