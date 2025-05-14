package lambda.generic;


import java.util.function.*;

@FunctionalInterface
interface GenericLambda<T,R>{
    R apply(T t);
}

public class GenericTypeToLambda {

    public static void main(String[] args) {
/*
        GenericLambda<String,String> lambda1 = str -> str.toUpperCase();
        System.out.println(lambda1.apply("hello"));
*/
        Function<String, String> lambda2 = str -> str.toUpperCase();
        System.out.println(lambda2.apply("hello"));

        Function<String,String> str3 =  str1 -> "***" + str1 + "***";

        Function<String, String> compose = lambda2.compose(str3);
        System.out.println(compose.apply("hello"));

        Function<String,String> copy = compose;
        System.out.println(copy.apply("copy"));

        // 타입과 같은 반환 값을 받을떄
        UnaryOperator<String> operator = str -> str +"***";
        System.out.println(operator.apply("hello"));

        // 두개 이상의 매개변수가 존재하며, 같은 반환 값을 받을떄
        BinaryOperator<Integer> binaryOperator = (a,b) -> a+b;
        System.out.println(binaryOperator.apply(1,2));

        // consumer(입력값이 있고 반환값이 없음), runnable(입력 반환 둘다 없음), supplier(입력 값이 없고 반환값이있음)
        Consumer<String> consumer = System.out::println;
        consumer.accept("hello");

        // boolean type 반환
        Predicate<String> predicate = str -> str.length() > 5;
        System.out.println(predicate.test("hello"));

        // Long, Integer, String 이 존재
        IntFunction<Integer> intFunction = val -> val * 10;
        System.out.println(intFunction.apply(10));

        ToIntFunction<String> toIntFunction = val -> val.length();
        System.out.println(toIntFunction.applyAsInt("ebadf"));

        // bi는 두개 이상의 값을 사용할 떄
        ToIntBiFunction<Integer, Integer> toIntBiFunction = (a,b) -> a+b;
        System.out.println(toIntBiFunction.applyAsInt(1,2));





    }

}
