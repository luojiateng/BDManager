package com.kaizi.entity;

import java.util.Objects;

public class Lesson {
    private int lesId;
    private String lesName;
    private String context;
    private int score;
    private int hours;

    public Lesson() {
    }

    public Lesson(int lesId, String lesName, String context, int score, int hours) {
        this.lesId = lesId;
        this.lesName = lesName;
        this.context = context;
        this.score = score;
        this.hours = hours;
    }

    public Lesson(String lesName, String context, int score, int hours) {
        this.lesName = lesName;
        this.context = context;
        this.score = score;
        this.hours = hours;
    }

    public int getLesId() {
        return lesId;
    }

    public void setLesId(int lesId) {
        this.lesId = lesId;
    }

    public String getLesName() {
        return lesName;
    }

    public void setLesName(String lesName) {
        this.lesName = lesName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lesId=" + lesId +
                ", lesName='" + lesName + '\'' +
                ", score=" + score +
                ", hours=" + hours +
                ", context='" + context + '\'' +
                '}';
    }
}