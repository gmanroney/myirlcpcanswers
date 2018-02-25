package year2017.ReorderReadingList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class reorderList {

    public static void main(String[] args) throws IOException {

        String numberInFile = "/tmp/reorderlist.txt";

        FileReader fileReader = new FileReader(numberInFile);
        BufferedReader br = new BufferedReader(fileReader);

        int bookNum=0;
        int[][] bookStats= new int[10][2];
        int[][] bookSections = new int[10][2];
        int mainCounter=-1;
        boolean firstLine=false;
        String[] linetmp = new String[2];

        String line = br.readLine();
        while (line != null) {
            if ( ! firstLine) {
                bookNum = Integer.parseInt(line);
                firstLine=true;
            } else {
                mainCounter++;
                linetmp = line.split(" ");
                if ( mainCounter < bookNum) {
                    bookStats[0][mainCounter] = Integer.parseInt(linetmp[0]);
                    bookStats[1][mainCounter] = Integer.parseInt(linetmp[1]);
                } else {
                    bookSections[mainCounter-bookNum][0] = Integer.parseInt(linetmp[0]);
                    bookSections[mainCounter-bookNum][1] = Integer.parseInt(linetmp[1]);
                }
            }
            line = br.readLine();
        }
    }
}

