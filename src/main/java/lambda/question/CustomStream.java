package lambda.question;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CustomStream<T>  {

    private List<T> list = new ArrayList<>();

    private CustomStream(List<T> list) {
        this.list = list;
    }

    public static <T> CustomStream<T> of(List<T> list){
        return new CustomStream<>(list);
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

    public void forEach(Consumer<T> consumer){
        for (T t : list){
            consumer.accept(t);
        }
    }

    public List<T> getList(){
        return list;
    }

}
