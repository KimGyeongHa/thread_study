package lambda.basic;

public class Animal{

    public static void main(String[] args) {
        Act dog = new Act() {
            @Override
            public String bark() {
                return "wang wang2";
            }

        };

        new HelloAnimal(() -> "wang wang3");
    }
}


class HelloAnimal{

    public HelloAnimal(Act act) {
        System.out.println(act.bark());
    }

}


class Dog implements Act{
    @Override
    public String bark() {
        return "wang wang";
    }
}