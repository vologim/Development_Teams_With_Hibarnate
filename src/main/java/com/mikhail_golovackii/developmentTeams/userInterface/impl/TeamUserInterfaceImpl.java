package com.mikhail_golovackii.developmentTeams.userInterface.impl;

import com.mikhail_golovackii.developmentTeams.controller.TeamController;
import com.mikhail_golovackii.developmentTeams.controller.impl.TeamControllerImpl;
import com.mikhail_golovackii.developmentTeams.entity.Team;
import com.mikhail_golovackii.developmentTeams.userInterface.TeamUserInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamUserInterfaceImpl implements TeamUserInterface {

    private final TeamController controller = new TeamControllerImpl();
    private final Scanner scanner = new Scanner(System.in);
    private String text;

    @Override
    public void create() {
        Team team = new Team();
        
        System.out.println("Create team:");
        System.out.println("Enter name team: ");
        text = scanner.nextLine();
        team.setName(text);
        
        controller.save(team);
    }

    @Override
    public void updateById() {
        Team team = new Team();
        
        System.out.println("Enter id team: ");
        
        if (scanner.hasNextInt()){
            team.setId(scanner.nextInt());
            
            System.out.println("Enter name team: ");
            team.setName(scanner.nextLine());

            controller.updateById(team.getId(), team);
            return;
        }
        System.out.println("Error. Write number!");
    }

    @Override
    public void showById() {
        System.out.println("Enter id team:");
        
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
        System.out.println("Write id team: ");
        
        if (scanner.hasNextInt()){
            controller.deleteById(scanner.nextInt());
            return;
        }
        System.out.println("Error. Write number!");
    }

    @Override
    public void addDeveloperToTeam() {
        System.out.println("Enter id team:");
        text = scanner.next();
        int idTeam;
        if (text.matches("\\d+")) {
            idTeam = Integer.parseInt(text);
        }
        else {
            return;
        }
        
        System.out.println("Enter id developer. Enter exit to stop");
        List<Integer> idDevelopers = new ArrayList<>();
        
        while (true) {
            text = scanner.next();
            
            if (text.equalsIgnoreCase("exit")) {
                break;
            }
            
            if (text.matches("\\d+")) {
                idDevelopers.add(Integer.parseInt(text));
            }
        }
        
        if (idDevelopers.isEmpty()) {
            return;
        }
        
        controller.addDeveloperToTeam(idTeam, idDevelopers);
    }

    @Override
    public void deleteDeveloperFromTeam() {
        System.out.println("Enter id team:");
        text = scanner.next();
        int idTeam;
        if (text.matches("\\d+")) {
            idTeam = Integer.parseInt(text);
        }
        else {
            return;
        }
        
        System.out.println("Enter id developer. Enter exit to stop");
        List<Integer> idDevelopers = new ArrayList<>();
        
        while (true) {
            text = scanner.next();
            
            if (text.equalsIgnoreCase("exit")) {
                break;
            }
            
            if (text.matches("\\d+")) {
                idDevelopers.add(Integer.parseInt(text));
            }
        }
        
        if (idDevelopers.isEmpty()) {
            return;
        }
        
        controller.deleteDeveloperFromTeam(idTeam, idDevelopers);
    }
}
