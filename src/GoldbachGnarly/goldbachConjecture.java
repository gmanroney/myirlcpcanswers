package GoldbachGnarly;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class goldbachConjecture {

    static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        String numberInFile = "/tmp/goldbach.txt";

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

        int even_number = 2;
        int remainder = 0;
        int ways = 0;
        int min_val=0;
        int max_val=0;
        Integer[][] pairHistory = new Integer[60][2];

        for (int i=0; i< n_even; i++ ){
            even_number = even_number + 2;
            ways=0;
            for (int k=0; k<60; k++) {
                pairHistory[k][0]=0;
                pairHistory[k][1]=0;
            }
            for ( int j=even_number; j>(even_number/2); j--) {
                remainder = even_number-j;
                if ( isPrime(j) && isPrime (remainder)) {
                    if (j<remainder) {
                        min_val=j;
                        max_val=remainder;
                    } else {
                        min_val=remainder;
                        max_val=j;
                    }
                    pairHistory[ways][0]=min_val;
                    pairHistory[ways][1]=max_val;
 //                   System.out.printf(">>> %s %s\n", min_val, max_val);
                    ways++;
                }
            }
            System.out.printf("%s %s\n", even_number, ways);
        }

    }
}

