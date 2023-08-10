package org.example.real_world_software_development.test.chapter2;

import org.example.real_world_software_development.main.chapter_02.BankStatementCSVParser;
import org.example.real_world_software_development.main.chapter_02.BankStatementParser;
import org.example.real_world_software_development.main.chapter_02.BankTransaction;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

public class BankTransactionCSVParserTest {

    private BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        String line = "05-08-2023,-50,Jominseo";

        BankTransaction result = statementParser.parseFrom(line);

        BankTransaction expected = new BankTransaction(LocalDate.of(2023, Month.AUGUST, 05), -50, "Jominseo");
        assertEquals(expected.getDate(), result.getDate());
        assertEquals(expected.getAmount(), result.getAmount(), 0.0d);
        assertEquals(expected.getDescription(), result.getDescription());
    }

}