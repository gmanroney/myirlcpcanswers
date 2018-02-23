package PatternMatcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class patternMatcher {

    public static void main(String[] args) throws IOException {

        String numberInFile = "/tmp/patternmatcher.txt";

        String[] config = new String[10];
        String[] nppValues = new String[10];
        String[] napValues = new String[10];

        FileReader fileReader = new FileReader(numberInFile);
        BufferedReader br = new BufferedReader(fileReader);

        int npp = 0;
        int nppCounter=0;
        int nap = 0;
        int napConter=0;
        int mainCounter=0;

        String line = br.readLine();
        while (line != null) {
            if (mainCounter == 0) {
                config = line.split(" ");
                npp = Integer.parseInt(config[0]);
                nap = Integer.parseInt(config[0]);
            } else {
                if (mainCounter > 0 && nppCounter < npp) {
                    nppValues[nppCounter]=line;
                    nppCounter++;
                } else {
                    napValues[napConter]=line;
                    napConter++;
                }
            }
            mainCounter++;
            line = br.readLine();
        }
    }

}

