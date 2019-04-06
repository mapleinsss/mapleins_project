package org.maple.jdk8.methodReference;

/**
 * @Author Mapleins
 * @Date 2019-04-05 0:51
 * @Description
 */
public class StudentComparator {

    //根据分数排序，升序
    public int compareStudentByScore(Student s1,Student s2){
        return s1.getScore() - s2.getScore();
    }

    //根据名字进行比较
    public int compareStudentByName(Student s1,Student s2){
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
}
