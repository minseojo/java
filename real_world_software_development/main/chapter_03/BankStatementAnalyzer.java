package org.example.real_world_software_development.main.chapter_03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "real_world_software_development/main/resources/";

    public void analyze(final String fileName,
                        final BankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        // 입력 파일 파싱 후, 모든 트랜잭션 초기화
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        // 프로세서에 모든 트랜잭션 초기화
        final BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);

        // 프로세서로 모든 트랜잭션 중에 5월인 트랜잭션 찾기.
        List<BankTransaction> TransactionsInMonth = processor.findTransactionsInMonth(Month.MAY);
        // 프로세서로 해당하는 트랜잭션을 찾은 후, 가격 합계 구하기.
        double total = calculateTotal(TransactionsInMonth);
        System.out.println(total);

        // 프로세서로 모든 트랜잭션 중에 가격이 1000원 이상인 트랜잭션 찾기.
        List<BankTransaction> TransactionsGreaterThan1000= processor.findTransactionsGreaterThanEqual(1000);
        // 프로세서로 해당하는 트랜잭션을 찾은 후, 가격 합계 구하기.
        total = calculateTotal(TransactionsGreaterThan1000);
        System.out.println(total);

        /* 참고
            책과 다르게 내 멋대로 수정한 코드로, Processor.java 의 역할이 처음과 달라졌다.
            chapter_02 에서는 프로세서의 기능은 합계를 구하는 기능이었다.
            코드를 변경후 chapter_03에서 프로세서의 기능은 모든 트랜잭션중에 사용자가 원하는 트랜잭션을 찾는 기능을 한다.
         */
    }

    private double calculateTotal(List<BankTransaction> bankTransactions) {
        return bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }
}


/*

        double totalAmount = bankTransactions.stream()
                .filter(bt -> bt.getAmount() >= 1000)
                .mapToDouble(BankTransaction::getAmount)
                .sum();
        System.out.println("Total amount for transactions with amount >= 1000: " + totalAmount);

        double totalAmountForJominseo  = bankTransactions.stream()
                .filter(bt -> bt.getDescription().equals("Jominseo"))
                .mapToDouble(BankTransaction::getAmount)
                .sum();
        System.out.println("Total amount for transactions with description 'Jominseo': " + totalAmountForJominseo);
* */