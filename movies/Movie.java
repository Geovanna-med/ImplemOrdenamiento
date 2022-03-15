package movies;

/**
 * Movie
 */
public class Movie implements Comparable<Movie> {
    private int id; 
    private String title;
    private String duration;
    private String color;
    private String country;
    private String language;
    private String contentRating;
    private String budget;
    private int titleYear;
    private String IMDBScore;
    private String aspectRatio;
    private String movieIMDBLink;

    public Movie(int id, String title, String duration, String color, String country, String language,
            String contentRating, String budget, int titleYear, String iMDBScore, String aspectRatio,
            String movieIMDBLink) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.color = color;
        this.country = country;
        this.language = language;
        this.contentRating = contentRating;
        this.budget = budget;
        this.titleYear = titleYear;
        IMDBScore = iMDBScore;
        this.aspectRatio = aspectRatio;
        this.movieIMDBLink = movieIMDBLink;
    }

    @Override
    public String toString() {
        return "" + IMDBScore + "," + aspectRatio + "," + budget + ","
                + color + "," + contentRating + "," + country + "," + duration
                + "," + id + "," + language + "," + movieIMDBLink + "," + title
                + "," + titleYear;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        if (budget == null) {
            if (other.budget != null)
                return false;
        } else if (!budget.equals(other.budget))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (duration == null) {
            if (other.duration != null)
                return false;
        } else if (!duration.equals(other.duration))
            return false;
        if (language == null) {
            if (other.language != null)
                return false;
        } else if (!language.equals(other.language))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (titleYear != other.titleYear)
            return false;
        return true;
    }

    @Override
    public int compareTo(Movie o) {
        if (o.getTitleYear() > this.getTitleYear())
            return -1;
        else if (o.getTitleYear() == this.getTitleYear())
            return 0;
        return -1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public int getTitleYear() {
        return titleYear;
    }

    public void setTitleYear(int titleYear) {
        this.titleYear = titleYear;
    }

    public String getIMDBScore() {
        return IMDBScore;
    }

    public void setIMDBScore(String iMDBScore) {
        IMDBScore = iMDBScore;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public String getMovieIMDBLink() {
        return movieIMDBLink;
    }

    public void setMovieIMDBLink(String movieIMDBLink) {
        this.movieIMDBLink = movieIMDBLink;
    }

    
}