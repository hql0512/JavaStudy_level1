package com.study.test2;

public class Tiger extends Mammal {

	private static String name = "Tiger";
    public String getName(){
        return this.name;
    }
 
    public void move(String place){
        System.out.println("Tiger moved to " + place + ".");
    }
 
    public void drink(){
        System.out.println("Tiger lower it's head and drink.");
    }

}
