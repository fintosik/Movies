import java.util.HashMap;
import java.util.Map;

public class Actors {
    private static Map<Integer, Actor> actorsMap = new HashMap<>();

    public static void addActor(Actor actor){
        actorsMap.put(actor.getId(),actor);
    }
    public static Map<Integer, Actor> getActorsMap(){
        return actorsMap;
    }
    public static Actor getActorById(int id){
        return actorsMap.get(id);
    }
    public static int getActorsCount(){
        return actorsMap.size();
    }
    public static void fillActorsMap(){
        for(int i = 0; i < 10; i++){
            Actors.addActor(new Actor("Actor" + i));
        }
    }
    public static void printActorsMap(){
        actorsMap.forEach((key,value) -> System.out.print(key + " - " + value.getName() + " | "));
        System.out.println();
    }
}
