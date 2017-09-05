package com.jasongj.kafka;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhouq
 * @email zhouq@daqsoft.com
 * @date 2017-09-05 15:25
 * @Version:
 * @Describe:
 */

public class SteamTest {

    @Test
    public void test(){
        IntStream.of(new int[]{1,2,3}).forEach(System.out::println);
        IntStream.range(1,3).forEach(System.out::println);
        IntStream.rangeClosed(1,3).forEach(System.out::println);
    }


    @Test
    public void filter() {

        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] integers = Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);
        Arrays.stream(integers).forEach(System.out::println);
    }

    @Test
    public void map(){

        String lines = "aa BA  a b c ac DASA eas ffdf";
        List<String> collect = Stream.of(lines.split(" ")).filter(word -> word.length() >2 ).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("===============================================");
        List<String> collect1 = collect.stream().map(String::toLowerCase).collect(Collectors.toList());
        collect1.forEach(System.out::println);

    }

    @Test
    public void flatMap(){

        Stream<List<Integer>> listStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );

        Stream<Integer> integerStream = listStream.flatMap(list -> list.stream());
        integerStream.forEach(System.out::println);
    }

    @Test
    public void peek(){
        List<String> collect = Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped  value: " + e))
                .collect(Collectors.toList());

        collect.stream().forEach(System.out::println);

    }

    @Test
    public  void Optional(){

        String str = null;
        Integer integer = Optional.ofNullable(str).map(String::length).orElse(-1);
        //orElseThrow
//        try {
//            Optional.ofNullable(str).orElseThrow( Exception::new);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Optional.ofNullable(str).orElseGet(() -> "");
        System.out.println(integer);
    }
    @Test
    public void reduce(){
        //字符串连接
        String reduce = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(reduce);

        //求最小值
        Double min = Stream.of(-1.5, -1.0, -3.0, -5.0, 1.0, 2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(min);

        //求和 有初始值
        Integer sum = Stream.of(1, 2, 3, 4).reduce(1, Integer::sum);
        System.out.println(sum);

        //求和 无初始值
        Integer sum2 = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();

        System.out.println(sum2);

        //过滤 字符串连接
        Optional<String> reduce1 = Stream.of("a", "B", "c", "D").filter(x -> x.compareTo("Z") < 0).reduce(String::concat);
        String s = reduce1.get();
        System.out.println(s);

    }
}
