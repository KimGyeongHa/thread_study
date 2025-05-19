package lambda.stream;

import lambda.question.CustomStream;

import java.util.List;
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


    }


}
