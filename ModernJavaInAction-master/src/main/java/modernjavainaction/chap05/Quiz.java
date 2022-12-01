package modernjavainaction.chap05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Quiz {
    public static void main(String[] args) {
        // Q1
        List<Integer> num = List.of(1, 2, 3, 4, 5);
        List<Integer> squaredNum = num.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(squaredNum);

        // Q2
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(3, 4);
        List<int[]> result = list1.stream().flatMap(i -> list2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());

        // Q3
//        List<int[]> finalResult = result.stream().filter(i -> Arrays.stream(i).sum() % 3 == 0).collect(Collectors.toList());
//        System.out.println(finalResult);

        List<int[]> finalResult = list1.stream()
                .flatMap(i -> list2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        list1.stream().map(i -> list2.stream().filter(j -> (i + j) % 3 == 0))
                .flatMap(i -> list2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
    }
}
