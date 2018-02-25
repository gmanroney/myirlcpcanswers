package year2017.Corcaighxit;

import java.io.*;

public class decipherMineMap {

    public static void main(String[] args) throws IOException {

        String mineMapOutFile = "/tmp/mineMapOutFile.txt";
        String mineMapInFile = "/tmp/mineMapInFile.txt";
        int map_i = 1000;
        int map_j = 1000;
        int cnt_i = 0;
        int cnt_j = 0;
        int mineCount = 0;

        String[][] mineMap = new String[map_i][map_j];

        FileReader fileReader = new FileReader(mineMapInFile);
        BufferedReader br = new BufferedReader(fileReader);
        String line = br.readLine();
        while ( line != null )
        {
            String[] linelist = line.split(" ");
            cnt_j=0;
            for (String s: linelist) {
                mineMap[cnt_i][cnt_j]=s;
                cnt_j++;
            }
            line = br.readLine();
            cnt_i++;
        }

        PrintStream out = new PrintStream(new FileOutputStream(mineMapOutFile));
        System.setOut(out);

        for (int i = 0; i < map_i; i++) {
            for (int j = 0; j < map_j; j++) {
                mineCount = 0;
                if (((i-1) >= 0) && ((j-1) >=  0)) {
                    if (mineMap[i-1][j-1].equals("x")) { mineCount++; }
                }
                if ((j-1) >= 0) {
                    if (mineMap[i][j-1].equals("x")) { mineCount++; }
                }
                if (((i+1) < map_i ) && ((j-1) >= 0)) {
                    if (mineMap[i + 1][j - 1].equals("x")) { mineCount++; }
                }
                if ((i-1) >= 0) {
                    if (mineMap[i - 1][j].equals("x")) { mineCount++; }
                }
                if ((i+1) < map_i) {
                    if (mineMap[i+1][j].equals("x")) { mineCount++; }
                }
                if (((i-1) >= 0) && ((j+1) < map_j)) {
                    if (mineMap[i-1][j+1].equals("x")) { mineCount++; }
                }
                if ((j+1) < map_j) {
                    if (mineMap[i][j+1].equals("x")) { mineCount++; }
                }
                if (((i+1) < map_i) && ((j+1) < map_j)) {
                    if (mineMap[i + 1][j + 1].equals("x")) { mineCount++; }
                }
                if ( ! mineMap[i][j].equals("x")) { mineMap[i][j] = String.valueOf(mineCount); }
            }
        }
        for (int i = 0; i < map_i; i++) {
            String newline = "";
            if ( i > 0 ) System.out.println();
            for (int j = 0; j < map_j; j++) System.out.printf("%s ", mineMap[i][j]);
        }
    }
}

