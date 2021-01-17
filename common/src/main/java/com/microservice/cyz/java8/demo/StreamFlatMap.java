package com.microservice.cyz.java8.demo;

import java.util.Arrays;
import java.util.List;

/**
 * flatMap 处理多维数组，相当于多个for循环
 * @author 崔耀中
 * @since 2021-01-12
 */
public class StreamFlatMap {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("hello","word");
        words.stream()
                .map(w -> Arrays.stream(w.split("")))
                .forEach(System.out::println);


        words.stream()
                .flatMap(w -> Arrays.stream(w.split("")))
                .forEach(System.out::println);
    }

}
