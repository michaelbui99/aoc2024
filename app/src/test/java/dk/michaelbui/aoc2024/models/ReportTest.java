package dk.michaelbui.aoc2024.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReportTest {

    @Test
    public void isSafe_reportIsSafe_returnsTrue(){
        // Arrange
        String input = "7 6 4 2 1";
        Report report = new Report(input);

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertTrue(isSafe);
    }

    @Test
    public void isSafe_reportIsUnsafe_returnsFalse1(){
        // Arrange
        String input = "1 2 7 8 9";
        Report report = new Report(input);

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertFalse(isSafe);
    }

    @Test
    public void isSafeWithDampener_reportIsSafe_returnsTrue(){
        // Arrange
        String input = "7 6 4 2 1";
        Report report = new ReportBuilder(input).withDampener().build();

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertTrue(isSafe);
    }

    @Test
    public void isSafeWithDampener_reportIsUnsafe_returnsFalse(){
        // Arrange
        String input = "1 2 7 8 9";
        Report report = new ReportBuilder(input).withDampener().build();

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertFalse(isSafe);
    }
}
