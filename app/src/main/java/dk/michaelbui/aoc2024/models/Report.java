package dk.michaelbui.aoc2024.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Report {
    private List<Integer> levels = new ArrayList<>();
    private static final int MIN_SAFE_LEVEL_DIFFERENCE = 1;
    private static final int MAX_SAFE_LEVEL_DIFFERENCE = 3;
    private static final int INCREASING = +42;
    private static final int DECREASING = -42;
    private static final int NEUTRAL = 101;
    private int state = 0;
    private Dampener dampener;

    public Report(String levels, Dampener dampener) {
        this(levels);
        this.dampener = dampener;
    }

    public Report(String levels) {
        this(
                Arrays.stream(levels.split(" "))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .toList()
        );
    }

    public Report(List<Integer> levels) {
        this.levels = levels;
        initState();
    }

    public boolean isSafe() {
        if (state == NEUTRAL) {
            if (dampener == null) {
                return false;
            }
            if (!dampener.consume(levels, 0).isSafe()) {
                return dampener.consume(levels, 0).isSafe();
            } else {
                return true;
            }
        }

        for (int i = 0; i < levels.size(); i++) {
            if (i == levels.size() - 1) {
                break;
            }

            // Levels are either not all increasing or not all decreasing
            if (getLevelState(levels.get(i), levels.get(i + 1)) != state) {
                if (dampener == null) {
                    return false;
                }
                if (!dampener.consume(levels, i).isSafe()) {
                    return dampener.consume(levels, i + 1).isSafe();
                } else {
                    return true;
                }
            }

            if (!isSafeLevelChange(levels.get(i), levels.get(i + 1))) {
                if (dampener == null) {
                    return false;
                }

                if (!dampener.consume(levels, i).isSafe()) {
                    return dampener.consume(levels, i + 1).isSafe();
                } else {
                    return true;
                }
            }
        }

        return true;
    }

    private boolean isSafeLevelChange(int a, int b) {
        int absChange = Math.abs(b - a);
        return absChange >= MIN_SAFE_LEVEL_DIFFERENCE && absChange <= MAX_SAFE_LEVEL_DIFFERENCE;
    }

    private void initState() {
        if (levels.size() == 1) {
            state = NEUTRAL;
            return;
        }

        state = getLevelState(levels.get(0), levels.get(1));
    }

    private int getLevelState(int a, int b) {
        if (b - a > 0) {
            return INCREASING;
        }

        if (b - a < 0) {
            return DECREASING;
        }

        return NEUTRAL;
    }
}
