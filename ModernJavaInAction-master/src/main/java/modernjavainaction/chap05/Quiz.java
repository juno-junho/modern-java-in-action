package modernjavainaction.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Quiz {
    public static void main(String[] args) {
        // Q1
        List<Integer> num = List.of(1, 2, 3, 4, 5);
        List<Integer> squaredNum = num.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(squaredNum);

        // Q2
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(3, 4);
        // 차이 알기. map을 쓰면 하나의 list1 값 마다 Stream<int[]>를 반환해서 전체적으로는 Stream<Stream<int[]>> 가 된다.
        // 이를 flatMap을 통해서 Stream<int[]>로 변경 가능하다.
        Stream<Stream<int[]>> usingMap = list1.stream()
                .map(integer -> list2.stream().map(list2Integer -> new int[]{integer, list2Integer}));
        list1.stream()
                .flatMap(integer -> list2.stream().map(list2Integer -> new int[]{integer, list2Integer}))
                .collect(Collectors.toList());

        // Q3
        List<int[]> result3 = list1.stream()
                .flatMap(i -> list2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());


//        List<int[]> result = list1.stream().flatMap(i -> list2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());

        // Q3
//        List<int[]> finalResult = result.stream().filter(i -> Arrays.stream(i).sum() % 3 == 0).collect(Collectors.toList());
//        System.out.println(finalResult);

        List<int[]> finalResult = list1.stream()
                .flatMap(i -> list2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
//
//        list1.stream().map(i -> list2.stream().filter(j -> (i + j) % 3 == 0))
//                .flatMap(i -> list2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
    }
}
