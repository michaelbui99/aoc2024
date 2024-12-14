package dk.michaelbui.aoc2024.models;

import dk.michaelbui.aoc2024.models.instruction.MulInstruction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InstructionParser {

    @Test
    public void parse_validMulInstruction_returnsMulInstruction() {
        // Arrange
        String source = "mul(2,2)";
        dk.michaelbui.aoc2024.models.instruction.InstructionParser parser = new dk.michaelbui.aoc2024.models.instruction.InstructionParser(source);

        // Act
        List<MulInstruction> instructions = parser.parse();

        // Assert
        assertEquals(1, instructions.size());
        assertEquals(4, instructions.get(0).evaluate());
    }

    @Test
    public void parse_validMulInstructions_returnsListOfMulInstructions() {
        // Arrange
        String source = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))";
        dk.michaelbui.aoc2024.models.instruction.InstructionParser parser = new dk.michaelbui.aoc2024.models.instruction.InstructionParser(source);

        // Act
        List<MulInstruction> instructions = parser.parse();

        // Assert
        assertEquals(4, instructions.size());
        assertEquals("mul(2,4)", instructions.get(0).toString());
        assertEquals("mul(5,5)", instructions.get(1).toString());
        assertEquals("mul(11,8)", instructions.get(2).toString());
        assertEquals("mul(8,5)", instructions.get(3).toString());
        assertEquals(161, instructions.stream().mapToInt(MulInstruction::evaluate).sum());
    }

    @Test
    public void parse_validMulInstructions_returnsListOfMulInstructions2() {
        // Arrange
        String source = "where())what()@)select()why()?mul(371,776)/%how()'~+:how()mul(977,266)@$@mul(749,170)how()";
        dk.michaelbui.aoc2024.models.instruction.InstructionParser parser = new dk.michaelbui.aoc2024.models.instruction.InstructionParser(source);

        // Act
        List<MulInstruction> instructions = parser.parse();

        // Assert
        assertEquals(3, instructions.size());
    }

    @Test
    public void parse_invalidMulInstruction_returnsEmptyList() {
        // Arrange
        String source = "mul ( 2 , 4 )";
        dk.michaelbui.aoc2024.models.instruction.InstructionParser parser = new dk.michaelbui.aoc2024.models.instruction.InstructionParser(source);

        // Act
        List<MulInstruction> instructions = parser.parse();

        // Assert
        assertEquals(0, instructions.size());
    }
}
