package ua.goit.dev6.command;

public interface Command {
    boolean canExecute(String input);
    void execute(String input);
}
