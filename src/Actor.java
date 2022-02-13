public class Actor {
    private static int count = 0;
    private int id;
    private String name;

    public Actor(String name) {
        this.name = name;
        this.id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

