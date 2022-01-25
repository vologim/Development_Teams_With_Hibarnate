
package com.mikhail_golovackii.developmentTeams;

import com.mikhail_golovackii.developmentTeams.userInterface.DeveloperUserInterface;
import com.mikhail_golovackii.developmentTeams.userInterface.SkillUserInterface;
import com.mikhail_golovackii.developmentTeams.userInterface.TeamUserInterface;
import com.mikhail_golovackii.developmentTeams.userInterface.impl.DeveloperUserInterfaceImpl;
import com.mikhail_golovackii.developmentTeams.userInterface.impl.SkillUserInterfaceImpl;
import com.mikhail_golovackii.developmentTeams.userInterface.impl.TeamUserInterfaceImpl;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        
        final DeveloperUserInterface developerInterface = new DeveloperUserInterfaceImpl();
        final SkillUserInterface skillInterface = new SkillUserInterfaceImpl();
        final TeamUserInterface teamInterface = new TeamUserInterfaceImpl();
        
        Scanner scanner = new Scanner(System.in);
        String check;
        
        while (true){
            System.out.println("Enter:");
            System.out.println("1: create: developer, skill or team");
            System.out.println("2: show: developer, skill or team");
            System.out.println("3: update: developer, skill or team");
            System.out.println("4: delete: developer, skill or team");
            System.out.println("exit: exit the application");
            
            System.out.println("input: ");
            check = scanner.nextLine();
            
            switch (check.toLowerCase()){
                case "1":
                    System.out.println("Create:");
                    System.out.println("1: developer");
                    System.out.println("2: skill");
                    System.out.println("3: team");
                    System.out.println("enter any value to exit");
                    
                    System.out.println("input: ");
                    check = scanner.nextLine();
                        
                    switch (check.toLowerCase()){
                        case "1":
                            developerInterface.create();
                            break;
                        case "2":
                            skillInterface.create();
                            break;
                        case "3":
                            teamInterface.create();
                            break;
                        default:    
                    }
                    break;
                case "2":
                    System.out.println("Show:");
                    System.out.println("1: developer");
                    System.out.println("2: skill");
                    System.out.println("3: team");
                    System.out.println("4: all developers");
                    System.out.println("5: all skills");
                    System.out.println("6: all teams");
                    System.out.println("enter any value to exit");
                    
                    System.out.println("input: ");
                    check = scanner.nextLine();
                        
                    switch (check.toLowerCase()){
                        case "1":
                            developerInterface.showById();
                            break;
                        case "2":
                            skillInterface.showById();
                            break;
                        case "3":
                            teamInterface.showById();
                            break;
                        case "4":
                            developerInterface.showAll();
                            break;
                        case "5":
                            skillInterface.showAll();
                            break;
                        case "6":
                            teamInterface.showAll();
                            break; 
                    }
                    break;
                case "3":
                    System.out.println("Update:");
                    System.out.println("1: developer");
                    System.out.println("2: skill");
                    System.out.println("3: team");
                    System.out.println("4: add skills to developer");
                    System.out.println("5: remove developer skill");
                    System.out.println("6: add developers to team");
                    System.out.println("7: remove developer from team");
                    System.out.println("enter any value to exit");
                    
                    System.out.println("input: ");
                    check = scanner.nextLine();
                        
                    switch (check.toLowerCase()){
                        case "1":
                            developerInterface.updateById();
                            break;
                        case "2":
                            skillInterface.updateById();
                            break;
                        case "3":
                            teamInterface.updateById();
                            break;  
                        case "4":
                            developerInterface.addSkillToDeveloper();
                            break;
                        case "5":
                            developerInterface.deleteSkillFromDeveloper();
                            break;
                        case "6":
                            teamInterface.addDeveloperToTeam();
                            break;
                        case "7":
                            teamInterface.deleteDeveloperFromTeam();
                            break;
                    }
                    break;
                case "4":
                    System.out.println("Delete:");
                    System.out.println("1: developer");
                    System.out.println("2: skill");
                    System.out.println("3: team");
                    System.out.println("enter any value to exit");
                    
                    System.out.println("input: ");
                    check = scanner.nextLine();
                        
                    switch (check.toLowerCase()){
                        case "1":
                            developerInterface.deleteById();
                            break;
                        case "2":
                            skillInterface.deleteById();
                            break;
                        case "3":
                            teamInterface.deleteById();
                            break;
                    }
                    break;
                case "exit":
                    System.out.println("Bye!");
                    return;
                default:
                    break;  
            }
        }

    }
}
