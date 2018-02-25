package year2017.Corcaighxit;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileOutputStream;

public class makeMineMap {

    public static boolean randomBoolean(){
        return Math.random() < 0.5;
    }

    public static void main( String[] args ) throws FileNotFoundException {

        int bombCount = 250000;
        int map_i = 1000;
        int map_j = 1000;
        String mapVal = "";
        String[][] mineMap = new String[map_i][map_j];
        String mineMapInFile = "/tmp/mineMapInFile.txt";

        PrintStream out = new PrintStream(new FileOutputStream(mineMapInFile));
        System.setOut(out);

        for (int i = 0; i < map_i; i++) {
            boolean rnd_i = randomBoolean();

            for (int j = 0; j < map_j; j++) {
                boolean rnd_j = randomBoolean();
                mapVal = "o";
                if ( rnd_j )
                {
                    if ( rnd_i == rnd_j )
                    {
                        if ( bombCount > 0 )
                        {
                            bombCount = bombCount - 1;
                            mapVal = "x";
                        }
                    }
                }
                mineMap[i][j] = mapVal;

                if ((j == 0) && (i > 0))
                {
                System.out.println();
                }
                System.out.printf("%s ", mineMap[i][j]);
            }
        }
    }
}
