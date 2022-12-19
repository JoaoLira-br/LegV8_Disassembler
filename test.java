
public class test {
    // TESTING:
    // Translator t = new Translator(args[0]);
    // ArrayList<String> input;

    // input = t.extractLines();

    // // NOTES: int start = 0, ...
    // // int final = contagem 1 ...,

    // System.out.println(t.checkFormat(input.get(0)));
    // System.out.println("Expected Add instruction " + input.get(0));
    // System.out.println("Expected Add instruction " + input.get(0).substring(0,
    // 11));
    // System.out.println("Expected Add instruction " + input.get(0).substring(11,
    // 16));
    // System.out.println("Expected Add instruction " + input.get(0).substring(16,
    // 22));
    // System.out.println("Expected Add instruction " + input.get(0).substring(22,
    // 27));
    // System.out.println("Expected Add instruction " + input.get(0).substring(27,
    // 32));

    // testing checkFormat
    // NOTES: CONSIGO ADQUIRIR FORMATO, INSTRUCTION, E BINARY INSTRUCTION
    // int i = 0;
    // while (i < input.size()) {
    // String binary = input.get(i);
    // System.out
    // .println(String.format("%1$s - Binary Value: %2$s - Format: %3$s",
    // t.checkFormat(binary).toString(), binary, t.checkFormat(binary).instFormat));
    // i++;
    // }

    // ULTIMOS TESTES

    // // TESTING:
    // Translator t = new Translator(args[0]);
    // ArrayList<String> input;

    // input = t.extractLines();

    // int i = 0;
    // while (i < input.size()) {
    // String binary;
    // if (i >= 2 && i % 2 == 0) {
    // binary = input.get(i);
    // System.out.println(
    // String.format("%1$s - Binary Value: %2$s - Format: %3$s | Index: %4$s",
    // t.checkFormat(binary).toString(), binary,
    // t.checkFormat(binary).instFormat,
    // Integer.toString(i)));
    // } else {
    // System.out.println(input.get(i) + " | index: " + Integer.toString(i));
    // }

    // i++;
    // }
    // System.out.println(t.checkFormat(input.get(2)));
    // String CB = input.get(10);
    // System.out.println(CB.substring(8, 27));
    // System.out.println(CB.substring(27, 32));
    // CB_Format cb = new CB_Format(CB, t.checkFormat(CB));

    // System.out.println("cond_br_address: " + cb.getCond_br_adress() + " length: "
    // + cb.getCond_br_adress().length());
    // System.out.println("rt: " + cb.getRt());
    // System.out.println("positive label: " +
    // Integer.parseInt(cb.getLabelPosition()));

    // String B = input.get(18);
    // System.out.println("B: " + B);
    // System.out.println("B.length: " + B.length());
    // B_Format b = new B_Format(B, t.checkFormat(B));
    // System.out.println("ADDRESS: " + b.getBr_adress());
    // System.out.println("B opcode: " + B.substring(0, 6) + " - B Adress: " +
    // B.substring(6, 32));
    // System.out.println("LABEL: " + Integer.parseInt(b.getLabelPosition())); //
    // TESTING:
    // Translator t = new Translator(args[0]);
    // ArrayList<String> input;

    // input = t.extractLines();

    // int i = 0;
    // while (i < input.size()) {
    // String binary;
    // if (i >= 2 && i % 2 == 0) {
    // binary = input.get(i);
    // System.out.println(
    // String.format("%1$s - Binary Value: %2$s - Format: %3$s | Index: %4$s",
    // t.checkFormat(binary).toString(), binary,
    // t.checkFormat(binary).instFormat,
    // Integer.toString(i)));
    // } else {
    // System.out.println(input.get(i) + " | index: " + Integer.toString(i));
    // }

    // i++;
    // }
    // System.out.println(t.checkFormat(input.get(2)));
    // String CB = input.get(10);
    // System.out.println(CB.substring(8, 27));
    // System.out.println(CB.substring(27, 32));
    // CB_Format cb = new CB_Format(CB, t.checkFormat(CB));

    // System.out.println("cond_br_address: " + cb.getCond_br_adress() + " length: "
    // + cb.getCond_br_adress().length());
    // System.out.println("rt: " + cb.getRt());
    // System.out.println("positive label: " +
    // Integer.parseInt(cb.getLabelPosition()));

    // String B = input.get(18);
    // System.out.println("B: " + B);
    // System.out.println("B.length: " + B.length());
    // B_Format b = new B_Format(B, t.checkFormat(B));
    // System.out.println("ADDRESS: " + b.getBr_adress());
    // System.out.println("B opcode: " + B.substring(0, 6) + " - B Adress: " +
    // B.substring(6, 32));
    // System.out.println("LABEL: " + Integer.parseInt(b.getLabelPosition()));

}
