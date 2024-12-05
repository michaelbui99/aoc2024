package dk.michaelbui.aoc2024.models;

public class Dampener {
    private boolean consumed = false;

    public void consume() {
        consumed = true;
    }

    public boolean consumed() {
        return consumed;
    }
}
