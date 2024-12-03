package dk.michaelbui.aoc2024.exec;

import dk.michaelbui.aoc2024.io.PuzzleInputReader;

import java.util.*;

public class Day1Executable implements DayExecutable {

    private List<String> input;
    private PuzzleInputReader inputReader = new PuzzleInputReader("input_day1.txt");

    public Day1Executable() {
        this.input = inputReader.read();
    }

    @Override
    public void execPuzzleOne() {
        // O(n)
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
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

        System.out.printf("Puzzle 1 answer: %s%n", answer);
    }

    @Override
    public void execPuzzleTwo() {
        // O(n)
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
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

        // O(n)
        Map<Integer, Integer> occuranceMap = new HashMap<>();
        for (Integer num : right) {
            if (!occuranceMap.containsKey(num)) {
                occuranceMap.put(num, 1);
                continue;
            }

            occuranceMap.put(num, occuranceMap.get(num) + 1);
        }

        // O(n^2) worst case with O(n) Hash Table lookups, O(n) average with O(1) Hash Table lookups.
        int startSimilarity = 0;
        int answer = left.stream()
                .reduce(startSimilarity, (acc, l) -> acc + (l * occuranceMap.getOrDefault(l, 0)));

        System.out.printf("Puzzle 2 answer: %s%n", answer);
    }
}
