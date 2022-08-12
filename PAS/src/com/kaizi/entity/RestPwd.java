package com.kaizi.entity;

import java.util.Objects;

public class RestPwd {
    String stuNum;
    String question1;
    String answer1;
    String question2;
    String answer2;
    String question3;
    String answer3;
    int requestCount;

    public RestPwd(String stuNum, String question1, String answer1, String question2, String answer2, String question3, String answer3, int requestCount) {
        this.stuNum = stuNum;
        this.question1 = question1;
        this.answer1 = answer1;
        this.question2 = question2;
        this.answer2 = answer2;
        this.question3 = question3;
        this.answer3 = answer3;
        this.requestCount = requestCount;
    }


    public RestPwd() {

    }

    public RestPwd(String question1, String answer1, String question2, String answer2, String question3, String answer3, int requestCount) {
        this.question1 = question1;
        this.answer1 = answer1;
        this.question2 = question2;
        this.answer2 = answer2;
        this.question3 = question3;
        this.answer3 = answer3;
        this.requestCount = requestCount;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestPwd restPwd = (RestPwd) o;
        return requestCount == restPwd.requestCount && Objects.equals(stuNum, restPwd.stuNum) && Objects.equals(question1, restPwd.question1) && Objects.equals(answer1, restPwd.answer1) && Objects.equals(question2, restPwd.question2) && Objects.equals(answer2, restPwd.answer2) && Objects.equals(question3, restPwd.question3) && Objects.equals(answer3, restPwd.answer3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuNum, question1, answer1, question2, answer2, question3, answer3, requestCount);
    }

    @Override
    public String toString() {
        return "RestPwd{" +
                "stuNum='" + stuNum + '\'' +
                ", question1='" + question1 + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", question2='" + question2 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", question3='" + question3 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", requestCount=" + requestCount +
                '}';
    }
}
