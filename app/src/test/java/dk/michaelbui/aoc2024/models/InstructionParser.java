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
}
