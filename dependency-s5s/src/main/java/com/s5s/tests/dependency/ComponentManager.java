package com.s5s.tests.dependency;

import java.util.*;

public class ComponentManager {

    Map<String, Component<String>> components;

    // Maintaining an additional list to track order of installation , since the test depends on it. A better way would
    // be to change the test to make it independant of order printed. The time for the test is restricting this design
    LinkedList<Component<String>> currentlyInstalledComponents;


    public ComponentManager(){
        components = new HashMap<>();
        currentlyInstalledComponents = new LinkedList<>();
    }

    public List<Component<String>> getComponents(){
        List<Component<String>> result = new ArrayList<>();

        for(String name : components.keySet()){
            result.add(components.get(name));
        }

        return result;
    }

    public Component<String> getComponent(String name){

        return components.get(name);
    }

    public Component<String> addComponent(String label){

        Component n = new Component(label, InstallationType.NotInstalled);
        components.put(label, n);
        return n;
    }

    public void addDependant(Component source, String dependant){

        if(source == null){
            throw new IllegalArgumentException("Source cannot be null");
        }

        if(dependant == null || dependant.isEmpty()){
            throw new IllegalArgumentException("dependant cannot be null");
        }

        Component<String> depComponent = components.get(dependant);

        //if depComponent is null then create the node
        if(depComponent == null){
            depComponent = this.addComponent(dependant);
        }

        source.addDependant(depComponent);

        //check cycle , if true then remove dependancy
        if(hasCycle()){
            System.out.println(dependant + " depends on " + source.getLabel() + ", ignoring command");
            source.removeDependant(depComponent);

        }

    }

    public void addDependants(Component source, List<String> dependants){

        if(source == null){
            throw new IllegalArgumentException("Source cannot be null");
        }

        if(dependants == null){
            throw new IllegalArgumentException("dependants cannot be null");
        }

        for(String dep: dependants) {
            addDependant(source, dep);
        }
    }

    /*
    * Function to check if adding a component created a cycle.
    * Uses standard dfs and uses the sets to maintain list of visited (Black),
    * visiting(gray) and not-visited (White) to determine cycles
    */
    private boolean hasCycle(){

        Set<Component<String>> whiteSet = new HashSet<>();
        Set<Component<String>> graySet = new HashSet<>();
        Set<Component<String>> blackSet = new HashSet<>();

        for(Component<String> component : this.getComponents()){
            whiteSet.add(component);
        }

        while(whiteSet.size() > 0) {

            Component<String> current = whiteSet.iterator().next();
            if(dfs(current, whiteSet, graySet, blackSet)){
                return true;
            }
        }

        //No cycle present
        return  false;

    }

    private boolean dfs(Component<String> current , Set<Component<String >> whiteset, Set<Component<String>> graySet, Set<Component<String>> blackSet){

        moveNode(current, whiteset,graySet);

        for(Component<String> neighbor : current.getDep()){

            if(blackSet.contains(neighbor)){
                continue;
            }

            //cycle found
            if(graySet.contains(neighbor)){
                return true;
            }

            if(dfs(neighbor, whiteset, graySet, blackSet)){
                return  true;
            }
        }

        //move node from gray to black set when its completely explored
        moveNode(current, graySet, blackSet);

        return  false;
    }

    private void moveNode(Component<String > component, Set<Component<String >> sourceSet, Set<Component<String>> destSet){
        sourceSet.remove(component);
        destSet.add(component);
    }

    /*
    * Helper function to uninstall the dependancies as well including the source
    */
    private void uninstallDependancies(Component<String> sourceComponent){

        Queue<Component<String>> removableComponents = new LinkedList<>();
        removableComponents.add(sourceComponent);
        while(removableComponents.size() > 0){
            Component<String> front = removableComponents.remove();
            front.installationType = InstallationType.NotInstalled;
            System.out.println("Removing " + front.getLabel());
            currentlyInstalledComponents.remove(front);
            for(Component<String> dep : front.getDep()){
                dep.decrementDepCount();
                if(dep.getDepCount() == 0 && dep.installationType == InstallationType.Implicit){
                    removableComponents.add(dep);
                }
            }
        }
    }

    /*
    * Function to uninstall components and its dependants. Using BFS technique to identify dependencies and uninstall the
    * ones installed implicitly. The main component is uninstalled explicitly
    */
    public void uninstallComponent(String component) throws Exception {

        if(component == null || component.isEmpty()){
            throw  new IllegalArgumentException("Component cannot be null or empty");
        }

        Component<String> rComponent = getComponent(component);

        if(rComponent == null){
            throw new Exception(component + " not found");
        }

        if(rComponent.installationType == InstallationType.NotInstalled){
            System.out.println(component + " is not installed");
            return;
        }

        if(rComponent.getDepCount() > 0){
            System.out.println(component.toUpperCase() + " is still needed");
            return;
        }

        uninstallDependancies(rComponent);

    }

    /*
    * Function to install components and its dependants. Using BFS technique to identify dependancies and install the
    * ones not installed implicitly. The main component is installed explicitly
    */
    public List<Component<String>> installComponents(Component sourceComponent){

        if(sourceComponent.installationType != sourceComponent.installationType.NotInstalled){
            System.out.println(sourceComponent.getLabel() + " is already installed");
            return null;
        }

        Queue<Component<String>> q = new LinkedList<>();
        List<Component<String>> installedComponents = new ArrayList<>();

        q.add(sourceComponent);
        installedComponents.add(sourceComponent);
        if(sourceComponent.installationType == InstallationType.NotInstalled){
            sourceComponent.installationType = InstallationType.Explicit;
        }

        while (q.size() > 0) {

            Component<String> component = q.remove();
            for(Component<String> n : component.getDep()){
                if(n.installationType == InstallationType.NotInstalled){
                    n.installationType = InstallationType.Implicit;
                    q.add(n);
                    installedComponents.add(n);
                }
                n.incrementDepCount();
            }
        }

        for(int i = installedComponents.size() - 1 ; i >=0 ; i--){
            System.out.println("Installing "+ installedComponents.get(i).getLabel());
            currentlyInstalledComponents.add(installedComponents.get(i));
        }

        return installedComponents;
    }

    /*
    * Function that iterates all components present and prints out if they are installed
    */
    public void printInstalledNodes(){

        for(Component<String> component : this.currentlyInstalledComponents){
                System.out.println(component.getLabel());
        }
    }

}
