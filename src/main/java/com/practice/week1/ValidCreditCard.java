package com.practice.week1;

public class ValidCreditCard {
	
	public boolean validateCard(String card) {
		if(card.length() >= 14 && card.length() <= 19) {
			// Do validation
			return true;
		
		} else {
			// The card does not meet the basic requirement to be a credit card. Return false.
			return false;
		}
	}
}
