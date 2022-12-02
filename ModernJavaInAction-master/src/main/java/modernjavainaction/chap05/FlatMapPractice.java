package modernjavainaction.chap05;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapPractice {
    public static void main(String[] args) {
        String[][] namesArray = new String[][]{
                {"kim", "taeng"}, {"mad", "play"},
                {"Hwang", "Junho"}, {"starbucks", "coffee"},
                {"kim", "mad"}, {"taeng", "play"}};
        Stream<String[]> stream1 = Arrays.stream(namesArray);
        Stream<String> stream2 = Arrays.stream(namesArray).flatMap(Arrays::stream);
        // flat map으로 합친 다음 한문자씩 분리한 stream
//        Arrays.stream(namesArray).flatMap(Arrays::stream).map(i -> i.split("")).flatMap(Arrays::stream).forEach(System.out::println);
//        Arrays.stream(namesArray).map(i -> Arrays.stream(i));

    /*    Arrays.stream(namesArray).flatMap(i -> Arrays.stream(i)).forEach(System.out::println);
        System.out.println("--------------");
        Arrays.stream(namesArray).flatMap(i -> Arrays.stream(i)).distinct().forEach(System.out::println);*/

        // map과 flatmap의 차이
        // 1. flatmap
        Arrays.stream(namesArray).flatMap(Arrays::stream).filter(i -> i.equals("Hwang")).forEach(System.out::println);

        // 2. map
        Stream<String[]> streamMapBefore = Arrays.stream(namesArray);
        Stream<Stream<String>> streamMapAfter = Arrays.stream(namesArray).map(Arrays::stream); // string 배열을 stream으로 변환시킴
        Arrays.stream(namesArray).map(Arrays::stream).forEach(i -> i.filter(name -> name.equals("Hwang")).forEach(System.out::println));

        System.out.println("-----------flat map------------");
        // flatMap
        Arrays.stream(namesArray)
                .flatMap(inner -> Arrays.stream(inner))
                .forEach(System.out::println);
        System.out.println("----------------map------------------");
        // map
        Arrays.stream(namesArray)
                .map(inner -> Arrays.stream(inner))
                .forEach(names -> names.forEach(System.out::println));
    }
}
