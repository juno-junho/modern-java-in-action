package modernjavainaction.chap05;

import modernjavainaction.chap04.Dish;

import java.util.List;

public class ReducingQuiz {
    public static void main(String[] args) {
        // map과 reduce를 이용해서 스트림의 요리 개수 구하기
        List<Dish> menu = Dish.menu;

        Integer result1 = menu.stream().map(i -> 1).reduce(0, (a, b) -> a + b);
        System.out.println(result1);
        // 다른방법 : count 최종연산 사용
        long result2 = menu.stream().count();
        System.out.println(result2);
    }
}
