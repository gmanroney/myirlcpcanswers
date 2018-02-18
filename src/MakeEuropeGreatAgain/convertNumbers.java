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

        for (String s: inNumbers) {
            System.out.printf("%s\n",s);
        }

    }
}
