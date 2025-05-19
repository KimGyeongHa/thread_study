package lambda.question;


@FunctionalInterface
interface Capturing{
    int add(int b);
}


public class LambdaCapturing {

    // 변수 람다 내에서 사용 시 불변이여야함.
    static int c = 10;

    public static void main(String[] args) {
        int a = 10;

        Capturing capturing = (b) -> ++c * b;

        System.out.println(capturing.add(10));
        System.out.println(c);

    }


    public int add(int b){
        int c = 10;
        Capturing capturing = (a) -> a * b + c;
        return capturing.add(10);
    }


}




