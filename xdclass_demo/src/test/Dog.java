package test;

public class Dog {
    public Dog(){

    }

    public static int age = 10;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void changeAge(){
        age++;
    }

    public int getAge(){
        return age;
    }
}
