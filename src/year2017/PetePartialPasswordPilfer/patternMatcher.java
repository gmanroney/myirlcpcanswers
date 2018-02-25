package year2017.PetePartialPasswordPilfer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class patternMatcher {

    public static void main(String[] args) throws IOException {

        String numberInFile = "/tmp/patternmatcher.txt";
        String[] nppValues = new String[10];
        String[] napValues = new String[10];

        FileReader fileReader = new FileReader(numberInFile);
        BufferedReader br = new BufferedReader(fileReader);

        int npp = 0;
        int nap = 0;
        int nf = 0;
        int mainCounter=-1;
        boolean firstLine=false;

        String line = br.readLine();
        while (line != null) {
            if ( ! firstLine) {
                String[] config = line.split(" ");
                npp = Integer.parseInt(config[0]);
                nap = Integer.parseInt(config[1]);
                firstLine=true;
            } else {
                mainCounter++;
                if ( mainCounter < npp) {
                    nppValues[mainCounter]=line;
                } else {
                    napValues[mainCounter-npp]=line;
                }
            }
            line = br.readLine();
        }

        for (int i = 0; i < npp; i++ ) {
            nf=0;
            for (int j = 0; j < nap; j++ ) {
                if ( napValues[j].toLowerCase().startsWith(nppValues[i].toLowerCase()) ) nf++;
            }
            System.out.printf("%s\n",nf);
        }

    }
}

