package com.kaizi.entity;

import java.util.Date;
import java.util.Objects;

public class Teacher {
    private String teaNum;
    private String teaName;
    private String teaTitle;
    private int teaTypeId;
    private Date teaBtd;
    private String  pwd;
    private int state;
    private int roleId;
    private String key1;
    private int key2;

    public String getTeaNum() {
        return teaNum;
    }

    public void setTeaNum(String teaNum) {
        this.teaNum = teaNum;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String name) {
        teaName = teaName;
    }

    public String getTeaTitle() {
        return teaTitle;
    }

    public void setTeaTitle(String teaTitle) {
        this.teaTitle = teaTitle;
    }

    public int getTeaTypeId() {
        return teaTypeId;
    }

    public void setTeaTypeId(int teaTypeId) {
        this.teaTypeId = teaTypeId;
    }

    public Date getTeaBtd() {
        return teaBtd;
    }

    public void setTeaBtd(Date teaBtd) {
        this.teaBtd = teaBtd;
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

    public Teacher(String teaNum, String teaName, String teaTitle, int teaTypeId, Date teaBtd, String pwd, int state, int roleId) {
        this.teaNum = this.teaNum;
        this.teaName = this.teaName;
        this.teaTitle = this.teaTitle;
        this.teaTypeId = this.teaTypeId;
        this.teaBtd = this.teaBtd;
        this.pwd = this.pwd;
    }

    public Teacher(String teaNum, String teaName, String teaTitle, int teaTypeId, Date teaBtd, String pwd, int state, int roleId, String key1, int key2) {
        this.teaNum = teaNum;
        this.teaName = teaName;
        this.teaTitle = teaTitle;
        this.teaTypeId = teaTypeId;
        this.teaBtd = teaBtd;
        this.pwd = pwd;
        this.state = state;
        this.roleId = roleId;
        this.key1 = key1;
        this.key2 = key2;
    }

    @Override
    public String   toString() {
        return "Teacher{" +
                "teaNum='" + teaNum + '\'' +
                ", teaName='" + teaName + '\'' +
                ", teaTitle='" + teaTitle + '\'' +
                ", teaTypeId=" + teaTypeId +
                ", teaBtd=" + teaBtd +
                ", pwd='" + pwd + '\'' +
                ", state=" + state +
                ", roleId=" + roleId +
                ", key1='" + key1 + '\'' +
                ", key2=" + key2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return teaTypeId == teacher.teaTypeId && state == teacher.state && roleId == teacher.roleId && key2 == teacher.key2 && Objects.equals(teaNum, teacher.teaNum) && Objects.equals(teaName, teacher.teaName) && Objects.equals(teaTitle, teacher.teaTitle) && Objects.equals(teaBtd, teacher.teaBtd) && Objects.equals(pwd, teacher.pwd) && Objects.equals(key1, teacher.key1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teaNum, teaName, teaTitle, teaTypeId, teaBtd, pwd, state, roleId, key1, key2);
    }

    public Teacher(String teaNum, String teaName, String teaTitle, int teaTypId, Date teaBtd, String pwd, int statiC, String key1, int key2){

    }

	public Teacher(String teaNum2, String teaName2, String teaTitle2, String teaTypeId2, Date teaBtd2, String pwd2,
			int state2, int roleId2, String string, int i) {
		// TODO Auto-generated constructor stub
	}
   }
