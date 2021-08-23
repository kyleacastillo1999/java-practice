package com.practice.tests;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.practice.week1.ValidCreditCard;

public class ValidCreditCardTests {
	
	private ValidCreditCard validCard;
	private static final Logger log = LoggerFactory.getLogger(ValidCreditCardTests.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
			log.info("Beginning tests for ValidCreditCard");
			
	}
	
	@Before
	public void setupEmptyStringIsInvalid() {
		log.info("Setting up credit card for emptyStringIsInvalid");
		validCard = new ValidCreditCard();
	}
	
	@Test
	public void emptyStringIsInvalid() {
		log.info("Testing if an emtpy string returns false");
		assertFalse(validCard.validateCard(""));
	}
	
	@After
	public void teardownEmptyStringIsInvalid() {
		log.info("Tearing down emptyStringIsInvalid");
		validCard = null;
	}
	
	@AfterClass
	public static void teardownAfterClass() throws Exception{
		log.info("Tests complete for ValidCreditCard");
	}
}
