package instructionFormats;

import java.util.HashMap;
import java.util.Map;

import disassembler.InstructionIdentificator;
import disassembler.RegisterIdentificator;

enum BConditions {
    EQ("00000"),
    NE("00001"),
    HS("00010"),
    LO("00011"),
    MI("00100"),
    PL("00101"),
    VS("00110"),
    VC("00111"),
    HI("01000"),
    LS("01001"),
    GE("01010"),
    LT("01011"),
    GT("01100"),
    LE("01101");

    public final String binaryValue;
    private static final Map<String, BConditions> BY_bValue = new HashMap<>();

    static {
        for (BConditions bCond : BConditions.values()) {
            BY_bValue.put(bCond.binaryValue, bCond);

        }

    }

    private BConditions(final String binaryValue) {
        this.binaryValue = binaryValue;
    }

    public static BConditions valueOfBinary(String binary) {
        if (BY_bValue.containsKey(binary)) {
            return BY_bValue.get(binary);
        }
        System.out.println("couldn`t find");
        return null;
    }
}

public class CB_Format implements ITF_Instruction {
    private String binaryValue;

    private String instruction;

    // FIELDS
    private String opCode;
    private String cond_br_adress;
    private String labelName;

    private String rt; // indica uma condition extension

    public CB_Format(String binaryValue, InstructionIdentificator instructionDetails) {
        this.binaryValue = binaryValue;
        this.opCode = instructionDetails.opCode;
        this.instruction = instructionDetails.toString();
        this.cond_br_adress = binaryValue.substring(8, 27);
        if (instruction.equals("B_COND")) {
            this.rt = BConditions.valueOfBinary(binaryValue.substring(27,
                    32)).toString();
        } else {
            this.rt = RegisterIdentificator.valueOfBinary(binaryValue.substring(27, 32)).toString();
        }

    }

    /**
     * @return String
     */
    public String getOpCode() {
        return opCode;
    }

    /**
     * @return String
     */
    public String getRt() {
        return rt;
    }

    /**
     * @return String
     */
    public String getCond_br_adress() {
        return cond_br_adress;
    }

    /**
     * @return String
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * @return String
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * @param labelName
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    /**
     * @return String
     */
    public String getLabelPosition() {
        if (getCond_br_adress().charAt(0) == '1') {
            StringBuilder s = new StringBuilder("11111111");

            s.append(getCond_br_adress());

            int x = (int) Long.parseLong(s.toString(), 2);

            return Integer.toString(x);

        } else {
            StringBuilder s = new StringBuilder("00000000");
            s.append(getCond_br_adress());
            int x = (int) Long.parseLong(s.toString(), 2);
            return Integer.toString(x);
        }

    }

    /**
     * @return String
     */
    @Override
    public String getInst() {
        if (instruction.equals("B_COND")) {
            return String.format("%1$s.%2$s %3$s", getInstruction(), getRt(), getLabelName());
        }
        return String.format("%1$s %2$s, %3$s", getInstruction(), getRt(), getLabelName());
    }

}
