package dk.michaelbui.aoc2024.solutions;

import dk.michaelbui.aoc2024.io.PuzzleInputReader;
import dk.michaelbui.aoc2024.models.instruction.*;

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
                .filter(MulInstruction.class::isInstance)
                .map(MulInstruction.class::cast)
                .mapToInt(MulInstruction::evaluate)
                .sum();

        System.out.printf("Day 3 Puzzle 1 answer: %s%n", res);
    }

    @Override
    public void solvePuzzleTwo() {
        List<String> input = inputReader.read();

        Pattern pattern = Pattern.compile("(mul\\([0-9]+,[0-9]+\\))|(do\\(\\))|(don't\\(\\))");
        Matcher matcher = pattern.matcher(String.join("", input));

        StringBuilder rawInstructions = new StringBuilder();

        while (matcher.find()) {
            rawInstructions.append(matcher.group());
        }

        InstructionParser parser = new InstructionParser(rawInstructions.toString());
        List<Instruction> instructions = parser.parse();
        boolean mulEnabled = true;

        int res = 0;
        for (Instruction instruction : instructions) {
            boolean finalMulEnabled = mulEnabled;
            switch (instruction) {
                case DoInstruction doInstruction -> mulEnabled = true;
                case DontInstruction dontInstruction -> mulEnabled = false;
                case MulInstruction mulInstruction when finalMulEnabled -> {
                    res += mulInstruction.evaluate();
                }
                default -> {
                }
            }
        }

        System.out.printf("Day 3 Puzzle 2 answer: %s%n", res);
    }
}
