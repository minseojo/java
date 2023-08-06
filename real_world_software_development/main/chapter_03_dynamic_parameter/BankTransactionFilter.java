package org.example.real_world_software_development.main.chapter_03_dynamic_parameter;

import java.util.List;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
