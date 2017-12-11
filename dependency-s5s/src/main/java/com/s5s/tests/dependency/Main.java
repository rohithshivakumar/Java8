package com.s5s.tests.dependency;

import java.util.*;

/**
 * The entry point for the Test program
 */
public class Main {

    public static void main(String[] args) {

        ComponentManager componentManager = new ComponentManager();

        //read input from stdin
        Scanner scan = new Scanner(System.in);

        while (true) {
            String line = scan.nextLine();

            //no action for empty input
            if (line == null || line.length() == 0) {
                continue;
            }

            //the END command to stop the program
            if ("END".equals(line)) {
                System.out.println("END");
                break;
            }

            //Please provide your implementation here
            commandParser(line, componentManager);

        }

    }

    public static void commandParser(String command, ComponentManager componentManager) {
        try {
            String[] cmdComponents = command.split(" ");
            LinkedList<String> cmds = new LinkedList<String>(Arrays.asList(cmdComponents));
            String cmd = cmds.removeFirst();
            switch (cmd) {

                case "DEPEND":
                    System.out.println(command);
                    String source = cmds.removeFirst();
                    Component sourceComponent = componentManager.getComponent(source);
                    if(sourceComponent == null){
                      sourceComponent = componentManager.addComponent(source);
                    }
                    componentManager.addDependants(sourceComponent, cmds);
                    break;

                case "INSTALL":
                    String component = cmds.removeFirst();
                    sourceComponent = componentManager.getComponent(component);
                    System.out.println(command);
                    if(sourceComponent == null){
                        sourceComponent = componentManager.addComponent(component);
                    }
                    componentManager.installComponents(sourceComponent);
                    break;

                case "REMOVE":
                    System.out.println(command);
                    component = cmds.removeFirst();
                    componentManager.uninstallComponent(component);
                    break;

                case "LIST":
                   System.out.println(command);
                   componentManager.printInstalledNodes();
                   break;

                default:
                    System.out.println("Unsuported op");

            }
        }catch (Exception e){

            System.out.println(e.getMessage());
        }
    }
}