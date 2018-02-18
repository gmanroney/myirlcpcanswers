package GoldbachGnarly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class goldbachConjecture {

    public static void main(String[] args) throws IOException {

        String numberInFile = "/tmp/numberInFile.txt";

        String[] inNumbers = new String[10];

        FileReader fileReader = new FileReader(numberInFile);
        BufferedReader br = new BufferedReader(fileReader);
        String line = br.readLine();

        int n_even = 0;
        int w_ways = 0;

        while (line != null) {
            inNumbers = line.split(" ");
            line = br.readLine();
        }

        n_even = Integer.parseInt(inNumbers[0]);
        w_ways = Integer.parseInt(inNumbers[1]);


    }
}

