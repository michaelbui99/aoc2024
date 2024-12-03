package dk.michaelbui.aoc2024.exec;

import dk.michaelbui.aoc2024.io.PuzzleInputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1Executable implements DayExecutable {

    @Override
    public void execPuzzleOne() {
        PuzzleInputReader inputReader = new PuzzleInputReader("input_day1.txt");
        List<String> input = inputReader.read();
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // O(n)
        for (String pair : input) {
            List<String> separatedPair = Arrays.stream(pair.split("  "))
                    .map(String::trim)
                    .toList();
            if (separatedPair.size() != 2) {
                throw new IllegalStateException("Unable to determine entry for left and right list.");
            }
            left.add(Integer.parseInt(separatedPair.get(0)));
            right.add(Integer.parseInt(separatedPair.get(1)));
        }

        // Assuming these are O(n*log(n)) sorts.
        List<Integer> leftSorted = left.stream().sorted().toList();
        List<Integer> rightSorted = right.stream().sorted().toList();

        if (leftSorted.size() != rightSorted.size()) {
            throw new IllegalStateException(String.format("Left and right are not matching up. Left size: %d, Right size: %d ", left.size(), right.size()));
        }

        // O(n)
        int[] distances = new int[leftSorted.size()];
        for (int i = 0; i < leftSorted.size(); i++) {
            int distance = Math.abs(leftSorted.get(i) - rightSorted.get(i));
            distances[i] = distance;
        }

        int answer = Arrays
                .stream(distances)
                .sum();

        System.out.printf("Answer: %s%n", answer);
    }

    @Override
    public void execPuzzleTwo() {

    }
}
