package functional;

import java.util.function.Function;

// 순수함수
public class PureFunction {


    public static void main(String[] args) {
        // 같은 인자를 넣어도 같은 값을 반환.
        Function<Integer, ?> f = x -> x * 10;
        System.out.println(f.apply(10));
        System.out.println(f.apply(10));


    }

}
