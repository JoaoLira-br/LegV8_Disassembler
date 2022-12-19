import java.util.ArrayList;

import disassembler.Disassembler;

/**
 * @author Joao Victor Lira
 * 
 **/
public class Main {
        /**
         * @param args: file name given as argument to script run.sh; the binary legv8
         *              file to be converted
         */
        public static void main(String[] args) {

                // Main:
                Disassembler t = new Disassembler(args[0]);
                ArrayList<String> input;

                input = t.convertToAssembly();

                int i = 0;
                while (i < input.size()) {
                        System.out.println(input.get(i));

                        i++;
                }

        }
}
