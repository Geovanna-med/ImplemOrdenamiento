package Utils;

import com.opencsv.*;

import java.io.*;
import java.io.File;

import movies.Movie;

public class CSVRead {
    private FileReader archCSV;
    private CSVReader csvReader;
    private Movie[] moviesList;

    public CSVRead() {
        this.archCSV = null;
        this.csvReader = null;
    }

    public Movie[] getMoviesList() {
        return moviesList;
    }

    public void FileSize() {
        File archivo = new File("Movie.csv");
        long bytes = archivo.length();
        if (bytes == 0) {
            System.out.println("El archivo esta vacio");
        }
    }

    public void Read_Save(int maxSize, String path) {
        try {
            // Leo el archivo con el separador estándar ","
            archCSV = new FileReader(path);
            csvReader = new CSVReader(archCSV);

            maxSize = maxSize-1;
            moviesList = new Movie[maxSize];
            String[] fila = null;
            int index = -1;
            boolean first = true;
            while ((fila = csvReader.readNext()) != null) {
                if (first) {
                    first = false;
                    continue;
                }

                if (index >= maxSize)
                    break;
                index++;

                Movie movie = new Movie(
                        Integer.parseInt(fila[0])
                        , fila[1]
                        , fila[2]
                        , fila[3]
                        , fila[4]
                        , fila[5]
                        , fila[6]
                        , fila[7]
                        , Integer.parseInt(fila[8])
                        , fila[9]
                        , fila[10]
                        , fila[11]);
                moviesList[index] = movie;
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("Archivo no fue encontrado");
        } catch (IOException e) {
            System.out.println(e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                    "El archivo no tiene las columnas esperadas");
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            try {
                archCSV.close();
                csvReader.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}
