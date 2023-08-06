package org.example.real_world_software_development.main.chapter_03_dynamic_parameter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "real_world_software_development/main/resources/";

    public void analyze(final String fileName,
                        final BankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);

        List<BankTransaction> transactionsInMonth = processor.findTransactions(
                transaction -> transaction.getDate().getMonth() == Month.MAY
        );
        double totalInMay = calculateTotal(transactionsInMonth);
        System.out.println("Total transactions in May: " + totalInMay);

        List<BankTransaction> transactionsGreaterThan1000 = processor.findTransactions(
                transaction -> transaction.getAmount() >= 1000
        );
        double totalGreaterThan1000 = calculateTotal(transactionsGreaterThan1000);
        System.out.println("Total transactions greater than 1000: " + totalGreaterThan1000);

    }

    private double calculateTotal(List<BankTransaction> bankTransactions) {
        return bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }
}