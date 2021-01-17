package com.microservice.cyz.java8.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 崔耀中
 * @since 2021-01-12
 */
public class StreamMap1 {

    public static void main(String[] args) {
        List<String> alpha = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");

        //不使用Streatm管道流
        List<String> alphaUpper = new ArrayList<>();
        for (String s : alpha){
            alphaUpper.add(s.toUpperCase());

        }

        System.out.println(alphaUpper); //[MONKEY, LION, GIRAFFE, LEMUR]


        List<String> collect = alpha.stream()
                .map(String::toUpperCase) //相当于 .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(collect);

        Stream.of("Monkey","line","Giraffr","Lemur")
                .mapToInt(String::length)
                .forEach(System.out::println);
    }


}
