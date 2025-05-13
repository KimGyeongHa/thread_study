package lambda.question;

import java.util.List;

@FunctionalInterface
interface LambdaReduce{
    int reduce(List<Integer> list, Question5LambdaReduce lambdaReduce);
}

public class LambdaQuestion5 {

    public static void main(String[] args) {
        LambdaReduce sum = (List<Integer> list, Question5LambdaReduce lambdaReduce) -> lambdaReduce.sum(list);

        LambdaReduce multiply = (List<Integer> list, Question5LambdaReduce lambdaReduce) -> lambdaReduce.multiply(list);

        System.out.println(
                sum.reduce(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), new Question5LambdaReduce())
        );

        System.out.println(
                multiply.reduce(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), new Question5LambdaReduce())
        );

    }
}

class Question5LambdaReduce{

    public int sum(List<Integer> list){
        int result = 0;
        for (Integer i : list){
            result += i;
        }
        return result;
    };

    public int multiply(List<Integer> list){
        int result = 1;
        for (Integer i : list){
            result *= i;
        }
        return result;
    }

}