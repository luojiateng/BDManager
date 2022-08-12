package com.kaizi.test;

import java.sql.Date;
import java.util.List;

import com.kaizi.dao.ClasssInfoDAO;
import com.kaizi.dao.TeacherDAO;
import com.kaizi.entity.ClassInfo;
import com.kaizi.entity.Teacher;

public class ClassInfoDAOTest {
    public static  void testDelete(){
        ClasssInfoDAO classsInfoDAO=new ClasssInfoDAO();
        boolean ok=classsInfoDAO.delete("60");
        if(ok){
            System.out.println("删除班级信息成功");
        }
        else{
            System.out.println("删除班级信息失败");
        }

    }

    public static  void testSave(){
        //  String lesId="6";
        String clsName= "计科10班";
        Date grade= null;
        int stuCount=33;
        String teaNum="19800201";
        String key1=null;
        int key2 =0;
        ClassInfo c=new ClassInfo(clsName,grade ,stuCount,teaNum,key1,key2);
        ClasssInfoDAO classsInfoDAO=new ClasssInfoDAO();
        boolean ok= classsInfoDAO.save(c);
        if (ok){
            System.out.println("新增班级信息成功");
        }else{
            System.out.println("新增班级信息失败");
        }


    }
    public static  void testQuery(){
        ClasssInfoDAO classsInfoDAO=new ClasssInfoDAO();
        List<ClassInfo> ts=classsInfoDAO.query();
        System.out.println(ts.size());
        for (ClassInfo c:ts) {
            System.out.println(c);
        }
    }
    public static  void testFindById(){
        ClasssInfoDAO classsInfoDAO=new ClasssInfoDAO();
        ClassInfo c= classsInfoDAO.findById("41");
        System.out.println(c);

    }
    public static  void testUpdate(){
        int clsId = 60;
        String clsName="计科100班";
        Date grade=null;
        int stuCount = 0;
        String teaNum="19820103";
        String key1=null;
        int key2 =0;
        ClassInfo c=new ClassInfo(clsId,clsName,grade,stuCount,teaNum,key1,key2);
        ClasssInfoDAO classsInfoDAO=new ClasssInfoDAO();
        boolean ok=classsInfoDAO.update(c);
        if(ok){
            System.out.println("修改班级信息成功");
        }
        else{
            System.out.println("修改老班级息失败");
        }

    }



    public static void main(String[] args) {
     //testSave();
      // testQuery();
        //testFindById();
       // testUpdate();
        testDelete();

    }

}
