package Classes;

public class Toy implements Comparable<Toy>{
    private final int id;
    private final String name;
    private final int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "" + id + " " + weight + " " + name;
//                "Toy{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", weight=" + weight +
//                '}';
    }

    @Override
    public int compareTo(Toy o) {
        return this.id - o.id;
    }
}
