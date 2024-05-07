package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals ;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import com.example.project.entity.Calculator;

public class CalculatorTest {

	@Test
	public void testAdd() {
		//arrange
		int a=3;
		int b=7;
		
		//act
		Calculator calc = new Calculator();
		int result = calc.add(a, b);
		
		//assert
		assertEquals(10,result);
		assertNotEquals(11, result);
	}
	
	@Test
	public void testMultiply() {
		int a = 3;
		int b = 4;
		
		Calculator calc = new Calculator();
		int result = calc.multiply(a, b);
		
		assertEquals(12, result);	
	}
}
