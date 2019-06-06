/************************************************************************************
 * File name:	Calculator.java
 * Author: 		Ababiya Abajobir
 * Course: 		CST8221 – JAP, Lab Section: 301
 * Assignment: 	1
 * Date: 		2018/10/18
 * Professor: 	Daniel Cormier
 * Purpose:		The purpose of this class is to run the splash screen, for a specific 
 * 				duration and than run the calculator application.
 ***********************************************************************************/
package calculator;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * Calculator class is respondible for running the splash screen and the calculator
 * @author Ababiya Abajobir
 * @version 1.0
 * @see calculator
 * @since Java 2
 */
public class Calculator {
	
	/**
	 * Main method sets the duration for the splash to 5 seconds as per the assignment and
	 * runs the calculator application after the 5 seconds
	 * @param ard Duration of the calculator splash
	 */
	public static void main (String[] ard)
	{
		/**
		 * Duration of the calculator is being set to 5000 as as a default option
		 */
		int duration = 5000;

		/**
		 * Creating an object of CalculatorSplashScreen
		 */
		CalculatorSplashScreen displaySS = new CalculatorSplashScreen(duration);
		//Displays the Splash 
		displaySS.showSplashWindow();

		/**
		 * Runs the calculator application
		 */
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){ 	
				
				/**
				 * Creating the container for the calculator application and setting the parameters
				 */
				JFrame borders = new JFrame("Calculator");
				borders.setMinimumSize(new Dimension(380,520));
				borders.setPreferredSize(new Dimension(380, 520));
				borders.setSize(380, 520);
				borders.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				borders.setLocationByPlatform(true);
				borders.setContentPane(new CalculatorViewController());
				borders.setVisible(true);

			}
		});
	}
}