package lambda.stream;

import lambda.question.CustomStream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Stream1 {

    public static void main(String[] args) {

        List<String> banana = List.of("Banana", "Apple", "Orange");

        System.out.println(banana.stream().filter(s -> s.startsWith("A")).map(String::toUpperCase).toList().toString());

        List<String> banana1 = List.of("Banana", "Apple", "Orange");
        banana1.stream().map(String::toUpperCase).toList();
        List<String> list1 = banana1.stream().map(String::toLowerCase).toList();

        Stream<List<String>> banana2 = Stream.of(banana1);
        banana2.forEach(System.out::println);
        //banana2.forEach(System.out::println);

        List<Integer> list = List.of(1,2,3,4,5,6);

        CustomStream.of(list)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 10)
                .forEach(System.out::println);

        list.stream().filter(n -> n % 2 == 0).map(n -> n * 10).forEach(System.out::println);


        Stream.generate(Math::random).limit(10).forEach(System.out::println);


        List<Integer> list2 = List.of(1, 2, 3, 4, 5, 6);


        list2.stream().peek(System.out::println).map(n -> n * 2).peek(System.out::println).forEach(System.out::println);
        list2.stream().takeWhile(n -> n < 4).forEach(System.out::println);
        list2.stream().dropWhile(n -> n < 4).forEach(System.out::println);

        List<List<TestClass>> target = List.of(
                List.of(
                        new TestClass("kimgyeongha1"),
                        new TestClass("kimgyeongha2"),
                        new TestClass("kimgyeongha3")
                ),
                List.of(
                        new TestClass("kimgyeongha4"),
                        new TestClass("kimgyeongha5"),
                        new TestClass("kimgyeongha6")
                )
        );

        target.stream().flatMap(List::stream).forEach(n -> System.out.print(n.getName() + " "));


    }

    static class TestClass{
        private String name;

        public TestClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
