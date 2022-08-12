package dao;


import java.util.List;

public interface RelationDao {
    /**
     * 根据家庭关系获取相应的id
     */
    int getRelationIdByName(String name);

    /**
     * 查询家庭关系
     */
    List<String> getFamilyType();
}
