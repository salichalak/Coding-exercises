package Animals;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat("Oscar","Whiskas");
        System.out.println(cat.explainSelf());

        Animal dog = new Dog("Rocky","Meat");
        System.out.println(dog.explainSelf());
    }
}