package com.metanit;


import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import util.ArrayUtils;

/*
10. Дан текст, состоящий из предложений. Концом предложения считаются символы точка, '!' и '?'. Началом предложения – любой символ,
отличный от данных трех и пробела, первый после конца предыдущего предложения (или вообще первый в тексте).
Выбрать (в виде списка) из текста все вопросительные предложения.
 */

public class Main {

    public static class InputArgs {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static InputArgs parseArgs(String[] args) {
        InputArgs params = new InputArgs();

        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            if (args.length < 2) {
                params.help = true;
                params.error = true;
                return params;
            }
            params.inputFile = args[0];

            if (args.length > 1) {
                params.outputFile = args[1];
            }
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }


    public static void main(String[] args) {

        InputArgs params = parseArgs(args);

        if (params.help) {
            PrintStream out = params.error ?  System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <input-file> (<output-file>)");
            out.println("  <cmd> --help");
            out.println("  <cmd> --window  // show window");
            System.exit(params.error ? 1 : 0);
        }

        if (params.window) {
           System.out.println("WINDOW");
        } else {

            try {

                String[] dataStr = ArrayUtils.readLinesFromFile(params.inputFile);
                String str = Arrays.toString(dataStr);

                List<String> outStr = Logic.searchQuestion(str);


               PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile, "UTF-8") : System.out;
                for (int i = 0; i < 1; i++) {
                    out.print(outStr);
                }
                out.close();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
