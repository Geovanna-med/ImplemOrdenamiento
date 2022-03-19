
import sorting_algorithms.*;
import Utils.CSVRead;
import Utils.CSVWrite;
import movies.Movie;
import output.WriteText;

class Main {
	public static void evaluateQuickSort(Movie[] movies, int n){
		long start = System.currentTimeMillis();

		QuickSort<Movie> kuick = new QuickSort<Movie>();
		kuick.sort(movies, 0, n - 1, true);
		kuick.print(movies, n);

		long end = System.currentTimeMillis();
		String metrics = 
				"\nQuickSort\n" + 
				"Elapsed Time in milli seconds: " + (end - start) + "\n" +
				"Number of comparations: " + kuick.getComparations() + "\n" +
				"Number of swaps: " + kuick.getSwaps();
		System.out.println(metrics);
		WriteText wr = new WriteText();
		wr.write(metrics);
	}

	public static void evaluateInsertionSort(Movie[] movies, int n){
		long start = System.currentTimeMillis();

		InsertionSort<Movie> isort = new InsertionSort<Movie>();
		isort.sort(movies, false);
		isort.print(movies, n);

		long end = System.currentTimeMillis();
		String metrics = 
				"\nInsertionSort\n" +
				"Elapsed Time in milli seconds: " + (end - start) + "\n" +
				"Number of comparations: " + isort.getComparations() + "\n" +
				"Number of swaps: " + isort.getSwaps();
		System.out.println(metrics);
		WriteText wr = new WriteText();
		wr.write(metrics);
	}

	public static void evaluateRadixSort(Movie[] movies, int n){
		long start = System.currentTimeMillis();

		RadixSort rsort = new RadixSort();
		rsort.sort(movies, n, false);
		rsort.print(movies, n);

		long end = System.currentTimeMillis();
		String metrics = 
				"\nRadixSort\n" +
				"Elapsed Time in milli seconds: " + (end - start) + "\n" +
				"Number of comparations: " + rsort.getComparations() + "\n" +
				"Number of swaps: " + rsort.getSwaps();
		System.out.println(metrics);
		WriteText wr = new WriteText();
		wr.write(metrics);
	}

	public static void main(String[] args) {

		// se reciben como argumento desde terminal
		// los paths del archivo de entrada y salida
		CSVRead reader = new CSVRead();
		CSVWrite print = new CSVWrite(args[0]);

		//WARNING: Lee uno menos de lo que se pide xd
		reader.Read_Save(5, args[1]);
		Movie[] movies = reader.getMoviesList();
		int n = movies.length;

		switch (args[2].charAt(0)) {
			case('q'):
				evaluateQuickSort(movies, n);
				break;
			case('r'):
				evaluateRadixSort(movies, n);
				break;
			case('i'):
				evaluateInsertionSort(movies, n);
				break;
		}

		print.printMovies(movies);

	}

}