package instructionFormats;

import disassembler.InstructionIdentificator;

public class B_Format implements ITF_Instruction {
    // TODO: Add the Fields as private variables of each format;
    private String binaryValue;
    private String instruction;

    // fields
    private String br_adress; // label
    private String labelName;

    public B_Format(String binary, InstructionIdentificator instruction) {
        this.binaryValue = binary;

        this.br_adress = binary.substring(6);
        this.instruction = instruction.toString();
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
    public String getinstruction() {
        return instruction;
    }

    /**
     * @return String
     */
    public String getBinaryValue() {
        return binaryValue;
    }

    /**
     * @return String
     */
    public String getBr_adress() {
        return br_adress;
    }

    /**
     * @return String
     */
    public String getLabelPosition() {
        StringBuilder s;
        if (getBr_adress().charAt(0) == '1') {
            s = new StringBuilder("111111");

            s.append(getBr_adress());

            int x = (int) Long.parseLong(s.toString(), 2);

            return Integer.toString(x);

        } else {
            s = new StringBuilder("000000");

            s.append(getBr_adress());

            int x = (int) Long.parseLong(s.toString(), 2);

            return Integer.toString(x);
        }

    }

    /**
     * @return String
     */
    @Override
    public String getInst() {
        return String.format("%1$s %2$s", getinstruction(), getLabelName());
    }

}
