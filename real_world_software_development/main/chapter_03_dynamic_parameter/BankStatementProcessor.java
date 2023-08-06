package org.example.real_world_software_development.main.chapter_03_dynamic_parameter;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public List<BankTransaction> findTransactions(BankTransactionFilter filter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bt : bankTransactions) {
            if (filter.test(bt)) {
                result.add(bt);
            }
        }
        return result;
    }
}
