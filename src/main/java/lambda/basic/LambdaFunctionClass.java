package lambda.basic;

public class LambdaFunctionClass {


    public static void main(String[] args) {
        LambdaFunction function1 = (a,b) -> a+b;
        LambdaFunction function2 = (a,b) -> a-b;

        GetFunction getFunction1 = new GetFunction(function1);
        GetFunction getFunction2 = new GetFunction(function2);

    }

    static class GetFunction{
        public GetFunction(LambdaFunction function) {
            System.out.println(function.get(1,2));
        }
    }


}
