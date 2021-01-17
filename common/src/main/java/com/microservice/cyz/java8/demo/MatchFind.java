package com.microservice.cyz.java8.demo;

import com.microservice.cyz.java8.dto.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author 崔耀中
 * @since 2021-01-13
 */
public class MatchFind {

    public static void main(String[] args) {
        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        boolean isExistAgeThan70 = false;
        for(Employee employee:employees){
            if(employee.getAge() > 70){
                isExistAgeThan70 = true;
                break;
            }
        }
        System.out.println(isExistAgeThan70);

        //lambda
        boolean isExistAgeThan71 = employees.stream().anyMatch(Employee.ageGreaterThan70);
        System.out.println(isExistAgeThan71);

        //谓词方式
        boolean isExistAgeThan72 = employees.stream().anyMatch(e -> e.getAge() > 72);
        System.out.println(isExistAgeThan72);

        //是否年龄都大于10岁
        boolean isExistAgeThan10 = employees.stream().allMatch(e -> e.getAge() > 10);

        //是否存在小于18岁的员工
        boolean isExistAgeLess18 = employees.stream().noneMatch(e -> e.getAge() < 18);

        //Optional类代表一个值存在或者不存在 get() 会在值存在时返回值，否则?出一个 NoSuchElement 异常
        Optional<Employee> employeeOptional
                =  employees.stream().filter(e -> e.getAge() > 40).findFirst();
        System.out.println(employeeOptional.get());

        //isPresent判断是否存在这样的值
        boolean is =   employees.stream()
                .filter(e -> e.getAge() > 40)
                .findFirst()
                .isPresent();


        //如果存在，可以进行操作
//        employees.stream()
//                .filter(e -> e.getAge() > 40)
//                .findFirst()
//                .isPresent(e -> System.out.println(e));

        //orElse 如果不存在，给一个默认值

        employees.stream()
                .filter(e -> e.getAge() > 40)
                .findFirst()
                .orElse(new Employee(10,45,"M","Naveen","Jain"));



    }




}
