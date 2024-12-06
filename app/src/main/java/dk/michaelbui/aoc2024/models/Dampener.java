package dk.michaelbui.aoc2024.models;

import java.util.ArrayList;
import java.util.List;

public class Dampener {
    public Report consume(List<Integer> levels, int consumeIdx) {
        List<Integer> dampenedLevels = new ArrayList<>();
        int restorePoint = consumeIdx == 0 ? 1 : consumeIdx - 1;
        int continuePoint = consumeIdx == 0 ? 2 : consumeIdx + 1;
        // We know every point up until the consume point has been safe.
        // Remove the level that makes it unsafe and continue.
        dampenedLevels.add(levels.get(restorePoint));
        for (int i = continuePoint; i < levels.size(); i++) {
            dampenedLevels.add(levels.get(i));
        }
        return new Report(dampenedLevels);
    }
}
