import java.util.*;

public class Movies {
    private static Map<Integer,Movie> moviesMap = new HashMap<>();

    public static void addMovies(Movie movie){
        moviesMap.put(movie.getId(),movie);
    }
    public static Map<Integer,Movie> getMoviesMap(){
        return moviesMap;
    }

    public static Movie getMovieById(int id){
        return moviesMap.get(id);
    }
    public static void printMoviesMap(){ 
        moviesMap.forEach((key,value) -> System.out.print(key + " - " + value.getTitle() + " | "));
        System.out.println();
    }

    public static void fillMoviesMap(){
        for (int i = 0; i < 10; i++) {
            String title = "Title" + i;
            Double raiting = Math.random() * 10;


            Director director = Directors.getDirectorById((int) (Math.random() * Directors.getDirectorsCount()));

            Set<Genre> genresSet = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                genresSet.add(Genres.getGenreById((int) (Math.random() * Genres.getGenresCount())));
            }

            Set<Writer> writersSet = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                writersSet.add(Writers.getWriterById((int) (Math.random() * Writers.getWritersCount())));
            }

            Set<Actor> actorsSet = new HashSet<>();
            for (int j = 0; j < 10; j++) {
                actorsSet.add(Actors.getActorById((int)(Math.random() * Actors.getActorsCount())));
            }


            String description = "Descriprion" + i;

            Movies.addMovies(new Movie(title,raiting,director,genresSet,writersSet,actorsSet,description));
        }
    }
}
