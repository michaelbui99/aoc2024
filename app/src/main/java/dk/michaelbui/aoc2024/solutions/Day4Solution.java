package dk.michaelbui.aoc2024.solutions;

import dk.michaelbui.aoc2024.io.PuzzleInputReader;

import java.util.List;

public class Day4Solution implements Solution {
    private PuzzleInputReader inputReader = new PuzzleInputReader("input_day4_example.txt");
    private int maxRowIdx;
    private int minRowIdx = 0;
    private int maxColIdx;
    private int minColIdx = 0;
    private List<String> input;
    private final String XMAS = "xmas";
    private final String XMAS_CANDIDATE_FORMAT = "x%s%s%s";

    public Day4Solution() {
        //  j->
        // i ####
        // | ####
        // v ####
        input = inputReader.read();
        maxRowIdx = input.size() - 1;
        maxColIdx = input.get(0).length() - 1;
    }

    @Override
    public void solvePuzzleOne() {
        List<List<Character>> input = inputReader.read()
                .stream()
                .map(s -> s.toLowerCase())
                .map(i -> i.chars()
                        .mapToObj(c -> (char) c)
                        .toList()
                )
                .toList();

        int xmasCount = 0;
        for (int i = 0; i <= maxRowIdx; i++) {
            for (int j = 0; j <= maxColIdx; j++) {
                char c = input.get(i).get(j);
                if (c != 'x') {
                    continue;
                }

                if (checkLeftToRight(i, j, input) || checkRightToLeft(i, j, input)) {
                    xmasCount++;
                }
                if (checkRightDiagonalUp(i, j, input) || checkRightDiagonalDown(i, j, input)) {
                    xmasCount++;
                }
                if (checkLeftDiagonalUp(i, j, input) || checkLeftDiagonalDown(i, j, input)) {
                    xmasCount++;
                }
                if (checkUp(i, j, input) || checkDown(i, j, input)) {
                    xmasCount++;
                }
            }
        }
        System.out.printf("Day 4 Puzzle 1 Answer: %s%n", xmasCount);
    }

    @Override
    public void solvePuzzleTwo() {

    }

    private boolean isOutOfBounds(int i, int j) {
        return i > maxRowIdx || j > maxColIdx || i < minRowIdx || j < minColIdx;
    }

    private boolean checkLeftToRight(int i, int j, List<List<Character>> input) {
        List<Character> row = input.get(i);
        if (row.get(j) != 'x') {
            return false;
        }
        if (isOutOfBounds(i, j + 1) || isOutOfBounds(i, j + 2) || isOutOfBounds(i, j + 3)) {
            return false;
        }

        String xmasCandidate = String.format(XMAS_CANDIDATE_FORMAT, row.get(j + 1), row.get(j + 2), row.get(j + 3));
        return xmasCandidate.equals(XMAS);
    }

    private boolean checkRightToLeft(int i, int j, List<List<Character>> input) {
        List<Character> row = input.get(i);
        if (row.get(j) != 'x') {
            return false;
        }
        if (isOutOfBounds(i, j - 1) || isOutOfBounds(i, j - 2) || isOutOfBounds(i, j - 3)) {
            return false;
        }

        String xmasCandidate = String.format(XMAS_CANDIDATE_FORMAT, row.get(j - 1), row.get(j - 2), row.get(j - 3));
        return xmasCandidate.equals(XMAS);
    }

    private boolean checkRightDiagonalDown(int i, int j, List<List<Character>> input) {
        if (input.get(i).get(j) != 'X') {
            return false;
        }

        if (isOutOfBounds(i + 1, j + 1) || isOutOfBounds(i + 2, j + 2) || isOutOfBounds(i + 3, j + 3)) {
            return false;
        }

        String xmasCandidate = String.format(XMAS_CANDIDATE_FORMAT, input.get(i + 1).get(j + 1), input.get(i + 2).get(j + 2), input.get(i + 3).get(j + 3));
        return xmasCandidate.equals(XMAS);
    }

    private boolean checkRightDiagonalUp(int i, int j, List<List<Character>> input) {
        if (input.get(i).get(j) != 'X') {
            return false;
        }

        if (isOutOfBounds(i - 1, j + 1) || isOutOfBounds(i - 2, j + 2) || isOutOfBounds(i - 3, j + 3)) {
            return false;
        }

        String xmasCandidate = String.format(XMAS_CANDIDATE_FORMAT, input.get(i + 1).get(j + 1), input.get(i + 2).get(j + 2), input.get(i + 3).get(j + 3));
        return xmasCandidate.equals(XMAS);
    }

    private boolean checkLeftDiagonalDown(int i, int j, List<List<Character>> input) {
        if (input.get(i).get(j) != 'X') {
            return false;
        }

        if (isOutOfBounds(i + 1, j - 1) || isOutOfBounds(i + 2, j - 2) || isOutOfBounds(i + 3, j - 3)) {
            return false;
        }

        String xmasCandidate = String.format(XMAS_CANDIDATE_FORMAT, input.get(i + 1).get(j - 1), input.get(i + 2).get(j - 2), input.get(i + 3).get(j - 3));
        return xmasCandidate.equals(XMAS);
    }

    private boolean checkLeftDiagonalUp(int i, int j, List<List<Character>> input) {
        if (input.get(i).get(j) != 'X') {
            return false;
        }

        if (isOutOfBounds(i - 1, j - 1) || isOutOfBounds(i - 2, j - 2) || isOutOfBounds(i - 3, j - 3)) {
            return false;
        }

        String xmasCandidate = String.format(XMAS_CANDIDATE_FORMAT, input.get(i - 1).get(j - 1), input.get(i - 2).get(j - 2), input.get(i - 3).get(j - 3));
        return xmasCandidate.equals(XMAS);
    }

    private boolean checkDown(int i, int j, List<List<Character>> input) {
        if (input.get(i).get(j) != 'X') {
            return false;
        }

        if (isOutOfBounds(i + 1, j) || isOutOfBounds(i + 2, j) || isOutOfBounds(i + 3, j)) {
            return false;
        }

        String xmasCandidate = String.format(XMAS_CANDIDATE_FORMAT, input.get(i + 1).get(j), input.get(i + 2).get(j), input.get(i + 3).get(j));
        return xmasCandidate.equals(XMAS);
    }

    private boolean checkUp(int i, int j, List<List<Character>> input) {
        if (input.get(i).get(j) != 'X') {
            return false;
        }

        if (isOutOfBounds(i - 1, j) || isOutOfBounds(i - 2, j) || isOutOfBounds(i - 3, j)) {
            return false;
        }

        String xmasCandidate = String.format(XMAS_CANDIDATE_FORMAT, input.get(i - 1).get(j), input.get(i - 2).get(j), input.get(i - 3).get(j));
        return xmasCandidate.equals(XMAS);
    }
}
