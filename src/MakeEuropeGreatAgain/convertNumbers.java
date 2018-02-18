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
            int arabicNumber = Integer.parseInt(s);
            quotient[0] = arabicNumber / 1000;
            remainder[0] = arabicNumber % 1000;
            quotient[1] = remainder[0] / 500;
            remainder[1] = remainder[0] % 500;
            quotient[2]= remainder[1] / 100;
            remainder[2] = remainder[1] % 100;
            quotient[3]= remainder[2] / 50;
            remainder[3] = remainder[2] % 50;
            quotient[4] = remainder[3] / 10;
            remainder[4] = remainder[3] % 10;
            quotient[5] = remainder[4] / 5;
            remainder[5] = remainder[4] % 5;
            quotient[6] = remainder[5] / 1;
            remainder[6]= remainder[5] % 1;

            System.out.printf("%s | %s %s %s %s %s %s %s\n",s,quotient[0],quotient[1],quotient[2],quotient[3],quotient[4],quotient[5],quotient[6]);
            romanName="";
            for (int i = quotient[0]; i>0; i-- ) {
                romanName = romanName + "M";
            }
            for (int i = quotient[1]; i>0; i-- ) {
                romanName = romanName + "D";
            }
            for (int i = quotient[2]; i>0; i-- ) {
                romanName = romanName + "C";
            }
            for (int i = quotient[3]; i>0; i-- ) {
                romanName = romanName + "L";
            }
            for (int i = quotient[4]; i>0; i-- ) {
                romanName = romanName + "X";
            }
            for (int i = quotient[5]; i>0; i-- ) {
                romanName = romanName + "V";
            }
            for (int i = quotient[6]; i>0; i-- ) {
                romanName = romanName + "I";
            }

            System.out.println(romanName);
        }

    }
}
