package dao;

import java.util.List;

public interface SchoolDao {
    /**
     * 通过学校名获取学校Id
     */
    int getSchoolIdByName(String name);
    List<String >getAllSchoolName();

}
