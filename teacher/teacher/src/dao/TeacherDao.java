package dao;

import pojo.Teacher;

import java.util.List;


public interface TeacherDao {
    /**
     * 保存教师
     *
     * @param teacher
     * @return
     */
    int saveTeacher(Teacher teacher);

    /**
     * 得到所有的教师信息
     *
     * @return
     */
    List<Teacher> getAllTeacher();

    /**
     * 通过姓名查询教师信息，可模糊查询
     */
    List<Teacher> getTeacherByName(String name);

    /**
     * 新增教师的时候获取新增教师的id
     */
    int getNewTeacherId();

    /**
     *更新教师信息
     */
    int updataTeacher(Teacher teacher);


    /**
     * 通过教师名字删除教师
     */
    int deletTeacherByName(String nane);

}
