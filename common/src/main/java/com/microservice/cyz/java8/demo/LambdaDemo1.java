package com.microservice.cyz.java8.demo;

import lombok.val;

/**
 * @author 崔耀中
 * @since 2021-01-12
 */
public class LambdaDemo1 {

    interface Printer{
        void printer(String val);
    }

    public void pringSomthing(String somthing,Printer printer){
        printer.printer(somthing);

    }

    public static void main(String[] args) {
        LambdaDemo1 lambdaDemo1 = new LambdaDemo1();
        String somthing  = "java,python";

//        Printer printer = new Printer() {
//            @Override
//            public void printer(String val) {
//                System.out.println(val);
//            }
//        };

        //lambda
//        Printer printer = (String val) -> {
//            System.out.println(val);
//        };

        //参数的类型可以去掉
//        Printer printer = (val) -> {
//            System.out.println(val);
//        };

        //只有一个参数，可以去掉参数的括号
//        Printer printer = val -> {
//            System.out.println(val);
//        };

        //函数体只有一行代码，可以去掉花括号
        Printer printer = val -> System.out.println(val);

        lambdaDemo1.pringSomthing(somthing,printer);

        //终版
        lambdaDemo1.pringSomthing(somthing,val -> System.out.println(val));

        //状态 ，多用户多现成操作的同一个东西，存在数据库或者redis

        //并行，提升速度，但是无法保证顺序 .parallel()  会对有状态操作有影响   并行适合处理有序的数据，比如数组， 不适处理链表linklist,

    }

}
