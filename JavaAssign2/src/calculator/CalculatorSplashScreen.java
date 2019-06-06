/************************************************************************************
 * File name:	CalculatorSplashScreen.java
 * Author: 		Ababiya Abajobir
 * Course: 		CST8221 – JAP, Lab Section: 301
 * Assignment: 	1 part 2
 * Date: 		2018/11/06
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
	 * reference of the pBar
	 */
	private JProgressBar pBar;


	/**
	 * Constructor that sets up the splash screen.
	 * @param duration integer - the specified time will be called in the main class.
	 */
	public CalculatorSplashScreen(int duration) {
		this.duration = duration;

	}
	
	/**
	 * Shows the splash screen
	 */
	public void showSplashWindow() {

		JLabel pBar2 = new JLabel("Loading Calculator. Please wait...", JLabel.CENTER);
		JPanel pLabel = new JPanel(new BorderLayout());
		
		pBar = new JProgressBar();
		pBar.setMinimum(0);
		pBar.setMaximum(duration);
		pBar.setBackground(Color.GRAY);
		pBar.setPreferredSize(new Dimension(8, 16));
		pBar.setForeground(Color.RED);
		
		pBar2.setForeground(Color.RED);
		pBar2.setOpaque(false);
		pBar2.setHorizontalAlignment(JLabel.CENTER);
		
		pLabel.add(pBar, BorderLayout.NORTH);
		pLabel.add(pBar2, BorderLayout.SOUTH);
		/**
		 * This panel is for the splash content
		 */
		JPanel popUp = new JPanel(new BorderLayout());
		/**
		 * Reference to a label that stores my info
		 */
		JLabel myInfo = new JLabel("Name: iFearTheMeow   Student Number: 040873720", JLabel.CENTER);
		/**
		 * Reference to the gif image I am using
		 */
		JLabel gif = new JLabel(new ImageIcon(getClass().getResource("giphy.gif"))); 


		/**
		 * Reference to the size of my application
		 */
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int width =  480+10;
		int height = 320+10;
		int x = (screen.width-width)/2;
		int y = (screen.height-height)/2;

		/**
		 * Building my splash
		 */
		popUp.setBackground(Color.WHITE);
		setBounds(x,y,width,height);
		myInfo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
		myInfo.setForeground(Color.BLACK);
		popUp.add(myInfo, BorderLayout.NORTH);
		popUp.add(gif, BorderLayout.CENTER);
		popUp.add(pLabel, BorderLayout.SOUTH);
		popUp.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		popUp.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		
		setContentPane(popUp);
		setVisible(true);


		try {
			for (int i = 0 ; i < duration; ++i) {
				pBar.setValue(i);
				Thread.sleep(1); 
				}
		}
		catch (InterruptedException e) 
		{
			
		}

		dispose(); 
	}
}

