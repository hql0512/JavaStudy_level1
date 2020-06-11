package com.study.test2;

public class Snake extends Reptile {

	private static String name = "Snake";
    public String getName(){
        return this.name;
    }
 
    public void move(String place){
        System.out.println("Snake crawled to " + place + ".");
    } 
 
    public void drink(){
        System.out.println("Snake dived into water and drink.");
    }


}
