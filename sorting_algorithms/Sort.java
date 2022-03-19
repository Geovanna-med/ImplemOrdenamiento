package sorting_algorithms;

public abstract class Sort<T extends Comparable<? super T>>{
    protected int comparations = 0;
    protected int swaps = 0;

    public void print(T[] arr, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i].toString() + " ");
    }

    public int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    public void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(T[] arr, int max) {
        for(int i = 0; i < max/2; i++)
            swap(arr, i, max - i);
    }

    public int getComparations() {
        return comparations;
    }

    public int getSwaps() {
        return swaps;
    }  

}
