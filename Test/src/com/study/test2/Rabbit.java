package com.study.test2;

public class Rabbit extends Mammal {

	private static String name = "Rabbit";
    public String getName(){
        return this.name;
    }
 
    public void move(String place){
        System.out.println("Rabbit moved to " + place + ".");
    }
 
    public void drink(){
        System.out.println("Rabbit put out it's tongue and drink.");
    }

}
