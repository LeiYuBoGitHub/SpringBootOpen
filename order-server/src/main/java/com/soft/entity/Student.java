package com.soft.entity;

/**
 * @author 野性的呼唤
 * @Date: 2020/10/19 23:15
 * @Description:
 */
public class Student {

    private Long studentId;

    private String title;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", title='" + title + '\'' +
                '}';
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
