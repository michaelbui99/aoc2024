package dk.michaelbui.aoc2024.models.instruction;

import java.util.ArrayList;
import java.util.List;

public class InstructionScanner {
    private String source = "";
    private int readIdx = 0;

    public InstructionScanner(String source) {
        this.source = source;
    }

    public List<InstructionToken> scan() {
        List<InstructionToken> tokens = new ArrayList<>();

        while (!isAtEnd()) {
            char c = source.charAt(readIdx);
            if (c == '(') {
                tokens.add(new InstructionToken(String.valueOf(c), InstructionTokenType.LEFT_PAREN));
            } else if (c == ')') {
                tokens.add(new InstructionToken(String.valueOf(c), InstructionTokenType.RIGHT_PAREN));
            } else if (c == 'm') {
                String mulCandidate = String.format("m%s%s", peekAhead(1), peekAhead(2));
                if (mulCandidate.equals("mul")) {
                    tokens.add(new InstructionToken(String.valueOf(c), InstructionTokenType.MUL));
                } else {
                    tokens.add(new InstructionToken(String.valueOf(c), InstructionTokenType.UNKNOWN));
                }
                readIdx += 3;
                continue;
            } else if (c == 'd') {
                if (peekAhead(1) != 'o') {
                    tokens.add(new InstructionToken(String.valueOf(c), InstructionTokenType.UNKNOWN));
                    readIdx++;
                    continue;
                }

                String dontCandidate = String.format("d%s%s%s%s", peekAhead(1), peekAhead(2), peekAhead(3), peekAhead(4));
                if (dontCandidate.equals("don't")) {
                    tokens.add(new InstructionToken("don't", InstructionTokenType.DONT));
                    readIdx += 5;
                    continue;
                }

                tokens.add(new InstructionToken("do", InstructionTokenType.DO));
                readIdx += 2;
                continue;
            } else if (c == ',') {
                tokens.add(new InstructionToken(String.valueOf(c), InstructionTokenType.COMMA));
            } else if (c == ' ') {
                tokens.add(new InstructionToken(String.valueOf(c), InstructionTokenType.WHITESPACE));
            } else if (Character.isDigit(c)) {
                int peekAmount = 0;
                StringBuilder finalDigit = new StringBuilder();
                while (Character.isDigit(this.peekAhead(peekAmount))) {
                    finalDigit.append(this.peekAhead(peekAmount));
                    peekAmount++;
                }
                readIdx += peekAmount - 1;
                tokens.add(new InstructionToken(finalDigit.toString(), InstructionTokenType.DIGIT));
            } else {
                tokens.add(new InstructionToken(String.valueOf(c), InstructionTokenType.UNKNOWN));
            }
            readIdx++;
        }

        tokens.add(new InstructionToken("", InstructionTokenType.EOF));
        return tokens;
    }

    private boolean isAtEnd() {
        return readIdx >= source.length();
    }

    private char peekAhead(int amount) {
        return source.charAt(readIdx + amount);
    }
}
