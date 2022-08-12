package dao;


import pojo.Postion;
import pojo.Title;

import java.util.List;

public interface PostionDao {
    /**
     * 新增职位
     */
    int insertPostion(String position);

    /**
     * 删除职位
     */
    int deletePostion(String name);

    /**
     * 更新职位
     */
    int updataPostion(String oldPosition, String newPosition);

    /**
     * 得到所有的职位名字
     */
    List<String> getAllPostionName();

    /**
     * 新增职称时，返回主键最大值+1作为新的职位的id，返回这个值给管理提示
     */
    int getNextIndex();

    /**
     * 返回通过职务名获取职务id
     */
    int getPostIdByName(String name);
}
