package MakeEuropeGreatAgain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class convertNumbers {

    public static void main(String[] args) throws IOException {

        String numberInFile = "/tmp/numberInFile.txt";

        String[] inNumbers = new String[10];

        FileReader fileReader = new FileReader(numberInFile);
        BufferedReader br = new BufferedReader(fileReader);
        String line = br.readLine();

        while ( line != null )
        {
            inNumbers = line.split(" ");
            line = br.readLine();
        }

        int[] quotient = new int[7];
        int[] remainder = new int[7];
        String romanName="";

        for (String s: inNumbers) {
            romanName="";

            int arabicNumber = Integer.parseInt(s);

            // Process 1000's
            quotient[0] = arabicNumber / 1000;
            remainder[0] = arabicNumber % 1000;
            for (int i = quotient[0]; i>0; i-- ) {
                romanName = romanName + "M";
            }
            if ( remainder[0] > 899 )
            {
                romanName = romanName + "CM";
                remainder[0] = remainder[0] - 900;
            }

            // Process 500's
            quotient[1] = remainder[0] / 500;
            remainder[1] = remainder[0] % 500;
            for (int i = quotient[1]; i>0; i-- ) {
                romanName = romanName + "D";
            }
            if ( remainder[1] > 399 )
            {
                romanName = romanName + "CD";
                remainder[1] = remainder[1] - 400;
            }

            // Process 100's
            quotient[2]= remainder[1] / 100;
            remainder[2] = remainder[1] % 100;
            for (int i = quotient[2]; i>0; i-- ) {
                romanName = romanName + "C";
            }
            if ( remainder[2] > 89 )
            {
                romanName = romanName + "CX";
                remainder[2] = remainder[2] - 90;
            }

            // Process 50's
            quotient[3]= remainder[2] / 50;
            remainder[3] = remainder[2] % 50;
            for (int i = quotient[3]; i>0; i-- ) {
                romanName = romanName + "L";
            }
            if ( remainder[3] > 39 )
            {
                romanName = romanName + "CL";
                remainder[3] = remainder[3] - 40;
            }

            // Process 10's
            quotient[4] = remainder[3] / 10;
            remainder[4] = remainder[3] % 10;
            for (int i = quotient[4]; i>0; i-- ) {
                romanName = romanName + "X";
            }
            if ( remainder[4] > 8 )
            {
                romanName = romanName + "IX";
                remainder[4] = remainder[4] - 9;
            }

            // Process 5's
            quotient[5] = remainder[4] / 5;
            remainder[5] = remainder[4] % 5;
            for (int i = quotient[5]; i>0; i-- ) {
                romanName = romanName + "V";
            }
            if ( remainder[5] > 3 )
            {
                romanName = romanName + "IV";
                remainder[5] = remainder[5] - 4;
            }

            // Process 1's
            quotient[6] = remainder[5] / 1;
            remainder[6]= remainder[5] % 1;
            for (int i = quotient[6]; i>0; i-- ) {
                romanName = romanName + "I";
            }

            System.out.printf("%s | %s\n",s,romanName);
        }

    }
}
