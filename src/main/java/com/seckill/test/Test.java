//package com.seckill.test;
//
//import java.util.*;
//
///**
// * Created by jp on 2016/5/21.
// */
//public class Test {
//    interface Formula {
//        double calculate(int a);
//
//        default double sqrt(int a) {
//            return Math.sqrt(a);
//        }
//    }
//
//    interface Converter<F, T> {
//        T convert(F from);
//
//        default int test() {
//            return 0;
//        }
//    }
//
//    static class Person {
//        String firstName;
//        String lastName;
//
//        Person() {
//        }
//
//        public Person(String firstName) {
//            this.firstName = firstName;
//        }
//
//        Person(String firstName, String lastName) {
//            this.firstName = firstName;
//            this.lastName = lastName;
//        }
//    }
//
//    interface PersonFactory<P extends Person> {
//        P create(String firstName, String lastName);
//    }
//
//    static class Something {
//        public String startsWith(String str) {
//            return String.valueOf(str.charAt(0));
//        }
//    }
//
//    public static void main(String[] args) {
//        Formula formula0 = Double::valueOf;
//        Formula formula = (a) -> formula0.sqrt(a * 100);
//
//        System.out.println(formula.calculate(100));
//        System.out.println(formula.sqrt(16));
//
//        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
//        Collections.sort(names, (String a, String b) -> b.compareTo(a));
//        System.out.println(names);
//
//
//        Converter<String, Integer> converter = Integer::valueOf;
//        Integer converted = converter.convert("123");
//        System.out.println(converted);    // 123
//        Something something = new Something();
//        Converter<String, String> converter1 = something::startsWith;
//        String converted1 = converter1.convert("Java");
//        System.out.println(converted1);    // "J"
//
//        PersonFactory<Person> personFactory = Person::new;
//        Person p = personFactory.create("a", "b");
//
//        List<String> list = new ArrayList<>();
//        list.add("hhh");
//        list.add("kkk");
//        list.add("aaa");
//        list.add("aaa2");
//        list.add("ccc4");
//        list.add("bbb");
//        list.add("ccc");
//        list.add("ddd");
//        list.add("eee");
//        list.add("fff");
//
//        list.stream().filter((a) -> a.startsWith("a")).forEach(System.out::println);
//        list.stream().map(String::toUpperCase).forEach(System.out::println);
//        Optional<String> reduce = list.stream().reduce((a, b) -> a.concat(",").concat(b));
//        reduce.ifPresent(System.out::println);
//        if (reduce.isPresent()) {
//            System.out.println(reduce.get());
//        }
//        //int max = 1000000;
//        //List<String> values = new ArrayList<>(max);
//        //for (int i = 0; i < max; i++) {
//        //    UUID uuid = UUID.randomUUID();
//        //    values.add(uuid.toString());
//        //}
//
//        //long t0 = System.nanoTime();
//        //System.out.println(t0);
//        //long count = values.stream().sorted().count();
//        //System.out.println(count);
//        //
//        //long t1 = System.nanoTime();
//        //
//        //long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//        //System.out.println(String.format("sequential sort took: %d ms", millis));
//
//        //long t0 = System.nanoTime();
//        //long count = values.parallelStream().sorted().count();
//        //System.out.println(count);
//        //
//        //long t1 = System.nanoTime();
//        //
//        //long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//        //System.out.println(String.format("parallel sort took: %d ms", millis));
//    }
//}
