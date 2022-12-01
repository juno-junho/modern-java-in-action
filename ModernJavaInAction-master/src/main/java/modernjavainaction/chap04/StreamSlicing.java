package modernjavainaction.chap04;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamSlicing {


    public static final List<Dish> menu = Arrays.asList(
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER)
    );

    public static void main(String[] args) {
        // Java 9 부터 등장한 takewhile과 dropwhile은 서로 정 반대 기능을 한다.
        // 하지만 둘다 정렬되 있어야 한다.

        // takewhile
        List<Dish> takewhileTest = menu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(takewhileTest);
        // dropwhile
        List<Dish> dropwhileTest = menu.stream().dropWhile(dish -> dish.getCalories() < 320)
                .collect(Collectors.toList());
        System.out.println(dropwhileTest);

        // collect
        Map<Dish.Type, List<Dish>> dishesByType =
                menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType);

        List<Dish> fishDishes = dishesByType.get(Dish.Type.FISH);
        System.out.println(fishDishes);
    }

}
