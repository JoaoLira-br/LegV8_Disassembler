package disassembler;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import instructionFormats.*;

/**
 * @author Joao Victor Lira
 */
public class Disassembler {
    private String fileLocation;
    private int labelPosition;
    private ArrayList<String> lines;
    private ArrayList<Label> labels;
    private Boolean labelDetected;
    private int labelNumber;

    public Disassembler(String fileLocation) {
        this.fileLocation = fileLocation;
        this.labelPosition = 0;
        this.lines = new ArrayList<>();
        this.labels = new ArrayList<>();
        labelDetected = false;
        labelNumber = 0;

    }

    /**
     * @return ArrayList<String>: ArrayList where each string is an instruction line
     *         (1 word) from the input file
     */

    public ArrayList<String> convertToAssembly() {

        lines.add("start:");
        lines.add("");
        try {
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileLocation))) {

                StringBuilder instructionLine = new StringBuilder();
                int byteRead = -1;
                int byteReadCount = 1;
                int linesIndex = 1;
                while ((byteRead = bis.read()) != -1) {

                    instructionLine.append(byteToString(byteRead));

                    // for each 4 bytes (1 word) add it to the arrayList
                    if (byteReadCount % 4 == 0) {
                        linesIndex++;
                        String line = instructionLine.toString();

                        ITF_Instruction inst = parseInstruction(checkFormat(line), line);
                        if (labelDetected == true) {
                            Label label = new Label(linesIndex, labelPosition);
                            labels.add(label);
                            labelDetected = false;
                        }
                        lines.add(inst.getInst());

                        linesIndex++;
                        lines.add("");

                        instructionLine.setLength(0);

                    }
                    byteReadCount++;
                }
            } catch (FileNotFoundException e) {
                throw e;
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        int j = 0;
        while (j < labels.size()) {
            int indexLabelDetected = labels.get(j).getIndexDetected();
            int labelDistance = labels.get(j).getLabelDistance();
            String labelName = String.format("label%1$s:", j);
            applyLabel(indexLabelDetected, labelDistance, labelName);
            j++;
        }
        return lines;

    }

    /**
     * @param byteRead
     * @return String
     */
    public String byteToString(int byteRead) {
        return String.format("%8s", Integer.toBinaryString(byteRead)).replace(' ', '0');
    }

    /**
     * @param instruction
     * @return instructionIdentificator
     */
    public InstructionIdentificator checkFormat(String instruction) {
        String sixBits = instruction.substring(0, 6);
        String eightBits = instruction.substring(0, 8);
        String nineBits = instruction.substring(0, 9);
        String tenBits = instruction.substring(0, 10);
        String elevenBits = instruction.substring(0, 11);

        String[] opCodePossibilities = { sixBits, eightBits, nineBits, tenBits, elevenBits };

        int i = 0;
        InstructionIdentificator enumInst = null;
        while (i < opCodePossibilities.length) {
            if ((enumInst = InstructionIdentificator.valueOfBinary(opCodePossibilities[i])) != null) {
                break;
            }
            i++;
        }
        return enumInst;
    }

    /**
     * @param format: format of the instruction
     * @param binary: instruction in binary
     * @return ITF_Instruction: parsed binary instruction from which we obtain the
     *         the assembly representation in string
     */
    public ITF_Instruction parseInstruction(InstructionIdentificator format, String binary) {

        switch (format.instFormat) {
            case "B":
                B_Format b = new B_Format(binary, format);
                labelPosition = Integer.parseInt(b.getLabelPosition());
                labelDetected = true;
                String BLabelName = String.format("label%1$s", labelNumber);
                b.setLabelName(BLabelName);
                labelNumber++;
                return b;
            case "CB":
                CB_Format cb = new CB_Format(binary, format);
                labelPosition = Integer.parseInt(cb.getLabelPosition());
                labelDetected = true;
                String CBlabelName = String.format("label%1$s", labelNumber);
                cb.setLabelName(CBlabelName);
                labelNumber++;
                return cb;
            case "D":
                D_Format d = new D_Format(binary, format);
                return d;
            case "I":

                return new I_Format(binary, format);
            case "R":
                return new R_Format(binary, format);
            default:
                return new ITF_Instruction() {

                    @Override
                    public String getInst() {
                        return "Unable to find format";
                    }

                };

        }

    }

    /**
     * @param currentPos: position where label was detected
     * @param labelDist:  label distance from current position
     * @param label:      label name
     */
    public void applyLabel(int currentPos, int labelDist, String label) {

        int labelPosition = (currentPos - 1) + (2 * labelDist);
        // String label = String.format("label%1$s:", labelPosition);
        lines.set(labelPosition, label);
    }

}
