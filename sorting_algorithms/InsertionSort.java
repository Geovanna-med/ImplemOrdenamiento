package sorting_algorithms;

/**DONE */
public class InsertionSort<T extends Comparable<? super T>> extends Sort<T>{

    public void sort(T[] array, boolean order) {
        for (int i = 1; i < array.length; i++) {
                int currentIndex = i;
                if (order){ // Acendente
                    while (currentIndex > 0 && array[currentIndex - 1].compareTo(array[currentIndex]) > 0) {
                        comparations++;
                        T temp = array[currentIndex];
                        array[currentIndex] = array[currentIndex - 1];
                        array[currentIndex - 1] = temp;
                        currentIndex--;
                        swaps++;
                    }
                } else { // Descendente
                    while (currentIndex > 0 && array[currentIndex - 1].compareTo(array[currentIndex]) < 0) {
                        comparations++;
                        T temp = array[currentIndex];
                        array[currentIndex] = array[currentIndex - 1];
                        array[currentIndex - 1] = temp;
                        currentIndex--;
                        swaps++;
                    }
                }
            }
    }
}
