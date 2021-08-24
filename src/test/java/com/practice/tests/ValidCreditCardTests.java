package com.practice.tests;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.practice.week1.ValidCreditCard;

public class ValidCreditCardTests {
	
	private ValidCreditCard cv;
	private static final Logger log = LoggerFactory.getLogger(ValidCreditCardTests.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
			log.info("Beginning tests for ValidCreditCard.");
			
	}
	
	@Before
	public void setupEmptyStringIsInvalid() {
		log.info("Setting up ValidCreditCard object for testing.");
		cv = new ValidCreditCard();
	}
	
	@Test
	public void emptyStringIsInvalid() {
		log.info("Testing if an emtpy string returns false.");
		assertFalse(cv.validateCard(""));
	}
	
	@Test
	public void cardLengthMustBeBetween14And19() {
		log.info("Testing if a card that is not between 14 and 19 characters is automatically invalid");
		assertFalse(cv.validateCard("123"));
		assertFalse(cv.validateCard("1234567890123"));
		assertFalse(cv.validateCard("12345678901234567890"));
	}
	
	@Test
	public void testCardIsValid() {
		log.info("Testing to see if a valid card returns as valid.");
		assertTrue(cv.validateCard("1234567890123452"));
	}
	
	@Test
	public void testCardIsInvalid() {
		log.info("Testing to see if an invalid card returns as invalid.");
		assertFalse(cv.validateCard("123456789012345"));
	}
	
	@After
	public void teardownEmptyStringIsInvalid() {
		log.info("Tearing down ValidCreditCard object for testing.");
		cv = null;
	}
	
	@AfterClass
	public static void teardownAfterClass() throws Exception{
		log.info("Tests complete for ValidCreditCard.");
	}
}
