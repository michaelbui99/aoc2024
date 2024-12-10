package dk.michaelbui.aoc2024.solutions;

import dk.michaelbui.aoc2024.io.PuzzleInputReader;
import dk.michaelbui.aoc2024.models.report.Report;
import dk.michaelbui.aoc2024.models.report.ReportBuilder;

import java.util.List;

public class Day2Solution implements Solution {
    private PuzzleInputReader inputReader = new PuzzleInputReader("input_day2.txt");

    public Day2Solution() {
    }


    @Override
    public void solvePuzzleOne() {
        List<String> inputs = inputReader.read();
        // O(n)
        long answer = inputs.stream()
                .map(Report::new)
                .filter(Report::isSafe)
                .count();

        System.out.printf("Day 2 Puzzle 1 answer: %s%n", answer);
    }

    @Override
    public void solvePuzzleTwo() {
        List<String> inputs = inputReader.read();
        // Kinda nasty brute force, O(n^2)
        long answer = inputs.stream()
                .map(input -> new ReportBuilder(input).withDampener().build())
                .filter(Report::isSafe)
                .count();

        System.out.printf("Day 2 Puzzle 2 answer: %s%n", answer);
    }
}
