package lambda.generic;

import java.util.function.Function;

public class GenericType {


    public static void main(String[] args) {
        StringType<String> stringType = new StringType<>();
        stringType.setValue1("HELLO");
        System.out.println(stringType.getValue1());

        System.out.println(stringType.convert("HELLO"));

    }

}

class StringType<T>{
    private T value1;

    public void setValue1(T value) {
        this.value1 = value;
    }

    public T getValue1() {
        return value1;
    }

    public <U> U convert(U u){
        return u;
    }

}