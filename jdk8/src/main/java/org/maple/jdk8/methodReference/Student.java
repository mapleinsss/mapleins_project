package org.maple.jdk8.methodReference;

/**
 * @Author Mapleins
 * @Date 2019-04-05 0:30
 * @Description
 */
public class Student {

    private String name;
    private Integer score;

    //当前对象和传入的对象比较，正确的设计
    public int compareByScore(Student student) {
        return this.getScore() - student.getScore();
    }

    //根据分数排序，升序
    public static int compareStudentByScore(Student s1, Student s2) {
        return s1.getScore() - s2.getScore();
    }

    //根据名字进行比较
    public static int compareStudentByName(Student s1, Student s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }

    public Student() {
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
