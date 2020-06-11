package com.study.test2;

public class Farmer {

	public void bringWater(String place){
        System.out.println("Farmer bring water to " + place + ".");
    }
 
    public void feedWater(Animal a){
        this.bringWater("Feeding Room");
        a.move("Feeding Room");
        a.drink();
    }
    
    public static void main(String[] args) {
		Farmer f = new Farmer();
		f.feedWater(new Tiger());
	}
}
