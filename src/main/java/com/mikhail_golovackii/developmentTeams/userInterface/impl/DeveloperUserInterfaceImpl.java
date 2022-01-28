package com.mikhail_golovackii.developmentTeams.userInterface.impl;

import com.mikhail_golovackii.developmentTeams.controller.DeveloperController;
import com.mikhail_golovackii.developmentTeams.controller.impl.DeveloperControllerImpl;
import com.mikhail_golovackii.developmentTeams.entity.Developer;
import com.mikhail_golovackii.developmentTeams.userInterface.DeveloperUserInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperUserInterfaceImpl implements DeveloperUserInterface {

    private final DeveloperController controller = new DeveloperControllerImpl();
    private Scanner scanner = new Scanner(System.in);
    private String text;

    @Override
    public void create() {
        Developer team = new Developer();

        System.out.println("Create developer:");
        System.out.println("Enter first name:");
        team.setFirstName(scanner.nextLine());
        System.out.println("Enter last name:");
        team.setLastName(scanner.nextLine());

        controller.save(team);
    }

    @Override
    public void updateById() {
        Developer developer = new Developer();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id developer: ");

        if (scanner.hasNextInt()) {
            developer.setId(scanner.nextInt());

            System.out.println("Enter first name:");
            text = sc.nextLine();
            developer.setFirstName(text);

            System.out.println("Enter last name:");
            text = sc.nextLine();
            developer.setLastName(text);

            controller.updateById(developer);
            return;
        }
        System.out.println("Error. Write number!");
    }

    @Override
    public void showById() {
        System.out.println("Enter id developer: ");

        if (scanner.hasNextInt()) {
            controller.getById(scanner.nextInt());
            return;
        }
        System.out.println("Error. Write number!");
    }

    @Override
    public void showAll() {
        controller.getAll();
    }

    @Override
    public void deleteById() {
        System.out.println("Enter id developer: ");

        if (scanner.hasNextInt()) {
            controller.deleteById(scanner.nextInt());
            return;
        }
        System.out.println("Error. Write number!");
    }

    @Override
    public void addSkillToDeveloper() {
        System.out.println("Enter id developer:");
        text = scanner.next();
        int idDeveloper;
        if (text.matches("\\d+")) {
            idDeveloper = Integer.parseInt(text);
        } else {
            return;
        }

        System.out.println("Enter id skill. Enter exit to stop");
        List<Integer> idSkills = new ArrayList<>();

        while (true) {
            text = scanner.next();

            if (text.equalsIgnoreCase("exit")) {
                break;
            }

            if (text.matches("\\d+")) {
                idSkills.add(Integer.parseInt(text));
            }
        }

        if (idSkills.isEmpty()) {
            return;
        }

        controller.addSkillToDeveloper(idDeveloper, idSkills);
    }

    @Override
    public void deleteSkillFromDeveloper() {
        System.out.println("Enter id developer:");
        text = scanner.next();
        int idDeveloper;
        if (text.matches("\\d+")) {
            idDeveloper = Integer.parseInt(text);
        } else {
            return;
        }

        System.out.println("Enter id skill. Enter exit to stop");
        List<Integer> idSkills = new ArrayList<>();

        while (true) {
            text = scanner.next();

            if (text.equalsIgnoreCase("exit")) {
                break;
            }

            if (text.matches("\\d+")) {
                idSkills.add(Integer.parseInt(text));
            }
        }

        if (idSkills.isEmpty()) {
            return;
        }

        controller.deleteSkillFromDeveloper(idDeveloper, idSkills);
    }
}
