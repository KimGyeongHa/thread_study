package lambda.question;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class CustomMapper<T> {

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> resultList = new ArrayList<>();

        for (int i = 0 ; i < list.size() ; i++){
            if (predicate.test(list.get(i))) resultList.add(list.get(i));
        }

        return resultList;
    }

    public static <T,R> R map(T t, Function<T,R> function){
        return function.apply(t);
    }



}
