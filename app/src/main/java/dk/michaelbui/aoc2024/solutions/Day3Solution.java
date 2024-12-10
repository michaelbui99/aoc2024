package dk.michaelbui.aoc2024.solutions;

import dk.michaelbui.aoc2024.io.PuzzleInputReader;
import dk.michaelbui.aoc2024.models.instruction.InstructionParser;
import dk.michaelbui.aoc2024.models.instruction.MulInstruction;

import java.util.List;

public class Day3Solution implements Solution {
    private PuzzleInputReader inputReader = new PuzzleInputReader("input_day3.txt");

    @Override
    public void solvePuzzleOne() {
        List<String> input = inputReader.read();

        InstructionParser parser = new InstructionParser(input.get(0));

        int res = parser.parse()
                .stream()
                .map(MulInstruction::evaluate)
                .reduce(0, (total, next) -> total += next);

        System.out.printf("Day 3 Puzzle 1 answer: %s%n", res);
    }

    @Override
    public void solvePuzzleTwo() {

    }
}
