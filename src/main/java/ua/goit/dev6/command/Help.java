package ua.goit.dev6.command;

import ua.goit.dev6.view.View;
public class Help implements Command{
    private static final String HELP = "help";
    private final View view;

    public Help(View view) {
        this.view = view;
    }

    @Override
    public boolean canExecute(String input) {
        return input.equals(HELP);
    }

    @Override
    public void execute(String input) {
        view.write("Enter: 'developer -c first_name last_name age salary' to create developer");
        view.write("Enter: 'developer -r id' to read developer");
        view.write("Enter: 'developer -r' to read all developers");
        view.write("Enter: 'developer -u id first_name last_name age salary' to update developer");
        view.write("Enter: 'developer -d id' to delete developer");

        view.write("Enter: 'developer -as developersId skillsId' to add skill to developer");
        view.write("Enter: 'developer -ds developersId skillsId' to delete skill from developer");
        view.write("Enter: 'developer -fAp projectsId' to get all developers in the project");
        view.write("Enter: 'developer -fAlg SkillLanguage' to get all developers with language");
        view.write("Enter: 'developer -fAlv SkillLevel' to get all developers with level \n");

        view.write("Enter: 'project -c name descriptions cost date' to create project");
        view.write("Enter: 'project -d id' to delete project");
        view.write("Enter: 'project -u id name descriptions cost date' to update project");
        view.write("Enter: 'project -r id' to read project");
        view.write("Enter: 'project -r' to read all project");
        view.write("Enter: 'project -ad projectsId developersId' to add developer to project");
        view.write("Enter: 'project -dd projectsId developersId' to delete developer from project");
        view.write("Enter: 'project -fa' to get all project with count of developers \n");

        view.write("Enter: 'skill -c  language level' to create skill");
        view.write("Enter: 'skill -d id' to delete skill");
        view.write("Enter: 'skill -u id language level' to update skill");
        view.write("Enter: 'skill -r id' to read skill");
        view.write("Enter: 'skill -r' to read all skill \n");

        view.write("Enter: 'company -c name country' to create company");
        view.write("Enter: 'company -r id' to read company with id");
        view.write("Enter: 'company -r' to read all companies");
        view.write("Enter: 'company -u id name country' to update company");
        view.write("Enter: 'company -d id' to delete company \n");

        view.write("Enter: 'customer -c name descriptions' to create customer");
        view.write("Enter: 'customer -r id' to read customer");
        view.write("Enter: 'customer -r' to read all customers");
        view.write("Enter: 'customer -u id name descriptions' to update customer");
        view.write("Enter: 'customer -d id' to delete customer \n");

        view.write("Enter: 'util -s projectsId' to get total salary by project \n");

        view.write(String.format("Enter %s to exit program", Exit.EXIT));
    }
}
