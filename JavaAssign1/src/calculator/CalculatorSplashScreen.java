/************************************************************************************
 * File name:	CalculatorSplashScreen.java
 * Author: 		Ababiya Abajobir
 * Course: 		CST8221 – JAP, Lab Section: 301
 * Assignment: 	1
 * Date: 		2018/10/18
 * Professor: 	Daniel Cormier
 * Purpose:		To build the calculator splash
 ***********************************************************************************/

package calculator;

import java.awt.*;
import javax.swing.*;

/**
This class creates a splash screen for the calculator application using JWindow as a container.
The calculator splash screen will pop up on the screen for a duration that will be assigned in the 
main method that is located in the Calculator class. 
 * @author Ababiya Abajobir
 * @version 1.0
 * @see calculator
 * @since Java 2
 */
public class CalculatorSplashScreen extends JWindow {

	/** Swing components serialVersionUID */
	private static final long serialVersionUID = 6137478910824821023L;

	/** This variable will be used to set the splash duration */
	private final int duration;
	
	/**
	 * Constructor that sets up the splash screen.
	 * @param intiger duration - the specified time will be called in the main class.
	 */
	public CalculatorSplashScreen(int duration) {
		this.duration = duration;
	}

	/**
	 * Shows the splash screen
	 */
	public void hiMartin() {
		System.out.println("Hi!");
	}
	
	public void showSplashWindow() {

		/**
		 * This panel is for the splash content
		 */
		JPanel popUp = new JPanel(new BorderLayout());
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		JLabel title = new JLabel("My Calculator Application", JLabel.CENTER);
		JLabel gif = new JLabel(new ImageIcon(getClass().getResource("giphy.gif"))); 
		JLabel myInfo = new JLabel("Name: Ababiya Abajobir   Student Number: 040873720", JLabel.CENTER);
		
		
		int width =  480+10;
		int height = 320+10;
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;

		popUp.setBackground(Color.WHITE);
		
		setBounds(x,y,width,height);
		//Making the Splash screen and setting all the variables
 
		title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		title.setForeground(Color.RED);
		myInfo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
		myInfo.setForeground(Color.BLACK);
		popUp.add(title, BorderLayout.NORTH);
		popUp.add(gif, BorderLayout.CENTER);
		popUp.add(myInfo, BorderLayout.SOUTH);
		popUp.setBorder(BorderFactory.createLineBorder(Color.YELLOW));

		setContentPane(popUp);
		setVisible(true);

		try {

			Thread.sleep(duration); }
		catch (InterruptedException e) 
		{
			
		}

		dispose(); 
	}
}