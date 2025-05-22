package optional.basic;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();
        Optional<String> optional2 = Optional.of("abc");

        Optional<String> cba = optional.or(new Supplier<Optional<? extends String>>() {
            @Override
            public Optional<? extends String> get() {
                return Optional.of("cba");
            }
        });

        cba.ifPresent(s -> System.out.println(s.toUpperCase()));
        System.out.println(optional2.map(String::toUpperCase).orElse("DEFAULT"));

    }


}
