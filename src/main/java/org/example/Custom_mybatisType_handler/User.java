package org.example.Custom_mybatisType_handler;

/**
 * @author Kazamine_Setueka
 */
public class User {
    private int id;
    private Name name;
    private int age;

    public void User(int id, Name name, int age){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
