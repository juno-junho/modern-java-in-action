package modernjavainaction.chap02;

import modernjavainaction.chap02.FilteringApples.Apple;

import java.util.Arrays;
import java.util.List;

class Quiz {

    public interface AppleFormater {
        String accept(Apple apple);
    }

    static class AppleFancyFormatter implements AppleFormater {
        @Override
        public String accept(Apple apple) {
            String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
            return "A " + characteristic + " " + apple.getColor() + " apple";
        }
    }

    static class AppleSimpleFormatter implements AppleFormater {
        @Override
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }


    public static void prettyPrintApple(List<Apple> inventory, AppleFormater appleFormater) {
        for (Apple apple : inventory) {
            String output = appleFormater.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, FilteringApples.Color.GREEN),
                new Apple(155, FilteringApples.Color.GREEN),
                new Apple(120, FilteringApples.Color.RED));

        prettyPrintApple(inventory, new AppleFancyFormatter());



    }
}