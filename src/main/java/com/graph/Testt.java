package com.graph;

import java.util.stream.DoubleStream;

public class Testt {

    public static void main(String[] args) {
        Testt.printNum();
    }

    private static void printNum(int num) {
        if (num < 10) {
            System.out.println(num * 11);
            Testt.printNum(++num);
        }
    }

    private static void printNum() {
//        IntStream.range(1, 10).map(e -> 11 * e).forEach(System.out::println);
        DoubleStream.generate(() -> {
            return Math.random();
        }).map(e -> 11 * e).forEach(System.out::println);
    }
}
