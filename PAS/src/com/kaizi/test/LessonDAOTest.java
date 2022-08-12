package com.kaizi.test;

import java.util.List;

import com.kaizi.dao.LessonDAO;
import com.kaizi.entity.Lesson;

public class LessonDAOTest {

       /* LessonDAO_old lessonDAO=new LessonDAO_old();
       //lessonDAO.save();
            lessonDAO.update();
         //lessonDAO.delete();
       // lessonDAO.query();*/

        public static  void testSave(){
          //  String lesId="6";
            String lesName= "计算机组成原理";
            String context= "研究计算机组成";
            int score=6;
            int hours=65;
            Lesson l=new Lesson(lesName,context,hours,score);
            LessonDAO lessonDAO=new LessonDAO();
            boolean ok= lessonDAO.save(l);
            if (ok){
                System.out.println("新增课程信息成功");
            }else{
                System.out.println("新增课程信息失败");
            }

        }


        public static  void testUpdate(){
            int lesId=1;
            String lesName="软件工程";
            String context="编程";
            int score=4;
            int hours=50;
            Lesson l=new Lesson(lesId,lesName,context,score,hours);
            LessonDAO lessonDAO=new LessonDAO();
            boolean ok= lessonDAO.update(l);
            if(ok){
                System.out.println("修改课程信息成功");
            }
            else{
                System.out.println("修改课程信息失败");
            }

        }
        public static  void testDelete(){
          LessonDAO lessonDAO=new LessonDAO();
          boolean ok= lessonDAO.delete(25);
            if(ok){
                System.out.println("修改课程信息成功");
            }
            else{
                System.out.println("修改课程信息失败");
            }

        }
        public static  void testFindById(){
            LessonDAO lessonDAO=new LessonDAO();
            Lesson l= lessonDAO.findById("6");
            System.out.println(l);

        }
        public static  void testQuery(){
            LessonDAO lessonDAO=new LessonDAO();
            List<Lesson> ts=lessonDAO.query();
            System.out.println(ts.size());
            for (Lesson l:ts) {
                System.out.println(l);
            }

        }
        public static void main(String[] args) {
           //testSave();
            //testQuery();
            //testUpdate();
            testDelete();
        }


    }

