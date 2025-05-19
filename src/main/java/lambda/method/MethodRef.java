package lambda.method;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRef {

    public static void main(String[] args) {
        // 정적 메서드 참조
        Supplier<Integer> add = MethodRef::add;
        System.out.println(add.get());

        // 생성자 참조
        Supplier<Person> person = Person::new;
        System.out.println(person.get());

        // 특정객체 인스턴스 메서드참조
        Person person2 = new Person("kimgyeonha2");
        Supplier<String> person2Introduce = person2::introduceName;
        System.out.println(person2Introduce.get());

        // 임의객체 인스턴스 메서드참조
        Person person4 = new Person("kimgyeonha4");
        Person person5 = new Person("kimgyeonha5");

        Function<Person, String> introduceFunction = Person::introduceName;
        System.out.println(introduceFunction.apply(person4));
        System.out.println(introduceFunction.apply(person5));



    }


    public static int add() {
        return 2 + 3;
    }


}
