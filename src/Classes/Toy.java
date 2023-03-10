package Classes;

public class Toy implements Comparable<Toy>{
    private final int id;
    private final String name;
    private int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() { return weight; }

    public int getId() { return id; }

    public void getToy() { this.weight--; }

    @Override
    public String toString() {
        return "" + id + " " + weight + " " + name;
    }

    public String howMuch() {
        return "Общее количество " + this.name + " равно " + this.weight + "\n";
    }

    @Override
    public int compareTo(Toy o) {
        return this.id - o.id;
    }
}
