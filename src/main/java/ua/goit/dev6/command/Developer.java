package ua.goit.dev6.command;

public class Developer {
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
}
