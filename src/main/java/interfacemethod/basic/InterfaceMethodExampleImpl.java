package interfacemethod.basic;

import java.util.List;
import java.util.jar.JarInputStream;

public class InterfaceMethodExampleImpl {


    public static void main(String[] args) {
        InterfaceMethodExample example1 = new InterfaceMethodExample1("김경하1");
        InterfaceMethodExample example2 = new InterfaceMethodExample2("김경하2");

        System.out.println(example1.getDescription());
        System.out.println(example2.getDescription());

        List<Integer> integers = List.of(1, 2, 3, 4);
        integers.parallelStream().forEach(System.out::println);

    }


    static class InterfaceMethodExample1 implements InterfaceMethodExample {

        private String name;

        public InterfaceMethodExample1(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    static class InterfaceMethodExample2 implements InterfaceMethodExample {

        private String name;

        public InterfaceMethodExample2(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }


}
