package instructionFormats;

import disassembler.InstructionIdentificator;
import disassembler.RegisterIdentificator;

public class D_Format implements ITF_Instruction {
    private String binaryValue;
    private String instruction;

    // FIELDS
    private String dt_adress; // o numero binario dividido por 4

    private String rn;
    private String rt;
    private int displayedAddress;

    public D_Format(String binaryValue, InstructionIdentificator instructionDetails) {
        this.binaryValue = binaryValue;
        this.instruction = instructionDetails.toString();
        this.dt_adress = binaryValue.substring(11, 20);

        this.rn = RegisterIdentificator.valueOfBinary(binaryValue.substring(22, 27)).toString();
        this.rt = RegisterIdentificator.valueOfBinary(binaryValue.substring(27, 32)).toString();
        this.displayedAddress = getAdress();
    }

    /**
     * @return String
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * @return int
     */
    public int getAdress() {

        int address = Integer.parseInt(getDt_adress(), 2);

        return address;
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
    public String getRn() {
        return rn;
    }

    /**
     * @return String
     */
    public String getDt_adress() {
        return dt_adress;
    }

    /**
     * @return int
     */
    public int getDisplayedAddress() {
        return displayedAddress;
    }

    /**
     * @return String
     */
    @Override
    public String getInst() {
        return String.format("%1$s %2$s, [%3$s, #%4$s]", getInstruction(), getRt(), getRn(), getAdress());
    }

}
