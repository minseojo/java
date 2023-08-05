package org.example.real_world_software_development.chapter_02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

// 입출금 내역 목록처리
public class BankStatementAnalyzerSRP {

    private static final String RESOURCES = "real_world_software_development/resources/";
    private static final String FILE_NAME = "bank-data-simple.csv";

    public static void main(final String[] args) throws Exception {
        // 이런식으로 구현체에 의존하면 안됨. (CSV, JSON 등등의 파일이 추가 될 수 있으므로)
        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

        final Path path = Paths.get(RESOURCES + FILE_NAME);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));
    }

    private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        return bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        return bankTransactions.stream()
                .filter(bankStatement -> month.equals(bankStatement.getDate().getMonth()))
                .collect(Collectors.toList());
    }
}