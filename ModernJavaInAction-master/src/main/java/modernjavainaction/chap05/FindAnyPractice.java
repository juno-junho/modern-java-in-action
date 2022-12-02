package modernjavainaction.chap05;

import modernjavainaction.chap04.Dish;

import java.util.Optional;

public class FindAnyPractice {

    public static void main(String[] args) {
        Optional<Dish> findFirst = Dish.menu.stream().filter(Dish::isVegetarian).findFirst();
        Optional<Dish> findAny = Dish.menu.stream().filter(Dish::isVegetarian).findAny();
        System.out.println(findAny.get().toString());
        Dish defaultDish = new Dish("default", false, 0, Dish.Type.OTHER);
        System.out.println(findFirst.orElse(defaultDish));

        Optional<Object> nullObject = Optional.ofNullable(new int[]{1,2,3,4,5});
        System.out.println(nullObject.isPresent());
    }
}
