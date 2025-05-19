package lambda.method;

import lambda.question.CustomStream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MethodRef2 {

    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("kimgyeonha1"),
                new Person("kimgyeongha2"),
                new Person("kimgyeonha3")
        );

        List<String> strings1 = MethodRef2.mapToString(persons, new Function<Person, String>() {
            @Override
            public String apply(Person person) {
                return person.introduceName();
            }
        });

        List<String> strings2 = MethodRef2.mapToString(persons, (Person person) -> person.introduceName());

        List<String> strings3 = MethodRef2.mapToString(persons, person -> person.introduceName());

        List<String> string4 = MethodRef2.mapToString(persons, Person::introduceName);

        BiFunction<Person, Integer, String> function1 = (person, age) -> person.getAge(age);
        System.out.println(function1.apply(new Person("kimgyeonha1"), 20));

        BiFunction<Person, Integer, String> function2 = Person::getAge;
        System.out.println(function2.apply(new Person("kimgyeonha1"), 10));

        CustomStream.of(persons)
                .map(Person::introduceName)
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }

    static <T> List<String> mapToString(List<T> list, Function<T,String> function){
        List<String> resultList = new ArrayList<>();
        for (T t : list){
            resultList.add(function.apply(t));
        }
        return resultList;
    }

    /*static <T> List<String> mapToString(List<T> list, UnaryOperator<T> function){
        List<String> result = new ArrayList<>();

        return result;
    }*/

}
