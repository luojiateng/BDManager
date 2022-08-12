package com.kaizi.test;

import java.util.List;

import com.kaizi.dao.CourseArrangementDAO;
import com.kaizi.entity.CourseArrangement;

public class CourseArrangementDAOTest {
    public static  void testSave(){
        int lesId=1;
        String teaNum="19800201";
        int clsId=38;
        int year=2019;
        int semester=1;
         CourseArrangement ca=new CourseArrangement(lesId,teaNum ,clsId,year,semester);
        CourseArrangementDAO courseArrangementDAO=new CourseArrangementDAO();
        boolean ok= courseArrangementDAO.save(ca);
        if (ok){
            System.out.println("新增班级信息成功");
        }else{
            System.out.println("新增班级信息失败");
        }






    }
    public static void delete(){

    }
    public static void TestQuery(){
        CourseArrangementDAO courseArrangementDAO=new CourseArrangementDAO();
        List<CourseArrangement> ts=courseArrangementDAO.query();
        System.out.println(ts.size());
        for (CourseArrangement ca:ts) {
            System.out.println(ca);
        }

    }
    public static void TestFindById(){
        CourseArrangementDAO courseArrangementDAO=new CourseArrangementDAO();
        CourseArrangement ca= courseArrangementDAO.findById(26);
        System.out.println(ca);


    }

    public static void main(String[] args) {
       // testSave();
        //TestQuery();
        TestFindById();
    }


}
