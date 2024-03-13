/* 
 LAUREL RAEANNE TAY
 LTAY3@U.ROCHESTER.EDU
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class URCalculator {

    public static void main(String[] args) throws IOException, FileNotFoundException {
        if (args.length != 2) {
            System.out.println("To use: java URCalculator input_file output_file");
            return;
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        try {
            FileReader source = new FileReader(inputFileName);
            BufferedReader reader = new BufferedReader(source);

            String line;

            ArrayList<String> eachLineString = new ArrayList<String>();
            ArrayList<ArrayList<String>> eachLineChar = new ArrayList<ArrayList<String>>();

            PrintWriter out = new PrintWriter(new File(outputFileName));

            line = reader.readLine();
            while (line != null) {
                eachLineString.add(line);

                line = reader.readLine();
            }

            int i = 0;
            for (String s : eachLineString) {
                InfixCalc calc;

                ArrayList<String> eachChar = new ArrayList<String>();
                for (int l = 0; l < s.length(); ) {
                    if (!("" + s.charAt(l)).equals(" ")) {
                        eachChar.add("" + s.charAt(l));

                        int j = 1;
                        while (((l + j) < s.length()) && (!((("" + s.charAt(l + j)).equals(" ")))
                                && (!((("" + s.charAt(l)).equals("(")))) && (!((("" + s.charAt(l)).equals("!")))))) {

                            if (("" + s.charAt(l + j)).equals(")")) {
                                eachChar.add(")");
                            } else {
                                eachChar.set(eachChar.size() - 1, "" + eachChar.get(eachChar.size() - 1) + s.charAt(l + j));
                            }
                            j++;
                        }

                        l = l + j;
                    } else {
                        l++;
                    }
                }
                eachLineChar.add(eachChar);

                calc = new InfixCalc(eachLineChar.get(i));

                if (calc.answer().startsWith("Error.")) {
                    out.printf(calc.answer() + "%n");
                } else {
                    out.printf("%.2f%n", Double.valueOf(calc.answer()));
                }

                i++;
            }

            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("Unable to write destination " + outputFileName);
        } catch (IOException e) {
            System.out.println("Not found");
        }
    }
}
