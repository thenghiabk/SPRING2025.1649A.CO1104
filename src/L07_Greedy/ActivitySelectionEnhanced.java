package L07_Greedy;

class Activity {
    String name;
    int start, finish;

    public Activity( String name, int start, int finish ) {
        this.name = name;
        this.start = start;
        this.finish = finish;
    }
    public String toString( ) {
        return String.format( "[Activity %s - Start: %d, Finish: %d", name, start, finish );
    }
}

public class ActivitySelectionEnhanced {

    public static void selectActivities( Activity[] activities ) {
        // Sort activities
        sort( activities );

        // The first activity is always selected
        System.out.println( "Selected Activities:" );
        System.out.println( activities[ 0 ] );

        // Consider the rest of the activities
        int j = 0;
        for ( int i = 1; i < activities.length; i++ ) {
            // If this activity has a start time greater than or equal to the finish time
            // of the previously selected activity, then select it
            if ( activities[ i ].start >= activities[ j ].finish ) {
                System.out.println( activities[ i ] );
                j = i;
            }
        }
    }

    private static void sort( Activity[] activities ) {
        // Sort activities based on their finish times using a simple sorting algorithm
        for ( int i = 0; i < activities.length - 1; i++ ) {
            for ( int j = 0; j < activities.length - i - 1; j++ ) {
                if ( activities[ j ].finish > activities[ j + 1 ].finish ) {
                    // Swap activities
                    Activity temp = activities[ j ];
                    activities[ j ] = activities[ j + 1 ];
                    activities[ j + 1 ] = temp;
                }
            }
        }
    }
}

class ActivitySelectionEnhancedTest {
    public static void main( String[] args ) {
        Activity[] activities = new Activity[ 6 ];
        activities[ 0 ] = new Activity( "A1", 0, 6 );
        activities[ 1 ] = new Activity( "A2", 3, 5 );
        activities[ 2 ] = new Activity( "A3", 1, 2 );
        activities[ 3 ] = new Activity( "A4", 5, 8 );
        activities[ 4 ] = new Activity( "A5", 5, 7 );
        activities[ 5 ] = new Activity( "A6", 8, 9 );

        ActivitySelectionEnhanced.selectActivities( activities );
    }
}
