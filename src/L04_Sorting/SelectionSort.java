package L04_Sorting;

public class SelectionSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // swap two elements
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}

class SelectionSortRunner{
    public static void main ( String[] args ) {
        int[] numbers = {6, 10, 7, 5, 2,  4, 9, 8, 3};
        SelectionSort.sort( numbers );

        for (  int i = 0; i < numbers.length; i++ ) {
            System.out.print( numbers[ i ] + " " );
        } // [2, 3, 4, 5, 6, 7, 8, 9, 10]
    }
}
