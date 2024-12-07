package dk.michaelbui.aoc2024.models;

import java.util.ArrayList;
import java.util.List;

public class Dampener {
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
