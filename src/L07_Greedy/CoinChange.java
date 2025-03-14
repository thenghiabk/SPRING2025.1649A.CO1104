package L07_Greedy;

import java.util.Scanner;
import java.util.Arrays;

public class CoinChange {
    public static int getMinCoins ( int[] coinDenoms, int target ) {

        // Sort denominations descending
        Arrays.sort( coinDenoms );

        int minCoins = 0;
        int index = coinDenoms.length - 1;

        while ( target > 0 ) {
            int currentCoin = coinDenoms[ index ];

            if ( currentCoin <= target ) {
                int maxAmount = target / currentCoin;
                target -= maxAmount * currentCoin;
                minCoins += maxAmount;
                System.out.println( "Taking " + maxAmount + " of " + currentCoin );
            } else {
                index--;
            }
        }

        return minCoins;
    }
}

class CoinChangeRunner {
    public static void main ( String[] args ) {

        Scanner scanner = new Scanner( System.in );

        int[] coins = { 20, 10, 50, 2, 5, 1 };

        int target = 923;

        int minCoins = CoinChange.getMinCoins( coins, target );

        System.out.println( "Minimum coins needed: " + minCoins );
    }
}