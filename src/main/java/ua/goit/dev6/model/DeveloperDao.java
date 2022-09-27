package ua.goit.dev6.model;

import ua.goit.dev6.command.Developer;

public class DeveloperDao {
    long id;
    String first_name;
    String last_name;
    int age;
    Gender gender;

    public enum Gender{
        male,
        female,
        unknown
    }

    public DeveloperDao(long id, String first_name, String last_name, int age, Gender gender) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.gender = gender;
    }

    public DeveloperDao(String first_name, String last_name, int age, Gender gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.gender = gender;
    }

    public DeveloperDao() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
