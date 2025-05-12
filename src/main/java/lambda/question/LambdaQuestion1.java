package lambda.question;

interface GetGreet{
    String get();
}

public class LambdaQuestion1 {

    public static void main(String[] args) {
        new Hello(() -> "good morning");
        new Hello(() -> "good afternoon");
        new Hello(() -> "good evening");

    }

    static class Hello{

        public Hello(GetGreet getString) {
            System.out.println("===============시작=============");
            System.out.println(getString.get());
            System.out.println("===============끝=============");
        }
    }

}
