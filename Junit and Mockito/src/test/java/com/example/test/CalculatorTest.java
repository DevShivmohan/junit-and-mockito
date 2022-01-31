package com.example.test;

import com.example.junit.Calculator;
import com.example.junit.CalculatorService;
import org.junit.*;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculatorTest {
    Calculator calculator;

    /**
     * use this to also instantiate the interface
     */
    @Mock
    CalculatorService calculatorService;

    /**
     * use this to instantiate the interface
     * CalculatorService calculatorService=new Mockito.mock(CalculatorService.class);
     */

    /**
     * if use @Mock annotation then specify this rule
     */
    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();

    @Before
    public void setUp(){
        System.out.println("Execute only once after beforeClass");
        calculator=new Calculator(calculatorService);
    }

    @After
    public void release(){
        System.out.println("Execute only once after test cases");
        calculator=null;
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Execute only once at starting");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("Execute only once at ending");
    }

    @Test
    public void addTest(){
        when(calculatorService.add(2,3)).thenReturn(5);
        assertEquals(10,calculator.add(2,3));
        verify(calculatorService).add(2,3);
    }

    @Test
    public void subTest(){
        when(calculatorService.sub(5,3)).thenReturn(2);
        assertEquals(4,calculator.sub(5,3));
        verify(calculatorService).sub(5,3);
    }
}
