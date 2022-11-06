package ua.goit.dev6.controller;

import ua.goit.dev6.command.Command;
import ua.goit.dev6.exeptions.ExitException;
import ua.goit.dev6.view.View;
import java.util.List;

public class ProjectManagementSystem {
    private final View view;
    private final List<Command> commands;

    public ProjectManagementSystem(View view, List<Command> commands) {
        this.view = view;
        this.commands = commands;
    }
    public void run() {
        view.write("Hello, please enter help to see all commands");
        try {
            execute();
        } catch (ExitException e) {}
    }
    private void execute() {
        while (true) {
            String input = view.read();
            boolean isInputCorrect = false;
            for (Command command : commands) {
                if (command.canExecute(input)) {
                    command.execute(input);
                    isInputCorrect = true;
                }
            }
            if (!isInputCorrect) {
                view.write("Command not found. Please enter help to see all commands");
            }
        }
    }
}
