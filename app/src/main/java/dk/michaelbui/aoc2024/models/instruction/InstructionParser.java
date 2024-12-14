package dk.michaelbui.aoc2024.models.instruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InstructionParser {
    private InstructionToken currentToken;
    private int readIdx = -1;
    private List<InstructionToken> tokens = new ArrayList<>();

    public InstructionParser(String source) {
        InstructionScanner scanner = new InstructionScanner(source);
        tokens = scanner.scan();
        consumeToken();
    }

    public List<Instruction> parse() {
        List<Instruction> instructions = new ArrayList<>();

        while (currentToken.getType() != InstructionTokenType.EOF) {
            switch (currentToken.getType()) {
                case InstructionTokenType.MUL -> parseMulInstruction().ifPresent(instructions::add);
                case InstructionTokenType.DONT -> parseDontInstruction().ifPresent(instructions::add);
                case InstructionTokenType.DO -> parseDoInstruction().ifPresent(instructions::add);
                default -> consumeToken();
            }
        }

        return instructions;
    }

    private Optional<MulInstruction> parseMulInstruction() {
        List<Boolean> acceptResults = new ArrayList<>();

        acceptResults.add(accept(InstructionTokenType.MUL));
        acceptResults.add(accept(InstructionTokenType.LEFT_PAREN));

        String digit1Candidate = currentToken.getSpelling();
        acceptResults.add(accept(InstructionTokenType.DIGIT));

        acceptResults.add(accept(InstructionTokenType.COMMA));

        String digit2Candidate = currentToken.getSpelling();
        acceptResults.add(accept(InstructionTokenType.DIGIT));

        acceptResults.add(accept(InstructionTokenType.RIGHT_PAREN));

        if (!acceptResults.stream().allMatch(res -> res)) {
            return Optional.empty();
        }

        return Optional.of(new MulInstruction(Integer.parseInt(digit1Candidate), Integer.parseInt(digit2Candidate)));
    }


    private Optional<DoInstruction> parseDoInstruction() {
        List<Boolean> acceptResults = new ArrayList<>();

        acceptResults.add(accept(InstructionTokenType.DO));
        acceptResults.add(accept(InstructionTokenType.LEFT_PAREN));
        acceptResults.add(accept(InstructionTokenType.RIGHT_PAREN));

        if (!acceptResults.stream().allMatch(res -> res)) {
            return Optional.empty();
        }

        return Optional.of(new DoInstruction());
    }

    private Optional<DontInstruction> parseDontInstruction() {
        List<Boolean> acceptResults = new ArrayList<>();

        acceptResults.add(accept(InstructionTokenType.DONT));
        acceptResults.add(accept(InstructionTokenType.LEFT_PAREN));
        acceptResults.add(accept(InstructionTokenType.RIGHT_PAREN));

        if (!acceptResults.stream().allMatch(res -> res)) {
            return Optional.empty();
        }

        return Optional.of(new DontInstruction());
    }

    private boolean accept(InstructionTokenType type) {
        if (currentToken.getType() != type) {
            consumeToken();
            return false;
        }

        consumeToken();
        return true;
    }

    private void consumeToken() {
        readIdx++;
        currentToken = tokens.get(readIdx);
    }

}
