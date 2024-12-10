package dk.michaelbui.aoc2024.models.instruction;

public class InstructionToken {
    private InstructionTokenType type;
    private String spelling;
    private static final InstructionTokenType DEFAULT_TYPE = InstructionTokenType.UNKNOWN;

    public InstructionToken(String spelling, InstructionTokenType type) {
        this.type = type;
        this.spelling = spelling;
    }

    public InstructionToken(String spelling) {
        this.spelling = spelling;
        type = DEFAULT_TYPE;
    }

    public InstructionTokenType getType() {
        return type;
    }

    public String getSpelling() {
        return spelling;
    }
}
