package lambda.generic;


import java.util.function.Function;

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

    }

}
