import java.util.HashMap;
import java.util.Map;

public class Genres {
    private static Map<Integer,Genre> genresMap = new HashMap<>();

    public static void addGenre(Genre genre){
        genresMap.put(genre.getId(),genre);
    }
    public static Map<Integer,Genre> getGenresMap(){
        return genresMap;
    }
    public static int getGenresCount(){
        return genresMap.size();
    }
    public static Genre getGenreById(int id){
        return genresMap.get(id);
    }
    public static void fillGenresMap(){
        for (int i = 0; i < 5; i++) {
            addGenre(new Genre("Genre" + i));
        }
    }
    public static void printGenresMap(){
        genresMap.forEach((key,value) -> System.out.print(key + " - " + value.getName() + " | "));
        System.out.println();
    }
}
