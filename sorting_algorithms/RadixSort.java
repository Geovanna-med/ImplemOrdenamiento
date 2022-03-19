package sorting_algorithms;

import java.util.*;

import movies.Movie;
public class RadixSort extends Sort<Movie>{

    private int getMax(Movie[] arr, int n) {
        int mx = arr[0].getTitleYear();
        for (int i = 1; i < n; i++)
            if (arr[i].getTitleYear() > mx)
                mx = arr[i].getTitleYear();
        return mx;
    }

    private void countSort(Movie[] arr, int n, int exp) {
        Movie[] output = new Movie[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(arr[i].getTitleYear() / exp) % 10]++;


        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i].getTitleYear() / exp) % 10] - 1] = arr[i];
            count[(arr[i].getTitleYear() / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public void sort(Movie arr[], int n, boolean descendant) {
        int m = getMax(arr, n);
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
        if(descendant)
            reverse(arr, n);
    }
}
