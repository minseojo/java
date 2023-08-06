package org.example.real_world_software_development.main.chapter_03;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final double amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }

    public List<BankTransaction> findTransactionsInMonth(final Month month) {
        return findTransactions(bankTransaction -> bankTransaction.getDate().getMonth() == month);
    }

    public List<BankTransaction> findTransactionsForCategory(final String description) {
        return findTransactions(bankTransaction -> bankTransaction.getDescription().equals(description));
    }

    private List<BankTransaction> findTransactions(Predicate<BankTransaction> p) {
        final List<BankTransaction> result = new ArrayList<>();
        for(BankTransaction bt: bankTransactions) {
            if(p.test(bt)) {
                result.add(bt);
            }
        }
        return result;
    }
}
