package lambda.question;

@FunctionalInterface
interface LambdaMap{
    void map(String str, Question4Procedure  procedure);
}

public class LambdaQuestion4 {
    public static void main(String[] args) {

        LambdaMap lambdaMap1 = (String str, Question4Procedure procedure) -> {
            char[] charArray = str.toCharArray();
            StringBuffer br = new StringBuffer();
            for (char c : charArray) {
                br.append(procedure.replaceStr(c));
            }
            System.out.println(br.toString());
        };

        lambdaMap1.map("hello", new Question4Procedure());


        LambdaMap lambdaMap2 = (String str, Question4Procedure procedure) -> {
            System.out.println(procedure.decorator(str));
        };

        lambdaMap2.map("hello", new Question4Procedure());

    }
}

class Question4Procedure{
    public char replaceStr(char c){
        return (char)(c - 32);
    }


    public String decorator(String str){
        return "***" + str + "***";
    }

}