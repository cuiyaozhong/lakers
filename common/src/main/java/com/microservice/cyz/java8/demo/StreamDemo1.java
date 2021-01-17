package com.microservice.cyz.java8.demo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 崔耀中
 * @since 2021-01-12
 */
public class StreamDemo1 {

    public static void main(String[] args) {
        List<String> players = Arrays.asList("kobe", "james", "curry", "cyyt");

//        for (String player: players){
//            if (player.startsWith("L")){
//                String temp = player.toUpperCase();
//
//            }
//        }

        //streamAPI  将'c'开头的字母大写，然后排序，然后生成新的list输出
        List<String> pls = players.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(pls);
        pls.stream().forEach(System.out::print);

        //数组 转stream
        /*String[] players1 = {"kobe", "james", "curry", "cyyt"};
        Stream.of(players1).filter().map()*/

        //set转stream  和list一样
        /*Set<String> players2 = new HashSet<>(players);
        List<String> pls = players2.stream().filter()*/

        //文本文件
        /*Paths.get("file.txt");
        //kobe
        //james
        Stream<String> lines = Files.lines(Paths.get("file.txt"));*/


    }








}
