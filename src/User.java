public abstract class User {
    private int id;
    private String name;
    private static int nextId = 1;  // static counter for unique IDs

    public User(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // (Optional abstract method)
    public abstract String getRole();

    @Override
    public String toString() {
        return getRole() + "[ID=" + id + ", Name=" + name + "]";
    }
}