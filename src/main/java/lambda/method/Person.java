package lambda.method;

public class Person {

    private String name;

    public Person() {
        this("unKnown");
    }

    public Person(String name) {
        this.name = name;
    }

    public String introduceName(){
        return "My name is " + name;
    }

    public String getAge(Integer age) {
        return "My age is " + age;
    }

    public static String getName(String name) {
        return name;
    }

}
