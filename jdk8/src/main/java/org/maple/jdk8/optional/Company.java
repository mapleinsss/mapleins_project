package org.maple.jdk8.optional;

import java.util.List;

/**
 * @Author Mapleins
 * @Date 2019-04-04 18:52
 * @Description
 */
public class Company {

    private String name;

    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
