package com.study.test2;

public class Goat extends Mammal {

	private static String name = "Goat";
    public String getName(){
        return this.name;
    }
 
    public void move(String place){
        System.out.println("Goat moved to " + place + ".");
    }
 
    public void drink(){
        System.out.println("Goat lower it's head and drink.");
    }
}
