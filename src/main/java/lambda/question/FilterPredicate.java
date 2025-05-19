package lambda.question;


import java.util.ArrayList;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static lambda.question.CustomMapper.*;


public class FilterPredicate {

    public static void main(String[] args) {

        Predicate<Integer> oddPredicate = (i) -> i % 2 == 1;
        Predicate<Integer> evenPredicate = (i) -> i % 2 == 0;

        System.out.println(oddList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), oddPredicate).toString());
        System.out.println(evenList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), evenPredicate).toString());

        filter(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), i -> i % 2 == 1);
        filter(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), i -> i % 2 == 0);

        System.out.println(stringToInt(List.of("1", "12", "123")).toString());

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> result = new ArrayList<>();
        for (Integer i : integers){
            if (i % 2 == 0) result.add(i * 2);
        }

        List<Integer> filterMap = map(filter(integers, i -> i % 2 == 0), list ->{
            list.replaceAll(integer -> integer * 2);
            return list;
        });

        System.out.println(filterMap.toString());

       /* CustomStream<String> stream1 = new CustomStream<>(List.of("1", "12", "123"));
        CustomStream<Integer> stream2 = new CustomStream<>(List.of(1, 12, 123));

        List<String> list = stream1.filter(s -> s.length() > 1).map(s -> s + "***").getList();
        List<Integer> list1 = stream2.map(s -> String.valueOf(s)).map(s -> Integer.parseInt(s) * 3).getList();

        System.out.println(list.toString());
        System.out.println(list1.toString());*/

        List<String> strings = List.of("1", "12", "123");

        CustomStream.of(strings)
                .map(s -> s + "***")
                .filter(s -> s.length() > 5)
                .map(s -> s.substring(0,1))
                .forEach(System.out::println);

    }


    public static List<Integer> oddList(List<Integer> list, Predicate<Integer> predicate){
        List<Integer> resultList = new ArrayList<>();
        for (Integer i : list){
            if (predicate.test(i)) resultList.add(i);
        }
        return resultList;
    }

    public static List<Integer> evenList(List<Integer> list, Predicate<Integer> predicate){
        List<Integer> resultList = new ArrayList<>();
        for (Integer i : list){
            if (predicate.test(i)) resultList.add(i);
        }
        return resultList;
    };

    public static List<Integer> stringToInt(List<String> list){
        List<Integer> result = new ArrayList<>();
        for (String i : list){
            result.add(map(i, Integer::parseInt));
        }
        return result;
    }

    public static List<Integer> lengths(List<String> list){
        List<Integer> result = new ArrayList<>();
        for (String i : list){
            result.add(map(i, s-> s.length()));
        }
        return result;
    };


}
