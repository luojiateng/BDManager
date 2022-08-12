package com.kaizi.entity;

import java.sql.Date;
import java.util.Objects;

public class ClassInfo {

    int clsId;
    String clsName;
    Date grade;
    int stuCount;
    String teaNum;
    String key1;
    int key2;

    public ClassInfo() {
    }

    public ClassInfo(int clsId, String clsName, Date grade, int stuCount, String teaNum, String key1, int key2) {
        this.clsId = clsId;
        this.clsName = clsName;
        this.grade = grade;
        this.stuCount = stuCount;
        this.teaNum = teaNum;
        this.key1 = key1;
        this.key2 = key2;
    }

    public ClassInfo(String clsName, Date grade, int stuCount, String teaNum, String key1, int key2) {
        this.clsName = clsName;
        this.grade = grade;
        this.stuCount = stuCount;
        this.teaNum = teaNum;
        this.key1 = key1;
        this.key2 = key2;
    }

    public int getClsId() {
        return clsId;
    }

    public void setClsId(int clsId) {
        this.clsId = clsId;
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public Date getGrade() {
        return grade;
    }

    public void setGrade(Date grade) {
        this.grade = grade;
    }

    public int getStuCount() {
        return stuCount;
    }

    public void setStuCount(int stuCount) {
        this.stuCount = stuCount;
    }

    public String getTeaNum() {
        return teaNum;
    }

    public void setTeaNum(String teaNum) {
        this.teaNum = teaNum;
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
        ClassInfo classInfo = (ClassInfo) o;
        return clsId == classInfo.clsId && stuCount == classInfo.stuCount && key2 == classInfo.key2 && Objects.equals(clsName, classInfo.clsName) && Objects.equals(grade, classInfo.grade) && Objects.equals(teaNum, classInfo.teaNum) && Objects.equals(key1, classInfo.key1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clsId, clsName, grade, stuCount, teaNum, key1, key2);
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "clsId=" + clsId +
                ", clsName='" + clsName + '\'' +
                ", grade=" + grade +
                ", stuCount=" + stuCount +
                ", teaNum='" + teaNum + '\'' +
                ", key1='" + key1 + '\'' +
                ", key2=" + key2 +
                '}';
    }
}
