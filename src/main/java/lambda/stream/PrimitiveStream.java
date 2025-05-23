package lambda.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStream {

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        int reduce = integers.stream().mapToInt(Integer::intValue).reduce(100, (a, b) -> a + b);
        System.out.println(reduce);

        IntStream range = IntStream.range(1, 10); // 1 ~ 9
        IntStream rangeClosed = IntStream.rangeClosed(1, 30); // 1 ~ 30

        range.max().ifPresent(System.out::println);

        // count, sum, min ,average, max 조회
        IntSummaryStatistics intSummaryStatistics = rangeClosed.summaryStatistics();
        System.out.println(intSummaryStatistics);

        IntStream range1 = IntStream.range(1, 5);
        Stream<Integer> boxed = range1.boxed();

        Stream<Integer> IntegerBoxed = IntStream.range(1, 5).boxed();

        Map<Integer, Integer> collect = IntegerBoxed.collect(
                Collectors.toMap(
                        n -> n * 10,
                        n -> n * 100,
                        (a, b) -> b
                )
        );

        collect.put(10, 10000);
        collect.forEach((k, v) -> System.out.println(k + " " + v));

        List<Student> students = List.of(
                new Student("KIM", 1, 30),
                new Student("USI", 1, 50),
                new Student("LIM", 2, 30),
                new Student("MLM", 2, 50),
                new Student("MIM", 3,70),
                new Student("KMM", 3, 30)
        );

        // group 으로 된 값을 특정한 형태로 변경하고 싶으떄 mapping
       /*
           Map<Integer, List<String>> collect3 = students.stream().collect(
                    Collectors.groupingBy(
                            Student::getGrade,
                            Collectors.mapping(Student::getName, Collectors.toList())
                    )
            );

            collect3.forEach((k, v) -> System.out.println(k + " " + v));
        */

        // downstream 이 후 작업이 필요할 떄 collectingAndThen
        /*
            Map<Integer, String> collect1 = students.stream().collect(
                    Collectors.groupingBy(
                            Student::getGrade,
                            Collectors.collectingAndThen(
                                    Collectors.maxBy(Comparator.comparing(Student::getScore)),
                                    n -> n.get().getName()
                            )
                    )
            );

            collect1.forEach((k, v) -> System.out.println(k + " " + v));
        */

        Map<Boolean, List<String>> collect1 = students.stream().collect(
            Collectors.partitioningBy(
                n -> n.getGrade() == 1,
                Collectors.mapping(
                    Student::getName,
                    Collectors.toList()
                )
            )
        );

        collect1.get(true).forEach(System.out::println);

    }

    static class Student{
        private String name;
        private int grade;
        private int score;

        public Student(String name, int grade,int score) {
            this.name = name;
            this.grade = grade;
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public int getGrade() {
            return grade;
        }

        public String getName() {
            return name;
        }
    }

}
