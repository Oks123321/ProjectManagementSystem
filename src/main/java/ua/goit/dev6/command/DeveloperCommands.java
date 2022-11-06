package ua.goit.dev6.command;

import ua.goit.dev6.model.SkillLevel;
import ua.goit.dev6.model.dto.DeveloperDto;
import ua.goit.dev6.service.DeveloperService;
import ua.goit.dev6.view.View;
import java.util.List;

public class DeveloperCommands implements Command {
    private static final String DEVELOPER_COMMANDS = "developer";
    private final View view;
    private final DeveloperService developerService;

    public DeveloperCommands(View view, DeveloperService developerService) {
        this.view = view;
        this.developerService = developerService;
    }
    @Override
    public boolean canExecute(String input) {
        return input.split(" ")[0].equals(DEVELOPER_COMMANDS);
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
                case "-as" -> addSkillToDeveloper(args);
                case "-ds" -> deleteSkillFromDeveloper(args);
                case "-fAp" -> findAllDevelopersByProject(args);
                case "-fAlg" -> findAllDevelopersBySkillLanguage(args);
                case "-fAlv" -> findAllDeveloperBySkillLevel(args);
            }
        } catch (RuntimeException e) {
            view.write("parameters incorrect");
        }
    }
    private void create(String[] args) {
        DeveloperDto developerDto = new DeveloperDto();
        developerDto.setFirst_name(args[2]);
        developerDto.setLast_name(args[3]);
        developerDto.setAge(Integer.parseInt(args[4]));
        developerDto.setSalary(Integer.parseInt(args[5]));
        developerService.create(developerDto);
        view.write("Developer created");
    }

    private void read(String[] args) {
        if (args.length==3) {
            developerService.findById(Long.valueOf(args[2]))
                    .ifPresentOrElse((value) -> view.write(String.valueOf(value)),
                            () -> view.write("Don`t find developer"));
        } else {
            developerService.findAll()
                    .forEach((value) -> view.write(value.toString()));
        }
    }
    private void update(String[] args) {
        DeveloperDto developerDto = new DeveloperDto();
        developerDto.setId(Long.valueOf(args[2]));
        developerDto.setFirst_name(args[3]);
        developerDto.setLast_name(args[4]);
        developerDto.setAge(Integer.valueOf(args[5]));
        developerDto.setSalary(Integer.valueOf(args[6]));
        developerService.update(developerDto);
        view.write("Developer updated");
    }

    private void delete(String[] args) {
        DeveloperDto developerDto = developerService.findById(Long.valueOf(args[2])).orElseThrow(RuntimeException::new);
        developerService.delete(developerDto);
        view.write("Developer deleted");
    }
    private void addSkillToDeveloper(String[] args){
        Long developerId = Long.valueOf(args[2]);
        Long skillId = Long.valueOf(args[3]);
        developerService.addSkill(developerId, skillId);
        view.write("Skill to developer added");
    }
    private void deleteSkillFromDeveloper(String[] args){
        Long developerId = Long.valueOf(args[2]);
        Long skillId = Long.valueOf(args[3]);
        developerService.deleteSkill(developerId, skillId);
        view.write("Skill from developer deleted");
    }
    private void findAllDevelopersByProject(String[] args){
        List<DeveloperDto> developerDtoList = developerService.findByProjectId(Long.valueOf(args[2]));
        for (DeveloperDto dto: developerDtoList
             ) {
            System.out.println(dto);
        }
    }
    private void findAllDevelopersBySkillLanguage(String[] args){
        List<DeveloperDto> developerDtoList = developerService.findBySkillLanguage(args[2]);
        for (DeveloperDto dto: developerDtoList
        ) {
            System.out.println(dto);
        }
    }
    private void findAllDeveloperBySkillLevel(String[] args){
        List<DeveloperDto> developerDtoList = developerService.findBySkillLevel(SkillLevel.valueOf(args[2]));
        for (DeveloperDto dto: developerDtoList
        ) {
            System.out.println(dto);
        }
    }
}
