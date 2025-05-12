package lambda.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface LambdaFilter{
    void filter(List<Integer> list, MyProcedure procedure);
}

public class LambdaQuestion3 {

    public static void main(String[] args) {
        LambdaFilter customFilter = (List<Integer> myList, MyProcedure procedure) ->{
            procedure.getEvenList(myList);
        };

        List<Integer> myList = new ArrayList<>(Arrays.asList(-2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        customFilter.filter(myList, new MyProcedure());
    }
}

class MyProcedure{

    public void getNegative(List<Integer> list){
        for(int i = 0 ; i < list.size() ; i++){
            if (list.get(i) >= 0) {
                list.remove(i--);
            }
        }
        System.out.println(list.toString());
    }

    public void getEvenList(List<Integer> list){
        for (int i = 1 ; i < list.size() ; i++){
            if (Math.abs(list.get(i)) % 2 == 1) list.remove(i--);
        }
        System.out.println(list.toString());
    }

}
