package interfacemethod.basic;

public interface InterfaceMethodExample {

    String getName();


    default String getDescription() {
        return "This is a method example";
    }

}
