package ua.goit.dev6.command;

public class Developer {
    Integer id;
    String first_name;
    String last_name;
    int age;
    Gender gender;

    public enum Gender{
        male,
        female,
        unknown
    }
}
