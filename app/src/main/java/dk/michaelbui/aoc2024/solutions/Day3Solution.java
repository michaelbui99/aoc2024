package dk.michaelbui.aoc2024.solutions;

import dk.michaelbui.aoc2024.io.PuzzleInputReader;
import dk.michaelbui.aoc2024.models.instruction.InstructionParser;
import dk.michaelbui.aoc2024.models.instruction.MulInstruction;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3Solution implements Solution {
    private PuzzleInputReader inputReader = new PuzzleInputReader("input_day3.txt");

    @Override
    public void solvePuzzleOne() {
        List<String> input = inputReader.read();

        Pattern pattern = Pattern.compile("mul\\([0-9]+,[0-9]+\\)");
        Matcher matcher = pattern.matcher(String.join("", input));

        StringBuilder rawMulInstruction = new StringBuilder();

        while (matcher.find()) {
            rawMulInstruction.append(matcher.group());
        }

        InstructionParser parser = new InstructionParser(rawMulInstruction.toString());
        int res = parser.parse()
                .stream()
                .mapToInt(MulInstruction::evaluate)
                .sum();

        System.out.printf("Day 3 Puzzle 1 answer: %s%n", res);
    }

    @Override
    public void solvePuzzleTwo() {

    }
}
