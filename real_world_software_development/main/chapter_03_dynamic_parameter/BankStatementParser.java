package org.example.real_world_software_development.main.chapter_03_dynamic_parameter;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
