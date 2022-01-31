package com.example.junit;

public class Calculator {

	CalculatorService calculatorService;

	public Calculator(CalculatorService calculatorService){
		this.calculatorService=calculatorService;
	}

	public Calculator() {
	}

	public int add(int num1, int num2) {
		return calculatorService.add(num1,num2)*2;
	}

	public int sub(int num1, int num2) {
		return calculatorService.sub(num1,num2)*2;
	}

	public int mul(int num1, int num2) {
		return calculatorService.mul(num1,num2)*2;
	}

	public int dev(int num1, int num2) {
		return calculatorService.dev(num1,num2)*2;
	}
}
