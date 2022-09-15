package ua.goit.dev6.model;

import ua.goit.dev6.command.Developer;

public class DeveloperDao {
    Integer id;
    String first_name;
    String last_name;
    int age;
    Developer.Gender gender;

    public enum Gender{
        male,
        female,
        unknown
    }

    public DeveloperDao(Integer id, String first_name, String last_name, int age, Developer.Gender gender) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.gender = gender;
    }

    public DeveloperDao(String first_name, String last_name, int age, Developer.Gender gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.gender = gender;
    }

    public DeveloperDao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Developer.Gender getGender() {
        return gender;
    }

    public void setGender(Developer.Gender gender) {
        this.gender = gender;
    }
}
