package com.kaizi.entity;

import java.sql.Date;
import java.util.Objects;

public class Student {
        private  String stuNum;
        private  int clsId;
        private  String stuName;
        private  Date stuBtd;
        private  String pwd;
        private  int state;
        private  int sex;
        private  int roleId;
        private  String key1;
        private  int key2;

 public Student(String stuNum, int clsId, String stuName, Date stuBtd, String pwd, int state, int sex, int roleId, String key1, int key2) {
  this.stuNum = stuNum;
  this.clsId = clsId;
  this.stuName = stuName;
  this.stuBtd = stuBtd;
  this.pwd = pwd;
  this.state = state;
  this.sex = sex;
  this.roleId = roleId;
  this.key1 = key1;
  this.key2 = key2;
 }

 public Student() {

 }

 public Student(String stuNum, int clsId, String stuName, Date stuBtd, String pwd, int state, int sex, int roleId) {
  this.stuNum = stuNum;
  this.clsId = clsId;
  this.stuName = stuName;
  this.stuBtd = stuBtd;
  this.pwd = pwd;
  this.state = state;
  this.sex = sex;
  this.roleId = roleId;

 }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public int getClsId() {
        return clsId;
    }

    public void setClsId(int clsId) {
        this.clsId = clsId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Date getStuBtd() {
        return stuBtd;
    }

    public void setStuBtd(Date stuBtd) {
        this.stuBtd = stuBtd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public int getKey2() {
        return key2;
    }

    public void setKey2(int key2) {
        this.key2 = key2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return clsId == student.clsId && state == student.state && sex == student.sex && roleId == student.roleId && key2 == student.key2 && Objects.equals(stuNum, student.stuNum) && Objects.equals(stuName, student.stuName) && Objects.equals(stuBtd, student.stuBtd) && Objects.equals(pwd, student.pwd) && Objects.equals(key1, student.key1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuNum, clsId, stuName, stuBtd, pwd, state, sex, roleId, key1, key2);
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", clsId=" + clsId +
                ", stuName='" + stuName + '\'' +
                ", stuBtd=" + stuBtd +
                ", pwd='" + pwd + '\'' +
                ", state=" + state +
                ", sex=" + sex +
                ", roleId=" + roleId +
                ", key1='" + key1 + '\'' +
                ", key2=" + key2 +
                '}';
    }
}
