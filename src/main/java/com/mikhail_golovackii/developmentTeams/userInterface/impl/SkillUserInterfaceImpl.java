package com.mikhail_golovackii.developmentTeams.userInterface.impl;

import com.mikhail_golovackii.developmentTeams.controller.SkillController;
import com.mikhail_golovackii.developmentTeams.controller.impl.SkillControllerImpl;
import com.mikhail_golovackii.developmentTeams.entity.Skill;
import com.mikhail_golovackii.developmentTeams.userInterface.SkillUserInterface;
import java.util.Scanner;

public class SkillUserInterfaceImpl implements SkillUserInterface {

    private final SkillController controller = new SkillControllerImpl();
    private final Scanner scanner = new Scanner(System.in);
    private String text;

    @Override
    public void create() {
        System.out.println("Create skill:");
        System.out.println("Enter name skill: ");

        text = scanner.nextLine();
        Skill skill = new Skill(text);

        controller.save(skill);
    }

    @Override
    public void updateById() {
        System.out.println("Update skill:");
        System.out.println("Enter id skill: ");

        if (scanner.hasNextInt()) {
            Skill skill = new Skill();
            skill.setId(scanner.nextInt());

            System.out.println("Enter name skill:");
            text = scanner.nextLine();
            skill.setName(text);

            controller.updateById(skill);
            return;
        }
        System.out.println("Error. Write number!");
    }

    @Override
    public void showById() {
        System.out.println("Enter id skill: ");
        
        if (scanner.hasNextInt()){
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
        System.out.println("Write id skill: ");
        
        if (scanner.hasNextInt()){
            controller.deleteById(scanner.nextInt());
            return;
        }
        System.out.println("Error. Write number!");
    }

}
