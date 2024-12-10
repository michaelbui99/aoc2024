package dk.michaelbui.aoc2024.models.instruction;

public class MulInstruction {
    private int a;
    private int b;

    public MulInstruction(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int evaluate() {
        return a * b;
    }
}