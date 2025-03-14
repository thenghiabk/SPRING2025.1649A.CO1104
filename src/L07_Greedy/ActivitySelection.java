package L07_Greedy;

// Java program for activity selection problem.

// The following implementation assumes that the activities
// are already sorted according to their finish time

import java.lang.*;

class ActivitySelection {
    // Prints a maximum set of activities that can be done
    // by a single person, one at a time.
    public static void selectActivities ( int s[], int f[],
                                          int n ) {
        int i, j;

        System.out.println(
                "Following activities are selected" );

        // The first activity always gets selected
        i = 0;
        System.out.print( i + " " );

        // Consider rest of the activities
        for ( j = 1; j < n; j++ ) {
            // If this activity has start time greater than
            // or equal to the finish time of previously
            // selected activity, then select it
            if ( s[ j ] >= f[ i ] ) {
                System.out.print( j + " " );
                i = j;
            }
        }
    }
}

class ActivitySelectionRunner {
    public static void main ( String[] args ) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int finish[] = { 2, 4, 6, 7, 9, 9 };
        int n = start.length;

        // Function call
        ActivitySelection.selectActivities( start, finish, n );
    }
}