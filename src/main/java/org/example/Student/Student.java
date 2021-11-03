package org.example.Student;

public class Student {
    private int ID;
    private String Name;
    private int Age;

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "输出学生得相关信息" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Age=" + Age;
    }
}
