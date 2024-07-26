package com.samples.rajesh;

import java.util.Map;
import java.util.stream.Collectors;

public class CountCharsString {

    public static void main(String[] args) {
        String input = "abcdefabdfg";
        System.out.println(getResult(input));

    }
    public static Map<String,Long> getResult(String s)
    {
        return s.chars().mapToObj(obj -> (char)obj).collect(Collectors.groupingBy(Object::toString,Collectors.counting()));
    }
}