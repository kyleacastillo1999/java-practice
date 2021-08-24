package com.practice.week1;

/**
 * A class that contains validation methods for credit cards.
 * 
 * @author Kyle Castillo
 */
public class ValidCreditCard {

	/**
	 * Provides validation for a credit card to test if the card passes the Luhn
	 * test.
	 * 
	 * @param card The card to be tested.
	 * @return <code>true</code> if the card is valid <code>false</code> if not.
	 */
	public boolean validateCard(String card) {
		if (card.length() >= 14 && card.length() <= 19) {
			// Do validation
			// Remove the last digit, the check digit
			Integer checkDigit = Integer.parseInt(card.substring(card.length() - 1));
			int sum = 0;
			String[] cardArr = card.split("");
			// Reverse the number, IE check from the back and go to the front.
			for (int i = cardArr.length - 2; i >= 0; i--) {
				int testDigit = Integer.parseInt(cardArr[i]);
				if(i % 2 != 0) {
					testDigit *= 2;
					if(testDigit > 10) {
						while(testDigit > 0) {
							sum += testDigit % 10;
							testDigit /= 10;
						}
					} else {
						sum += testDigit;
					}
				} else {
					sum += testDigit;
				}
			}
			
			return checkDigit == 10 - (sum % 10) ? true : false;
		} 
		else return false;
	}

	/**
	 * Provides validation for a credit card to test if the card passes the Luhn
	 * test.
	 * 
	 * @param card The card to be tested.
	 * @return <code>true</code> if the card is valid <code>false</code> if not.
	 */
	public boolean validateCard(Integer card) {
		return validateCard(card.toString());
	}
}
