package L04_Sorting;

public class QuickSort {
    public static void sort(int[] array, int start, int end){
        // base condition
        if (start >= end) {
            return;
        }

        // Partition the array
        int boundary = partition(array, start, end);

        // Sort the left side of the array
        sort(array, start, boundary - 1);

        // Sort the right side of the array
        sort(array, boundary + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int boundary = start - 1;

        for(int i = start; i <= end; i++) {
            if(array[i] < pivot){
                boundary++;

                // swap two elements
                int temp = array[i];
                array[i] = array[boundary];
                array[boundary] = temp;
            }
        }

        return boundary;
    }
}

class QuickSortRunner{
    public static void main ( String[] args ) {
        int[] numbers = {6, 10, 7, 5, 2,  4, 9, 8, 3};
        QuickSort.sort( numbers, 0, numbers.length - 1 );

        for (  int i = 0; i < numbers.length; i++ ) {
            System.out.print( numbers[ i ] + " " );
        } // [2, 3, 4, 5, 6, 7, 8, 9, 10]
    }
}

