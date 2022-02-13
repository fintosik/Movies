import java.util.*;

public class Movie {
    private static int count = 0;
    private int id;
    private String title;
    private double raiting;
    private Director director;
    private Set<Genre> genres;
    private Set<Writer> writers;
    private Set<Actor> actors;
    private String description;

    public Movie(String title, double raiting, Director director, Set<Genre> genres, Set<Writer> writers, Set<Actor> actors, String description) {
        this.id = count;
        count++;
        this.title = title;
        this.raiting = raiting;
        this.director = director;
        this.genres = genres;
        this.writers = writers;
        this.actors = actors;
        this.description = description;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getRaiting() {
        return raiting;
    }

    public Director getDirector() {
        return director;
    }

    public Set<Writer> getWriters() {
        return writers;
    }

    public Set<Actor> getActors() {
        return actors;
    }
    public String getActorsNames(){
        StringBuilder sb = new StringBuilder();
        for (Actor actor : actors) {
            if(sb.toString().equals("")){
                sb.append(actor.getName());
            }else {
                sb.append(", ").append(actor.getName());
            }
        }
        return sb.toString();
    }
    public String getWritersNames(){
        StringBuilder sb = new StringBuilder();
        for (Writer writer : writers) {
            if(sb.toString().equals("")){
                sb.append(writer.getName());
            }else {
                sb.append(", ").append(writer.getName());
            }
        }
        return sb.toString();
    }
    public String getGenresNames() {
        StringBuilder genresNames = new StringBuilder();
        for (Genre genre: genres) {
            if (genresNames.toString().equals("")) {
                genresNames.append(genre.getName());
            } else {
                genresNames.append(", ").append(genre.getName());
            }
        }
        return genresNames.toString();
    }
}
