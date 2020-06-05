package com.xiong.JDK8NewFeaturesDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/29 19:05
 * @description： java stream demo
 * @modified By：
 * @version: $
 */
public class StreamsDemo {

    public static void main(String[] args) {
        //java.util.Stream 表示可以在其上执行一个或多个操作的元素序列。流操作是中间或终端。
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        //filter
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);  //aaa2  aaa1

        // sorted
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);//aaa1  aaa2
        //排序只会创建流的排序视图，而不会操纵支持的集合的排序。
        // stringCollection 的排序是不变的：
        System.out.println(stringCollection);//[ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1]

        //map 中间操作映射通过给定函数将每个元素转换为另一个对象。
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
        //
        //match 使用各种匹配操作来检查某个谓词是否与流匹配
        // anyMatch
        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true
        //allMatch
        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false
        //noneMatch
        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true
        //Count 是一个终端操作，返回流中元素的个数。
        long startsWithB =
                stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();

        System.out.println(startsWithB);    // 3

        //reduce 该终端操作使用给定的功能对流的元素进行缩减
        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
        // "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
    }

}
