package com.study.test3;

public class BeerTest {

	public static void main(String[] args) {
		
		int money = 10;
		int beer = money/2;
		int cover = beer;
		int bottle = beer;
		int buy = beer;
		while(true) {
			if(cover>=4) {
				cover -= 4;
				buy += 1;
				bottle += 1;
				cover += 1;
			}
			if(bottle>=2) {
				bottle -= 2;
				buy += 1;
				bottle += 1;
				cover += 1;
			}
			if(bottle<2 && cover<4) {
				break;
			}
		}
		
		System.out.println(buy);
	}

}
