package com.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.exceptions.FieldEmptyException;
import com.exceptions.TemperatureException;
import com.main.ConvertTemp;

import junit.framework.TestCase;

public class ConvertTempTest extends TestCase{
	
	/* Test No. 1
	// Objective: To test Empty input
	// Input(s): ""
	 Expected Output:  Error        */
	public void testIsEmpty() {
		try {
			boolean result = ConvertTemp.getInstance().validateField("");
			fail("Exception Expected");
		} catch (FieldEmptyException e) {
			// TODO Auto-generated catch block
			assertEquals("Field is Empty", e.getMessage());
		}
	}
	
	/* Test No. 1
	// Objective: To test celsius in range -273.15 to 100  (Lower boundary value of valid partition)
	// Input(s): temperature="-273.15"
	 Expected Output:  "-459.67"        */
	public void testCelsius001() {
		try {
			assertEquals("-459.67",ConvertTemp.getInstance().calculateF("-273.15"));
		} catch (TemperatureException e) {
			fail("Excpetion not expected");
		}
			
	}
	
	/* Test No. 2
	// Objective: To test celsius in range -273.15 to 100  (Upper boundary value of valid partition)
	// Input(s): temperature="100"
	 Expected Output:  "212.00"        */
	public void testCelsius002() {
		try {
			assertEquals("212.00",ConvertTemp.getInstance().calculateF("100"));
		} catch (TemperatureException e) {
			fail("Excpetion not expected");
		}
	}
	
	/* Test No. 3
	// Objective: To test celsius in range -273.15 to 100  (Lower boundary value of invalid partition)
	// Input(s): temperature="-273.16"
	 Expected Output:  Error        */
	public void testCelsius003() {
		try {
			String val = ConvertTemp.getInstance().calculateF("-273.16");
			fail("Exception Expected");
		} catch (TemperatureException e) {
			assertEquals("Value not in range", e.getMessage());
		}
	}
	
	/* Test No. 4
	// Objective: To test celsius in range -273.15 to 100  (MinInt of invalid partition)
	// Input(s): temperature="100"
	 Expected Output:  Error        */
	public void testCelsius004() {
		try {
			String val = ConvertTemp.getInstance().calculateF("-1000");
			fail("Exception Expected");
		} catch (TemperatureException e) {
			assertEquals("Value not in range", e.getMessage());
		}
	}
	
	/* Test No. 5
	// Objective: To test celsius in range -273.15 to 100  (Upper boundary value of invalid partition)
	// Input(s): temperature="100.1"
	 Expected Output:  Error        */
	public void testCelsius005() {
		try {
			String val = ConvertTemp.getInstance().calculateF("100.1");
			fail("Exception Expected");
		} catch (TemperatureException e) {
			assertEquals("Value not in range", e.getMessage());
		}
	}
	
	/* Test No. 6
	// Objective: To test celsius in range -273.15 to 100  (MaxInt of invalid partition)
	// Input(s): temperature="1000"
	 Expected Output:  Error        */
	public void testCelsius006() {
		try {
			String val = ConvertTemp.getInstance().calculateF("1000");
			fail("Exception Expected");
		} catch (TemperatureException e) {
			assertEquals("Value not in range", e.getMessage());
		}
	}
	
	/* Test No. 7
	// Objective: To test Fahrenheit in range -459.67 to 212  (Lower boundary value of valid partition)
	// Input(s): temperature="-273.15"
	 Expected Output:  "-459.67"        */
	public void testFahrenheit001() {
		try {
			assertEquals("-273.15",ConvertTemp.getInstance().calculateC("-459.67"));
		} catch (TemperatureException e) {
			fail("Excpetion not expected");
		}		
	}
	
	/* Test No. 8
	// Objective: To test Fahrenheit in range -459.67 to 212  (Upper boundary value of valid partition)
	// Input(s): temperature="212"
	 Expected Output:  "100.00"        */
	public void testFahrenheit002() {
		try {
			assertEquals("100.00",ConvertTemp.getInstance().calculateC("212"));
		} catch (TemperatureException e) {
			fail("Excpetion not expected");
		}	
	}
	
	/* Test No. 9
	// Objective: To test Fahrenheit in range -459.67 to 212  (Lower boundary value of invalid partition)
	// Input(s): temperature="-459.68"
	 Expected Output:  Error        */
	public void testFahrenheit003() {
		try {
			String val = ConvertTemp.getInstance().calculateC("-459.68");
			fail("Exception Expected");
		} catch (TemperatureException e) {
			assertEquals("Value not in range", e.getMessage());
		}
	}
	
	/* Test No. 10
	// Objective: To test Fahrenheit in range -459.67 to 212  (MinInt of invalid partition)
	// Input(s): temperature="-1000"
	 Expected Output:  Error        */
	public void testFahrenheit004() {
		try {
			String val = ConvertTemp.getInstance().calculateC("-1000");
			fail("Exception Expected");
		} catch (TemperatureException e) {
			assertEquals("Value not in range", e.getMessage());
		}
	}
	
	/* Test No. 11
	// Objective: To test Fahrenheit in range -459.67 to 212  (Upper boundary value of invalid partition)
	// Input(s): temperature="212.1"
	 Expected Output:  Error        */
	public void testFahrenheit005() {
		try {
			String val = ConvertTemp.getInstance().calculateC("212.1");
			fail("Exception Expected");
		} catch (TemperatureException e) {
			assertEquals("Value not in range", e.getMessage());
		}
	}
	
	/* Test No. 11
	// Objective: To test Fahrenheit in range -459.67 to 212  (MaxInt of invalid partition)
	// Input(s): temperature="212.1"
	 Expected Output:  Error  */
	public void testFahrenheit006() {
		try {
			String val = ConvertTemp.getInstance().calculateC("1000");
			fail("Exception Expected");
		} catch (TemperatureException e) {
			assertEquals("Value not in range", e.getMessage());
		}
	}
}
