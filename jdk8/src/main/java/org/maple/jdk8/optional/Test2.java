package org.maple.jdk8.optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @Author Mapleins
 * @Date 2019-04-04 18:53
 * @Description
 */
public class Test2 {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.setName("zhangsan");
        employee2.setName("lisi");

        Company company = new Company();
        company.setName("company1");
//        company.setEmployees(Arrays.asList(employee1,employee2));
        /**
         * 给定一个公司，要求返回 emps 的集合，如果集合为空，返回一个空集合
         */
        //传统方式
        System.out.println(getEmps(company));

    }

    public static List<Employee> getEmps(Company company){
        Optional<Company> optional = Optional.ofNullable(company);
        return optional.map( x -> x.getEmployees() ).orElse(Collections.emptyList() );
    }

}
