package instructionFormats;

import disassembler.InstructionIdentificator;
import disassembler.RegisterIdentificator;

public class R_Format implements ITF_Instruction {

    // TODO: handle BR: The branch target is encoded in the Rn field, resto 0
    // LSL: This instruction uses the shamt field to encode the shift amount, while
    // Rm is unused. displayed immediate = binary shamt
    // LSR: Same as LSL
    // PRNT: The register is given in the Rd field. resto 0
    // PRNL, DUMP, HALT

    private String binaryValue;
    private String instruction;

    // FIELD
    private String rm;
    private String shamt;
    private String rn;
    private String rd;
    private int decimalShamt;

    public R_Format(String binaryValue, InstructionIdentificator instructionDetails) {
        this.binaryValue = binaryValue;
        this.instruction = instructionDetails.toString();
        this.rm = RegisterIdentificator.valueOfBinary(binaryValue.substring(11, 16)).toString();
        this.shamt = binaryValue.substring(16, 22);
        this.rn = RegisterIdentificator.valueOfBinary(binaryValue.substring(22, 27)).toString();
        this.rd = RegisterIdentificator.valueOfBinary(binaryValue.substring(27, 32)).toString();
        this.decimalShamt = getDecimalShamt();
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
    public String getRd() {
        return rd;
    }

    /**
     * @return String
     */
    public String getRn() {
        return rn;
    }

    /**
     * @return String
     */
    public String getShamt() {
        return shamt;
    }

    /**
     * @return int
     */
    public int getDecimalShamt() {
        return Integer.parseInt(getShamt(), 2);
    }

    /**
     * @return String
     */
    public String getRm() {
        return rm;
    }

    /**
     * @return String
     */
    @Override
    public String getInst() {

        if (instruction.equals("PRNL") || instruction.equals("DUMP") || instruction.equals("HALT")) {
            return instruction;
        } else if (instruction.equals("BR")) {
            return String.format("%1$s %2$s", getInstruction(), getRn());
        } else if (instruction.equals("LSL") || instruction.equals("LSR")) {
            return String.format("%1$s %2$s, %3$s, #%4$s", getInstruction(), getRd(), getRn(), getDecimalShamt());
        } else if (instruction.equals("PRNT")) {
            return String.format("%1$s %2$s", getInstruction(), getRd());
        } else {
            return String.format("%1$s %2$s, %3$s, #%4$s", getInstruction(), getRd(), getRn(), getRm());
        }
    }

}