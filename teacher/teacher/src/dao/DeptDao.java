package dao;


import pojo.Department;
import pojo.Title;

import java.util.List;

public interface DeptDao {

    /**
     * 新增部门
     */
    int insertDept(Department department);

    /**
     * 删除部门
     */
    int deleteDept(String name);

    /**
     * 更新部门
     */
    int updataDept(String oldname, String newDepNameText);

    /**
     * 得到所有的部门名
     */
    List<String> getAllDeptName();

    /**
     * 通过部门名查询部门的职称信息
     */
    List<Department> getAllDeptInfo(String name);

    /**
     * 通过名字查询id
     * @param name
     * @return
     */
    int getDeptIdByName(String name);

    /**
     * 新增职称时，返回主键最大值+1作为新的部门的id，返回这个值给管理提示
     */
    int getNextIndex();

}
