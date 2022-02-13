import java.util.HashMap;
import java.util.Map;

public class Directors {
    private static Map<Integer,Director> directorsMap = new HashMap<>();

    public static void addDirector(Director director){
        directorsMap.put(director.getId(),director);
    }

    public static Map<Integer, Director> getDirectorsMap(){
        return directorsMap;
    }
    public static Director getDirectorById(int id){
        return directorsMap.get(id);
    }

    public static void fillDirectorsMap(){
        for (int i = 0; i < 5; i++) {
            Directors.addDirector(new Director("Director" + i));
        }
    }
    public static void printDirectorsMap(){
        directorsMap.forEach((key,value) -> System.out.print(key + " - " + value.getName() + " | "));
        System.out.println();
    }
    public static int getDirectorsCount(){
        return directorsMap.size();
    }

}
