package org.example.real_world_software_development.main.chapter_02;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

// 월 입출금 내역 합계 게산하기
public class BankStatementAnalyzerProblematic {

    private static final String RESOURCES = "real_world_software_development/resources/";
    private static final String FILE_NAME = "bank-data-simple.csv";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(final String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + FILE_NAME);
        final List<String> lines = Files.readAllLines(path);
        double total = 0;
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transactions is " + total);

        total = 0;
        for (final String line : lines) {

            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_FORMATTER);
            if (date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }

        }

        System.out.println("The total for all transactions in January is " + total);

    }
}
