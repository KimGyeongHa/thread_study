package lambda.question;


@FunctionalInterface
interface ConvertStr{
    String convert(String str, Question6Lambda question6Lambda);
}

@FunctionalInterface
interface Decorator {
    String decorate(String str, Question6Lambda question6Lambda);
}

@FunctionalInterface
interface Compose{
    String compose(String str);
}

public class LambdaQuestion6 {

    public static Compose convert(ConvertStr convertStr, Decorator decorator){
        return str -> decorator.decorate(convertStr.convert(str, new Question6Lambda()), new Question6Lambda());
    }

    public static void main(String[] args) {
        ConvertStr convertStr = (String target, Question6Lambda question6Lambda) -> question6Lambda.convertStr(target);
        Decorator decorator = (String target, Question6Lambda  question6Lambda) -> question6Lambda.decorator(target);

        System.out.println(convert(convertStr, decorator).compose("kimgyeongha"));
    }

}


class Question6Lambda{
    public String convertStr(String str){
        return str.toUpperCase();
    }

    public String decorator(String str){
        return "***" + str + "***";
    }
}