package com.kaizi.entity;

import java.util.Objects;

public class CourseArrangement {
    int caId;
    int lesId;
    String teaNum;
    int clsId;
    int  year;
    int  semester;

    public CourseArrangement() {
    }

    public CourseArrangement(int caId, int lesId, String teaNum, int clsId, int year, int semester) {
        this.caId = caId;
        this.lesId = lesId;
        this.teaNum = teaNum;
        this.clsId = clsId;
        this.year = year;
        this.semester = semester;
    }

    public CourseArrangement(int lesId, String teaNum, int clsId, int year, int semester) {
        this.lesId = lesId;
        this.teaNum = teaNum;
        this.clsId = clsId;
        this.year = year;
        this.semester = semester;
    }

    public int getCaId() {
        return caId;
    }

    public void setCaId(int caId) {
        this.caId = caId;
    }

    public int getLesId() {
        return lesId;
    }

    public void setLesId(int lesId) {
        this.lesId = lesId;
    }

    public String getTeaNum() {
        return teaNum;
    }

    public void setTeaNum(String teaNum) {
        this.teaNum = teaNum;
    }

    public int getClsId() {
        return clsId;
    }

    public void setClsId(int clsId) {
        this.clsId = clsId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseArrangement that = (CourseArrangement) o;
        return caId == that.caId && lesId == that.lesId && clsId == that.clsId && year == that.year && semester == that.semester && Objects.equals(teaNum, that.teaNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caId, lesId, teaNum, clsId, year, semester);

    }

    @Override
    public String toString() {
        return "courseArrangement{" +
                "caId=" + caId +
                ", lesId=" + lesId +
                ", teaNum='" + teaNum + '\'' +
                ", clsId=" + clsId +
                ", year=" + year +
                ", semester=" + semester +
                '}';
    }
}
