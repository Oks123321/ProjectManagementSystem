package ua.goit.dev6.command;

import ua.goit.dev6.model.dto.ProjectDto;
import ua.goit.dev6.service.DeveloperService;
import ua.goit.dev6.service.ProjectService;
import ua.goit.dev6.view.View;
import java.util.List;

public class ProjectCommands implements Command {
    private static final String PROJECT_COMMANDS = "project";
    private final View view;
    private final ProjectService projectService;
    private final DeveloperService developerService;

    public ProjectCommands(View view, ProjectService projectService, DeveloperService developerService) {
        this.view = view;
        this.projectService = projectService;
        this.developerService = developerService;
    }

    @Override
    public boolean canExecute(String input) {
        return input.split(" ")[0].equals(PROJECT_COMMANDS);
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
                case "-ad" -> addDeveloperToProject(args);
                case "-dd" -> deleteDeveloperFromProject(args);
                case "-fa" -> findAllWithCountOfDeveloper();
            }
        } catch (RuntimeException e) {
            view.write("parameters incorrect");
        }
    }
    private void create(String[] args) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName(args[2]);
        projectDto.setDescriptions(args[3]);
        projectDto.setCost(Integer.parseInt(args[4]));
        projectDto.setDate(args[5]);
        projectService.create(projectDto);
        view.write("Project created");
    }

    private void read(String[] args) {
        if (args.length == 3) {
            projectService.findById(Long.valueOf(args[2]))
                    .ifPresentOrElse((value) -> view.write(String.valueOf(value)),
                            () -> view.write("Don`t find project"));
        } else {
            projectService.findAll()
                    .forEach((value) -> view.write(value.toString()));
        }
    }

    private void update(String[] args) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(Long.valueOf(args[2]));
        projectDto.setName(args[3]);
        projectDto.setDescriptions(args[4]);
        projectDto.setCost(Integer.parseInt(args[5]));
        projectDto.setDate(args[6]);
        projectService.update(projectDto);
        view.write("Project updated");
    }

    private void delete(String[] args) {
        ProjectDto projectDto = projectService.findById(Long.valueOf(args[2])).orElseThrow(RuntimeException::new);
        projectService.delete(projectDto);
        view.write("Project deleted");
    }

    private void addDeveloperToProject(String[] args) {
        Long projectId = Long.valueOf(args[2]);
        Long developerId = Long.valueOf(args[3]);
        projectService.addDeveloperToProject(projectId, developerId);
        view.write("Developer to project added");
    }

    private void deleteDeveloperFromProject(String[] args) {
        Long projectId = Long.valueOf(args[2]);
        Long developerId = Long.valueOf(args[3]);
        projectService.deleteDeveloperFromProject(projectId, developerId);
        view.write("Developer from project deleted");
    }

    private void findAllWithCountOfDeveloper() {
        List<ProjectDto> projectDtoList = projectService.findAll();
        for (ProjectDto dto : projectDtoList
        ) {
            int count = developerService.findByProjectId(dto.getId()).size();
            view.write(dto + ", developerCount=" + count);
        }
    }
}
