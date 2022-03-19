package sorting_algorithms;

/*DONE */
public class QuickSort<T extends Comparable<? super T>> extends Sort<T>{
    

    public void sort(T[] arr, int low, int high, boolean order) {
        if (low < high) {
            int pi = partition(arr, low, high, order);

            sort(arr, low, pi - 1, order);
            sort(arr, pi + 1, high, order);
        }
    }

    private int partition(T[] arr, int low, int high, boolean order) {
        T pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            comparations++;
            if(order){
                if (arr[j].compareTo(pivot) < 0) {
                    i++;
                    swap(arr, i, j);
                    swaps++;
                }
            } else {
                if (arr[j].compareTo(pivot) > 0) {
                    i++;
                    swap(arr, i, j);
                    swaps++;
                }
            }
        }
        swaps++;
        swap(arr, i + 1, high);
        return (i + 1);
    }
}
