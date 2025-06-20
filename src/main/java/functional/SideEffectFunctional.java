package functional;

import java.util.ArrayList;
import java.util.List;

// 부수효과 최소화
public class SideEffectFunctional {

    public static void main(String[] args) {
        // 기존 객체에 영향이 가지 않게 값을 수정
        List<String> a = new ArrayList<>(List.of("a", "b", "c"));

        List<String> b = changeList1(a);
        System.out.println(a);
        System.out.println(b);

        List<String> c = new ArrayList<>(List.of("a", "b", "c"));

        List<String> d = changeList2(c);

        System.out.println(c);
        System.out.println(d);


    }

    public static List<String> changeList1(List<String> list1) {
        for (int i = 0; i < list1.size(); i++) {
            list1.set(i, list1.get(i) + "_sideEffect");
        }
        return list1;
    }

    public static List<String> changeList2(List<String> list2) {
        List<String> result = new ArrayList<>();
        for (String a : list2) {
            result.add(a + "ccc");
        }
        return result;
    }


}
