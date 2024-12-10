package dk.michaelbui.aoc2024.models.report;

import java.util.ArrayList;
import java.util.List;

public class Dampener {
    public boolean reportIsSafe(Report report) {
        List<Boolean> isSafeEvaluations = new ArrayList<>();
        for (int i = 0; i < report.getLevels().size(); i++) {
            isSafeEvaluations.add(consume(report.getLevels(), i).isSafe());
        }

        return isSafeEvaluations.stream()
                .anyMatch(res -> res);
    }

    public Report consume(List<Integer> levels, int consumeIdx) {
        List<Integer> dampenedLevels = new ArrayList<>();
        for (int i = 0; i < levels.size(); i++) {
            if (i == consumeIdx) {
                continue;
            }

            dampenedLevels.add(levels.get(i));
        }
        return new Report(dampenedLevels);
    }
}
