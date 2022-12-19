package disassembler;

import java.util.HashMap;
import java.util.Map;

public enum RegisterIdentificator {

    X0("00000", null),
    X1("00001", null),
    X2("00010", null),
    X3("00011", null),
    X4("00100", null),
    X5("00101", null),
    X6("00110", null),
    X7("00111", null),
    X8("01000", null),
    X9("01001", null),
    X10("01010", null),
    X11("01011", null),
    X12("01100", null),
    X13("01101", null),
    X14("01110", null),
    X15("01111", null),
    X16("10000", null),
    X17("10001", null),
    X18("10010", null),
    X19("10011", null),
    X20("10100", null),
    X21("10101", null),
    X22("10110", null),
    X23("10111", null),
    X24("11000", null),
    X25("11001", null),
    X26("11010", null),
    X27("11011", null),
    X28("11100", "SP"),
    X29("11101", "FP"),
    X30("11110", "LR"),
    X31("11111", "XZR");

    public final String binaryValue;
    public final String mnenonic;
    public final static Map<String, RegisterIdentificator> BY_bValue = new HashMap<>();
    public final static Map<String, RegisterIdentificator> BY_mValue = new HashMap<>();

    static {
        for (RegisterIdentificator regId : RegisterIdentificator.values()) {
            BY_bValue.put(regId.binaryValue, regId);
            BY_mValue.put(regId.mnenonic, regId);
        }
    }

    private RegisterIdentificator(final String binaryValue, final String mnenonic) {
        this.binaryValue = binaryValue;
        this.mnenonic = mnenonic;
    }

    public static RegisterIdentificator valueOfBinary(String binary) {
        if (BY_bValue.containsKey(binary)) {
            return BY_bValue.get(binary);
        }
        return null;
    }

    public static RegisterIdentificator valueOfMnenonic(String mnenonic) {
        if (BY_bValue.containsKey(mnenonic)) {
            return BY_bValue.get(mnenonic);
        }
        return null;
    }

}
