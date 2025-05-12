package lambda.basic;

public class lambda {


    public static void get1(){
        System.out.println("12321");
        new Get3();
    }

    public static void get2(){
        System.out.println("12321");

    }


    public static void main(String[] args) {
        get1();
    }


    static class Get3{
        public Get3(){
            for (int i = 0; i < 3; i++){
                System.out.println(i);
            }
        }
    }

}
