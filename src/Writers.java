import java.util.HashMap;
import java.util.Map;

public class Writers {
    private static Map<Integer, Writer> writersMap = new HashMap<>();

    public static void addWriter(Writer writer){
        writersMap.put(writer.getId(),writer);
    }
    public static Map<Integer,Writer> getWritersMap(){
        return writersMap;
    }
    public static Writer getWriterById(int id){
        return writersMap.get(id);
    }
    public static int getWritersCount(){
        return writersMap.size();
    }
    public static void fillWritersMap(){
        for(int i = 0; i < 5; i++){
            addWriter(new Writer("Writer" + i));
        }
    }
    public static void printWriters(){
        writersMap.forEach((key,value) -> System.out.print(key + " - " + value.getName() + " | "));
        System.out.println();
    }
}
