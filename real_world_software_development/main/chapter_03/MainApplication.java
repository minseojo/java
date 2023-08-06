package org.example.real_world_software_development.main.chapter_03;


public class MainApplication {

    public static void main(final String[] args) throws Exception {

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze("bank-data-simple.csv", bankStatementParser);

    }
}