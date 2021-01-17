package com.microservice.cyz.java8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Predicate;

/**
 * @author 崔耀中
 * @since 2021-01-12
 */
@Data
@AllArgsConstructor
public class Employee {

    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;


    public static Predicate<Employee> ageGreaterThan70 = x -> x.getAge() > 70;

    public static Predicate<Employee> genderM = x -> x.getGender().equals("M");



}
