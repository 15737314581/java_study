package cn.itcast.day04.demo12;

import org.omg.CORBA.OBJ_ADAPTER;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }else if (obj == this) {
            return true;
        }else if (obj instanceof Person) {
            Person p = (Person)obj;
            boolean b = this.name == p.name && this.age == p.age;
            return b;
        }else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
