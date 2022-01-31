package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.example.junit.Calculator;
import com.example.junit.CalculatorService;

public class CalculatorTest {
	Calculator calculator;

	/**
	 * use this to also instantiate the interface
	 */
	@Mock
	CalculatorService calculatorService;

	/**
	 * use this to instantiate the interface CalculatorService calculatorService=new
	 * Mockito.mock(CalculatorService.class);
	 */

	/**
	 * if use @Mock annotation then specify this rule
	 */
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Execute only once at starting");
	}

	@Before
	public void setUp() {
		System.out.println("Execute only once after beforeClass");
		calculator = new Calculator(calculatorService);
	}

	@Test
	public void addTest() {
		when(calculatorService.add(2, 3)).thenReturn(5);
		assertEquals(10, calculator.add(2, 3));
		verify(calculatorService).add(2, 3);
	}

	@Test
	public void subTest() {
		when(calculatorService.sub(5, 3)).thenReturn(2);
		assertEquals(4, calculator.sub(5, 3));
		verify(calculatorService).sub(5, 3);
	}

	@Test
	public void mulTest() {
		when(calculatorService.mul(5, 3)).thenReturn(15);
		assertEquals(30, calculator.mul(5, 3));
		verify(calculatorService).mul(5, 3);
	}

	@Test
	public void devTest() {
		when(calculatorService.dev(5, 3)).thenReturn(2);
		assertEquals(4, calculator.dev(5, 3));
		verify(calculatorService).dev(5, 3);
	}

	@After
	public void release() {
		System.out.println("Execute only once after test cases");
		calculator = null;
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("Execute only once at ending");
	}
}
