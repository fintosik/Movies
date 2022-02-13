public class Writer {
    private static int count = 0;
    private int id;
    private String name;

    public Writer(String name) {
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
        return "Writer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
