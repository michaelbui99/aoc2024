package dk.michaelbui.aoc2024.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PuzzleInputReader {
    private final String inputFileName;

    public PuzzleInputReader(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public List<String> read() {
        try (
                InputStream is = getFileResourceInputStream(inputFileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is))
        ) {
            List<String> input = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }
            return input;
        } catch (IOException e) {
            throw new RuntimeException(String.format("Failed to read input: %s", e.getMessage()), e);
        }
    }

    private InputStream getFileResourceInputStream(String resourceFileName) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(inputFileName);
        if (inputStream == null) {
            throw new IllegalArgumentException(String.format("File '%s' was not found", resourceFileName));
        }
        return inputStream;
    }
}
