package year2017.GoldbachGnarly;

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
        int c_even=0;
        boolean duplicateFound = false;
        boolean matchFound = false;
        int matchValue = 0;

        Integer[][] pairHistory = new Integer[600][2];

        for (int i=0; i< 5000; i++ ){
            even_number = even_number + 2;
            ways=0;
            for (int k=0; k<600; k++) {
                pairHistory[k][0]=0;
                pairHistory[k][1]=0;
            }
            for ( int j=even_number-2; j>2; j--) {
                remainder = even_number-j;
                if ( isPrime(j) && isPrime (remainder)) {
                    min_val=Math.min(j,remainder);
                    max_val=Math.max(j,remainder);

                    // check to see if value is in array
                    duplicateFound=false;
                    for ( int k = 0; k < pairHistory.length; k++ )
                    {
                        if (( pairHistory[k][0]==min_val) && ( pairHistory[k][1]==max_val)) duplicateFound=true;
                    }
                    if ( ! duplicateFound ) {
                        //System.out.printf(">>> %s %s\n", min_val, max_val);
                        pairHistory[ways][0] = min_val;
                        pairHistory[ways][1] = max_val;
                        ways++;
                    }
                }
            }
            if ( ways == w_ways) {
                c_even++;
                if ( c_even == n_even )
                {
                    matchFound=true;
                    matchValue = even_number;
                }
            }
            System.out.printf("%s %s\n", even_number, ways);
        }
        if (matchFound) {
            System.out.printf("Found match: %s value with %s pairings is %s", n_even, w_ways, matchValue);
        } else {
            System.out.printf("No value found.");
        }

    }
}

