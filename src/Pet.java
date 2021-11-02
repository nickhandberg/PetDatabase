// Simple pet class that has name and age instance variables.
public class Pet {
    private String name;
    private int age;

    // Class constructor for initializing the instance
    public Pet(String name, int age){
        this.name = name;
        this.age = age;
    }

    // GETTERS / SETTERS
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
