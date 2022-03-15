package sorting_algorithms;

public class RadixSort extends Sort{

    public static void sort(int arr[], int n) {
        int m = getMax(arr, n);

        for (int exp = 1; m / exp > 0; exp *= 10)
            CountSort.sort(arr, n, exp);
    }

}
