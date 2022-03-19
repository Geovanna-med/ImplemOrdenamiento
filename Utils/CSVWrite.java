package Utils;

import java.io.File;
import java.io.FileWriter;

import movies.Movie;


public class CSVWrite {

    // private LinkList<Movie> moviesFinalList;
    private File file;

    public CSVWrite(String path){
        this.file = new File(path);
    }

    public void printMovies(Movie[] movies) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(
                    "movie_id, movie_title, duration, color, language, country, content_rating, budget, title_year, imdb_score, aspect_ratio, movie_imdb_link\n");

            for(int i = 0; i < movies.length; i++) {
                Movie movie = movies[i];
                fw.write(movie.toString() + "\n");
            }

            fw.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
