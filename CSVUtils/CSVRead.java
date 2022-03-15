package CSVUtils;

import com.opencsv.*;

import java.io.*;
import java.io.File;

import Link.LinkList;
import movies.Movie;

public class CSVRead {
    private FileReader archCSV;
    private CSVReader csvReader;
    private LinkList<Movie> moviesList;

    public CSVRead() {
        this.archCSV = null;
        this.csvReader = null;
        this.moviesList = new LinkList<Movie>();
    }

    public LinkList<Movie> getMoviesList() {
        return moviesList;
    }

    public void FileSize() {
        File archivo = new File("Movie.csv");
        long bytes = archivo.length();
        if (bytes == 0) {
            System.out.println("El archivo esta vacio");
        }
    }

    public void Read_Save(int maxSize) {
        try {
            // Leo el archivo con el separador estándar ","
            archCSV = new FileReader("Problema02/Movie.csv");
            csvReader = new CSVReader(archCSV);

            String[] fila = null;
            int index = 0;
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
                moviesList.insertFirst(movie);
            }
        }

        catch (FileNotFoundException e) {
            System.out.println("No se pueden capturar las calificaciones ya que el archivo no fue encontrado");
        } catch (IOException e) {
            System.out.println(e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                    "No se pueden capturar las calificaciones ya que el archivo no tiene las columnas esperadas");
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
