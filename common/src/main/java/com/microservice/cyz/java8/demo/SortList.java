package com.microservice.cyz.java8.demo;

import com.microservice.cyz.java8.dto.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 崔耀中
 * @since 2021-01-13
 */
public class SortList {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "Milan",
                "london",
                "San Francisco",
                "Tokyo",
                "New Delhi"
        );
        System.out.println(cities);
        //[Milan, london, San Francisco, Tokyo, New Delhi]

        //大小写不敏感
        cities.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(cities);
        //[london, Milan, New Delhi, San Francisco, Tokyo]

        //自然排序，大小写敏感
        cities.sort(Comparator.naturalOrder());
        System.out.println(cities);
        //[Milan, New Delhi, San Francisco, Tokyo, london]

        cities.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        //Milan
        //New Delhi
        //San Francisco
        //Tokyo
        //london

        List<Integer> numbers = Arrays.asList(6, 2, 1, 4, 9);
        System.out.println(numbers); //[6, 2, 1, 4, 9]

        numbers.sort(Comparator.naturalOrder());  //自然排序
        System.out.println(numbers); //[1, 2, 4, 6, 9]

        numbers.sort(Comparator.reverseOrder()); //倒序排序
        System.out.println(numbers);  //[9, 6, 4, 2, 1]

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

        employees.sort(
                Comparator.comparing(Employee::getGender)
                .thenComparingInt(Employee::getAge)
                .reversed()
        );
        employees.forEach(System.out::println);
        //都是正序 ，不加reversed
        //都是倒序，最后面加一个reserved
        //先是倒序（加reserved），然后正序
        //先是正序（加reserved），然后倒序（加reserved）

        employees.sort(Comparator.comparing(Employee::getAge));
        employees.forEach(System.out::println);


        //函数方式
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getAge() == o2.getAge()){
                    return 0;
                }
                return o1.getAge() - o2.getAge() > 0 ? -1 : 1;
            }
        });

        //lambda方式
        employees.sort(( o1,  o2) -> {
            if (o1.getAge() == o2.getAge()) {
                return 0;
            }
            return o1.getAge() - o2.getAge() > 0 ? -1 : 1;
        });

    }


}
