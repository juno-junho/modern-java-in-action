package modernjavainaction.chap05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ActualPractice {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
        ActualPractice actualPractice = new ActualPractice();
        List<Transaction> transactions = actualPractice.transactions;

        // 2011년에 일어난 모든 트랜잭션을 찾아 오름차순으로 정리
        transactions.stream()
                .filter(i -> i.getYear() == 2011)
                .map(i-> i.getTrader().getName())
                .sorted().forEach(System.out::println);
        // actual
        List<Transaction> result1 = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        
        // 거래자가 근무하는 모든 도시를 중복없이 나열 하시오
        // 내 답과 정답이 일치
        List<String> result2 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        //케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오
        /*List<Transaction> expected3 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());*/

//        System.out.println(expected3);

        List<Trader> result3 = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(result3);
//        System.out.println(expected3.equals(result3));


    }
}
