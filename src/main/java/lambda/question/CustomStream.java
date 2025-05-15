package lambda.question;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CustomStream<T>  {

    private List<T> list = new ArrayList<>();

    public CustomStream(List<T> list) {
        this.list = list;
    }

    public static CustomStream of(){
        return new CustomStream<>(new ArrayList<>());
    }

    public CustomStream<T> filter(Predicate<T> predicate) {
        List<T> returnList = new ArrayList<>();
        for (T t : list){
            if (predicate.test(t)) returnList.add(t);
        }
        return new CustomStream<>(returnList);
    }

    public <R> CustomStream<R> map(Function<? super T, ? extends R> function) {
        List<R> returnList = new ArrayList<>();
        for (T t : list){
            returnList.add(function.apply(t));
        }
        return new CustomStream<>(returnList);
    }

    public List<T> getList(){
        return list;
    }
}
