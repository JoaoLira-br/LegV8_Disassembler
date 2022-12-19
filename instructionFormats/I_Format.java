package instructionFormats;

import disassembler.InstructionIdentificator;
import disassembler.RegisterIdentificator;

public class I_Format implements ITF_Instruction {
    private String binaryValue;

    /**
     * @return String
     */
    public String getBinaryValue() {
        return binaryValue;
    }

    private String instruction;

    // FIELDS
    private String alu_immediate; // displayed number mesmo que o numero binario

    private String rn;

    private String rd;

    public I_Format(String binaryValue, InstructionIdentificator instructionDetails) {
        this.binaryValue = binaryValue;
        this.instruction = instructionDetails.toString();
        this.alu_immediate = binaryValue.substring(10, 22);
        this.rn = RegisterIdentificator.valueOfBinary(binaryValue.substring(22, 27)).toString();
        this.rd = RegisterIdentificator.valueOfBinary(binaryValue.substring(27, 32)).toString();

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
    public String getAlu_immediate() {
        return alu_immediate;
    }

    /**
     * @return int
     */
    public int getIntegerImmediate() {
        return Integer.parseInt(getAlu_immediate(), 2);
    }

    /**
     * @return String
     */
    @Override
    public String getInst() {
        return String.format("%1$s %2$s, %3$s, #%4$s", getInstruction(), getRd(), getRn(), getIntegerImmediate());
    }

}
