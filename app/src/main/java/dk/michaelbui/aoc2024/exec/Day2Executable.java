package dk.michaelbui.aoc2024.exec;

import dk.michaelbui.aoc2024.io.PuzzleInputReader;
import dk.michaelbui.aoc2024.models.Report;
import dk.michaelbui.aoc2024.models.ReportBuilder;

import java.util.ArrayList;
import java.util.List;

public class Day2Executable implements DayExecutable {
    private PuzzleInputReader inputReader = new PuzzleInputReader("input_day2.txt");
    private List<String> inputs = new ArrayList<>();

    public Day2Executable() {
        inputs = inputReader.read();
    }


    @Override
    public void execPuzzleOne() {
        // O(n)
        long answer = inputs.stream()
                .map(Report::new)
                .filter(Report::isSafe)
                .count();

        System.out.printf("Day 2 Puzzle 1 answer: %s", answer);
    }

    @Override
    public void execPuzzleTwo() {
        // O(n)
        long answer = inputs.stream()
                .map(input -> new ReportBuilder(input).withDampener().build())
                .filter(Report::isSafe)
                .count();

        System.out.printf("Day 2 Puzzle 2 answer: %s", answer);
    }
}
