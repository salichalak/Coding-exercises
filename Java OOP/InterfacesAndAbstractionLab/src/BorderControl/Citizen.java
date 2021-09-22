package BorderControl;

public class Citizen implements Identifiable{
    private String id;
    private int age;
    private String name;

    public Citizen(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}