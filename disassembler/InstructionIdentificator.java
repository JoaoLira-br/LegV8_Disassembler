package disassembler;

import java.util.HashMap;
import java.util.Map;

public enum InstructionIdentificator {

    ADD("10001011000", "R"),
    ADDI("1001000100", "I"),
    AND("10001010000", "R"),
    ANDI("1001001000", "I"),
    B("000101", "B"),
    B_COND("01010100", "CB"), // This is a CB instruction in which the Rt field is not a register, but a code
                              // that indicates the condition extension
    BL("100101", "B"),
    BR("11010110000", "R"), // The branch target is encoded in the Rn field.
    CBNZ("10110101", "CB"),
    CBZ("10110100", "CB"),
    EOR("11001010000", "R"),
    EORI("1101001000", "I"),
    LDUR("11111000010", "D"),
    LSL("11010011011", "R"), // This instruction uses the shamt field to encode the shift amount, while Rm is
                             // unused.
    LSR("11010011010", "R"), // Same as LSL.
    ORR("10101010000", "R"),
    ORRI("1011001000", "I"),
    STUR("11111000000", "D"),
    SUB("11001011000", "R"),
    SUBI("1101000100", "I"),
    SUBIS("1111000100", "I"),
    SUBS("11101011000", "R"),
    MUL("10011011000", "R"),
    PRNT("11111111101", "R"), // The register is given in the Rd field
    PRNL("11111111100", "R"),
    DUMP("11111111110", "R"),
    HALT("11111111111", "R");

    public final String opCode;
    public final String instFormat;
    private static final Map<String, InstructionIdentificator> BY_bValue = new HashMap<>();
    private static final Map<String, InstructionIdentificator> BY_fValue = new HashMap<>();

    static {
        for (InstructionIdentificator instruction : InstructionIdentificator.values()) {
            BY_bValue.put(instruction.opCode, instruction);
            BY_fValue.put(instruction.instFormat, instruction);
        }
    }

    private InstructionIdentificator(final String binaryValue, final String format) {
        this.opCode = binaryValue;
        this.instFormat = format;

    }

    public static InstructionIdentificator valueOfBinary(String binary) {
        if (BY_bValue.containsKey(binary)) {
            return BY_bValue.get(binary);
        }
        return null;
    }

    public static InstructionIdentificator valueOfFormat(String Format) {
        if (BY_bValue.containsKey(Format)) {
            return BY_bValue.get(Format);
        }
        return null;
    }

}
