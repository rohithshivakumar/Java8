package com.s5s.tests.dependency;
import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Component<String> {

    String data;
    List<Component<String>> dep;
    Integer depCount;

    InstallationType installationType;


    public Component(String data, InstallationType installationType){
        this.data = data;
        this.dep = new ArrayList<>();
        this.installationType = installationType;
        this.depCount = 0;
    }

    public String getLabel(){
        return this.data;
    }

    public void incrementDepCount(){
        this.depCount++;
    }

    public void decrementDepCount(){
        this.depCount--;
    }

    public void addDependant(Component<String> component){

        this.dep.add(component);

    }

    public void removeDependant(Component<String> component){
        this.dep.remove(component);
    }

    public List<Component<String>> getDep(){
        return this.dep;
    }

    public void addDependants(List<Component<String>> components){

        this.dep.addAll(components);

    }

    public int getDepCount(){
        return this.depCount;
    }
}
