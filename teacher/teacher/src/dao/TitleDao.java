package dao;


import pojo.Title;

import java.util.List;

public interface TitleDao {
    /**
     * 新增职称
     */
    int insertTitle(Title title);

    /**
     * 删除职称
     */
    int deleteTitle(String name);

    /**
     * 更新职称
     */
    int updataTitle(String oldname, String newname);

    /**
     * 得到所有的职称
     */
    List<String> getAllTitleName();

    /**
     * 新增职称时，返回主键最大值+1作为新的职称的id，返回这个值给管理提示
     */
    int getNextIndex();

    /**
     * 通过职称名获得职称的ID
     */
    int getTitleIdByName(String name);
}
