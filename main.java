
import sorting_algorithms.*;

import java.util.Scanner;

import Utils.CSVRead;
import Utils.CSVWrite;
import movies.Movie;
import output.WriteText;

class Main {
	public static void evaluateQuickSort(Movie[] movies, int n, boolean order) {
		long start = System.currentTimeMillis();

		QuickSort<Movie> kuick = new QuickSort<Movie>();
		kuick.sort(movies, 0, n - 1, order);
		kuick.print(movies, n);

		long end = System.currentTimeMillis();
		String metrics = "\nQuickSort\n" +
				"Elapsed Time in milli seconds: " + (end - start) + "\n" +
				"Number of comparations: " + kuick.getComparations() + "\n" +
				"Number of swaps: " + kuick.getSwaps();
		System.out.println(metrics);
		WriteText wr = new WriteText();
		wr.write(metrics);
	}

	public static void evaluateInsertionSort(Movie[] movies, int n, boolean order) {
		long start = System.currentTimeMillis();

		InsertionSort<Movie> isort = new InsertionSort<Movie>();
		isort.sort(movies, order);
		isort.print(movies, n);

		long end = System.currentTimeMillis();
		String metrics = "\nInsertionSort\n" +
				"Elapsed Time in milli seconds: " + (end - start) + "\n" +
				"Number of comparations: " + isort.getComparations() + "\n" +
				"Number of swaps: " + isort.getSwaps();
		System.out.println(metrics);
		WriteText wr = new WriteText();
		wr.write(metrics);
	}

	public static void evaluateRadixSort(Movie[] movies, int n, boolean order) {
		long start = System.currentTimeMillis();

		RadixSort rsort = new RadixSort();
		rsort.sort(movies, n, order);
		rsort.print(movies, n);

		long end = System.currentTimeMillis();
		String metrics = "\nRadixSort\n" +
				"Elapsed Time in milli seconds: " + (end - start) + "\n" +
				"Number of comparations: " + rsort.getComparations() + "\n" +
				"Number of swaps: " + rsort.getSwaps();
		System.out.println(metrics);
		WriteText wr = new WriteText();
		wr.write(metrics);
	}

	/**
	 * 
	 * javac -cp "./lib/opencsv-3.8.jar" main.javacd
	 * /home/teo/workspace/ImplemOrdenamiento ; /usr/bin/env
	 * /usr/lib/jvm/java-8-adoptopenjdk/bin/java -cp
	 * /tmp/cp_5cxmvaes0r7lq0kb2qegcyyfh.jar Main ./output/moviesOrdenadas.txt
	 * ./movies/movie.csv r
	 */
	public static void main(String[] args) {

		// se reciben como argumento desde terminal
		// los paths del archivo de entrada y salida
		CSVRead reader = new CSVRead();
		CSVWrite print = new CSVWrite(args[0]);

		// WARNING: Lee uno menos de lo que se pide xd
		reader.Read_Save(5, args[1]);
		Movie[] movies = reader.getMoviesList();
		int n = movies.length;

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese 1 para ordenamiento ascendente X en caso contrario: ");
		int response = sc.nextInt();
		boolean order;
		order = response == 1 ? true : false;

		System.out.println("Ingrese 1 para ordenamiento por título X por año");
		int criteria = sc.nextInt();
		if (criteria != 1)
			Movie.setYearAsCompareCriteria();

		switch (args[2].charAt(0)) {
			case ('q'):
				evaluateQuickSort(movies, n, order);
				break;
			case ('r'):
				evaluateRadixSort(movies, n, order);
				break;
			case ('i'):
				evaluateInsertionSort(movies, n, order);
				break;
		}

		print.printMovies(movies);
		sc.close();

	}

}