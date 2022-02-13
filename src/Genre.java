public class Genre {
    private static int count = 0;
    private int id;
    private String name;

    public Genre(String name) {
        this.id = count;
        count++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
