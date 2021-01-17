package com.microservice.cyz.java8;

import java.util.*;

/**
 * @author 崔耀中
 * @since 2021-01-11
 */
public class LambdaUtil {
    
    
    /**
     * @Description stream学习
     * @Param 
     */
    public static void main(String[] args) {

        List<Map<String ,String>> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("aa","aa");
        map.put("bb","bb");
        map.put("cc","cc");
        list.add(map);
        long count = list.stream().filter(a -> a.get("aa").equals("aa")).map(b -> {b.put("aa","dd");return null;}).count();
        System.out.println(count);
        System.out.println(list.get(0).get("aa"));


        List<String> stringList = Arrays.asList("Java","Python","C++","PHP");
        String s = qryMinLteerString(stringList);
        System.out.println(s);

    }

    /**
     * @Description 找出数组中小写字母最多的字符串，并输出
     * @Param
     */
    public static String qryMinLteerString(List<String> list){
        list.stream().sorted(Comparator.comparing(s -> s.chars().filter(Character::isLowerCase).count())).forEach(System.out::println);

        return list.stream().max(Comparator.comparing(s -> s.chars().filter(Character::isLowerCase).count())).get();
    }

}
