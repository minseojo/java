package org.example.real_world_software_development.chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// 모든 거래 내역 합 계산하기
public class BankStatementAnalyzerSimple {
    private static final String RESOURCES = "real_world_software_development/resources/";
    private static final String FILE_NAME = "bank-data-simple.csv";
    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + FILE_NAME);
        final List<String> lines = Files.readAllLines(path);
        double total = 0;
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);
    }
}
