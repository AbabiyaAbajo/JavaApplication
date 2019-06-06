/************************************************************************************
 * File name:	CalculatorModel.java
 * Author: 		Ababiya Abajobir
 * Course: 		CST8221 – JAP, Lab Section: 301
 * Assignment: 	1 Part 2
 * Date: 		2018/11/06
 * Professor: 	Daniel Cormier
 * Purpose:		The purpose of this class is get the operands, mode, 
 * 				arithmetic operation, do the virtual calculation and 
 * 				provide the results when requested.
 ***********************************************************************************/
package calculator;

import java.text.DecimalFormat;


/**
 * This class is used to make all the calculations
 * @author Ababiya Abajobir
 * @version 1.5
 * @see calculator
 * @since Java 2
 */
public class CalculatorModel {

	/**
	 * value used to store the results of a float operation
	 */
	private float floatTotalValue = 0;
	/**
	 * variable use to store the results of the int operation
	 */
	private int intTotalValue = 0;
	/**
	 * first value that will be used for the calculation
	 */
	private String firstValue = "";
	/**
	 * second value that will be used for the calculation
	 */
	private String secondValue = "";
	/**
	 * storage for the arithmetic operation
	 */
	private String arithmetic = "";
	/**
	 * variable to store the mode
	 */
	private String mode = ".00";
	/**
	 * result storage
	 */
	private String result;

	/**
	 * default constructor
	 */
	public CalculatorModel(){

	}
	
	/**
	 * The first operand that will be use to make calculations
	 * @param value1 string becomes the firstValue and will be used in the calculation
	 */
	public void setFirstOperand(String value1) 
	{
		firstValue = value1;
	}
	
	/**
	 * The second operand that will be use to make calculations
	 * @param value2 string becomes the secondValue and will be used in the calculation
	 */
	public void setSecondOperand(String value2) 
	{
		secondValue = value2;
		calculate();
	}

	/**
	 * Setter for the arithmetic operation
	 * @param arith string as a parameter and sets it as the arithmetic operation
	 */
	public void setArithmetic(String arith)
	{
		arithmetic = arith;
	}
	
	/**
	 * Setter for the mode
	 * @param value string value passed into this method as a parameter and becomes the mode
	 */
	public void setOpsMode(String value)
	{
		mode = value;
	}

	/**
	 * Mode getter
	 * @return gets the mode
	 */
	public String getOpsMode()
	{
		return mode;
	}

	/**
	 * This method is responsible for setting up the floating point based on the mode
	 * @return returns a formated results
	 */
	public String setFloatingPoint(){
		DecimalFormat dF; 
		switch(mode)
		{
		case ".0":	dF = new DecimalFormat("#0.0");
		return dF.format(floatTotalValue);
		case ".00": dF = new DecimalFormat("#0.00");
		return dF.format(floatTotalValue);
		case "Sci": dF = new DecimalFormat("#0.0E0");
		return dF.format(floatTotalValue);
		}
		return "";
	}
	
	/**
	 * performs calculations in order to set the result
	 */
	public void setResults(){
		calculate();
	}

	/**
	 * Results getter.
	 * @return returns the results
	 */
	public String getResults() {
		return result;
	}

	/**
	 * When an error has been identified in the calculation, this method is called and result becomes 
	 * the error message.
	 * @param err Takes a string as a parameter and this error will determine the message
	 * @return result is return to display the error message
	 */
	public String errState (String err) {
		switch(err)
		{
		case "0": result = "Cannot divide by zero";	
		break;
		case "1": result = "Result is undefined";
		break;
		case "2": result = "Value is too long";
		}
		return result;
	}

	/**
	 * This method will virtually make calculations and store it in an
	 * int or float, depending on the mode.
	 */
	private void calculate() {

		//for INT
		if(mode.equals("Int"))
		{
			/**
			 * value used to convert the string
			 */
			int value2;
			
			if (!secondValue.isEmpty())
			{
				value2 = Integer.parseInt(secondValue);
				intTotalValue = Integer.parseInt(firstValue);
				if(intTotalValue == 0 && value2 ==0)
				{
					errState("1");
					return;
				}
				else if(value2 == 0)
				{
					errState("0");
					return;
				}
			}
			else
				value2 = Integer.parseInt(firstValue);

			if(value2 == 0)
			{
				errState("1");
				return;
			}
			switch(arithmetic)
			{
			case "+": 	if(secondValue.isEmpty() && intTotalValue == 0)
				value2+=value2;	
			intTotalValue += value2;
			break;
			case "-":	if(secondValue.isEmpty() && intTotalValue == 0)
				value2-=value2;
			intTotalValue -= value2;
			break;	
			case "*":	if(secondValue.isEmpty() && intTotalValue == 0)
			{
				intTotalValue = value2;
			}
			intTotalValue *= value2;
			break;
			case "/":	if(secondValue.isEmpty() && intTotalValue == 0)
			{
				intTotalValue = value2;
			}
			intTotalValue /= value2;
			break;
			}

			result = String.valueOf(intTotalValue);
				
		}
		else
		{
			/**
			 * value used to convert the string
			 */
			float value2;
			if (!secondValue.isEmpty())
			{
				value2 = Float.parseFloat(secondValue);
				floatTotalValue = Float.parseFloat(firstValue);
				if(floatTotalValue == 0 && value2 ==0)
				{
					errState("1");
					return;
				}
				else if(value2 == 0)
				{
					errState("0");
					return;
				}
			}
			else
				value2 = Float.parseFloat(firstValue);

			if(value2 == 0)
			{
				errState("1");
				return;
			}
			switch(arithmetic)
			{
			case "+": 	if(secondValue.isEmpty() && floatTotalValue == 0)
				value2+=value2;	
			floatTotalValue += value2;
			break;
			case "-":	if(secondValue.isEmpty() && floatTotalValue == 0)
				value2-=value2;
			floatTotalValue -= value2;
			break;	
			case "*":	if(secondValue.isEmpty() && floatTotalValue == 0)
			{
				floatTotalValue = value2;
			}
			floatTotalValue *= value2;
			break;
			case "/":	if(secondValue.isEmpty() && floatTotalValue == 0)
			{
				floatTotalValue = value2;
			}
			//if(value2==0)

			floatTotalValue /= value2;
			break;
			}
			result = setFloatingPoint();
		}
		if(result.length()>=16)
		{
			errState("2");
		}
	}

	/**
	 * This method resets all the values
	 */
	public void resetVals(){
		floatTotalValue = 0;
		intTotalValue = 0;
		secondValue = "";
		arithmetic = "";
		mode = "";
		result = "0.0";
	}
}
