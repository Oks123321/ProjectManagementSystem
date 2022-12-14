package ua.goit.dev6.command;

import ua.goit.dev6.model.SkillLevel;
import ua.goit.dev6.model.dto.SkillDto;
import ua.goit.dev6.service.SkillService;
import ua.goit.dev6.view.View;

public class SkillCommands implements Command {
    private static final String SKILL_COMMANDS = "skill";
    private final View view;
    private final SkillService skillService;

    public SkillCommands(View view, SkillService skillService) {
        this.view = view;
        this.skillService = skillService;
    }
    @Override
    public boolean canExecute(String input) {
        return input.split(" ")[0].equals(SKILL_COMMANDS);
    }

    @Override
    public void execute(String input) {
        String[] args = input.split(" ");
        try {
            switch (args[1]) {
                case "-c" -> create(args);
                case "-r" -> read(args);
                case "-u" -> update(args);
                case "-d" -> delete(args);
            }
        } catch (RuntimeException e) {
            view.write("parameters incorrect");
        }
     }

    private void create(String[] args) {
        SkillDto skillDto = new SkillDto();
        skillDto.setLanguage(args[2]);
        skillDto.setLevel(SkillLevel.valueOf(args[3]));
        skillService.create(skillDto);
        view.write("Skill created");
    }

    private void read(String[] args) {
        if (args.length==3) {
            skillService.findById(Long.valueOf(args[2]))
                    .ifPresentOrElse((value) -> view.write(String.valueOf(value)),
                            () -> view.write("Don`t find skill"));
        } else {
            skillService.fyndAll()
                    .forEach((value) -> view.write(value.toString()));
        }
    }

    private void update(String[] args) {
        SkillDto skillDto = new SkillDto();
        skillDto.setId(Long.valueOf(args[2]));
        skillDto.setLanguage(args[3]);
        skillDto.setLevel(SkillLevel.valueOf(args[4]));
        skillService.update(skillDto);
        view.write("Skill updated");
    }

    private void delete(String[] args) {
        SkillDto skillDto = skillService.findById(Long.valueOf(args[2])).orElseThrow(RuntimeException::new);
        skillService.delete(skillDto);
        view.write("Skill deleted");
    }
}
