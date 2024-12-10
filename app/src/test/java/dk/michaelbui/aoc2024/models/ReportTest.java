package dk.michaelbui.aoc2024.models;

import dk.michaelbui.aoc2024.models.report.Report;
import dk.michaelbui.aoc2024.models.report.ReportBuilder;
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

    @Test
    public void isSafeWithDampener_reportIsSafeWhenDampenerConsumed_returnsTrue(){
        // Arrange
        String input = "1 3 2 4 5";
        Report report = new ReportBuilder(input).withDampener().build();

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertTrue(isSafe);
    }

    @Test
    public void isSafeWithDampener_reportIsSafeWhenDampenerConsumed_returnsTrue2(){
        // Arrange
        String input = "8 6 4 4 1";
        Report report = new ReportBuilder(input).withDampener().build();

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertTrue(isSafe);
    }

    @Test
    public void isSafeWithDampener_reportIsSafe_returnsTrue2(){
        // Arrange
        String input = "1 3 6 7 9";
        Report report = new ReportBuilder(input).withDampener().build();

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertTrue(isSafe);
    }

    @Test
    public void isSafeWithDampener_reportIsSafeWhenDampenerConsumed_returnsTrue3(){
        // Arrange
        String input = "1 3 6 4 7";
        Report report = new ReportBuilder(input).withDampener().build();

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertTrue(isSafe);
    }

    @Test
    public void isSafeWithDampener_reportIsSafe_returnsTrue4(){
        // Arrange
        String input = "1 3 6 8 7";
        Report report = new ReportBuilder(input).withDampener().build();

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertTrue(isSafe);
    }

    @Test
    public void isSafeWithDampener_reportIsSafeWhenDampenerConsumed_returnsTrue5(){
        // Arrange
        String input = "1 10 9 8 7 6";
        Report report = new ReportBuilder(input).withDampener().build();

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertTrue(isSafe);
    }

    @Test
    public void isSafeWithDampener_reportIsSafeWhenDampenerConsumed_returnsTrue6(){
        // Arrange
        String input = "1 1 3 5 7 9";
        Report report = new ReportBuilder(input).withDampener().build();

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertTrue(isSafe);
    }

    @Test
    public void isSafeWithDampener_reportIsSafeWhenDampenerConsumed_returnsTrue7(){
        // Arrange
        String input = "1 2 3 5 7 7";
        Report report = new ReportBuilder(input).withDampener().build();

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertTrue(isSafe);
    }

    @Test
    public void isSafeWithDampener_reportIsSafeWhenDampenerConsumed_returnsTrue8(){
        // Arrange
        String input = "9 8 7 6 5 7";
        Report report = new ReportBuilder(input).withDampener().build();

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertTrue(isSafe);
    }

    @Test
    public void isSafeWithDampener_reportIsUnSafe_returnsFalse2(){
        // Arrange
        String input = "9 7 6 2 1";
        Report report = new ReportBuilder(input).withDampener().build();

        // Act
        boolean isSafe = report.isSafe();

        // Assert
        assertFalse(isSafe);
    }
}
