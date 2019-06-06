/************************************************************************************
 * File name:	CalculatorViewController.java
 * Author: 		Ababiya Abajobir
 * Course: 		CST8221 – JAP, Lab Section: 301
 * Assignment: 	1
 * Date: 		2018/10/18
 * Professor: 	Daniel Cormier
 * Purpose:		The purpose of this class is to build the calculator buttons and establish
 * 				the frame work for action command.
 * Class list: 	CalculatorViewController class extends JPanel; 
 * 				Controller class implements ActionListener (inner class);
 ***********************************************************************************/
package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.MatteBorder;
import javax.swing.*;

/**
 * This class creates the calculator application using JPanel as a container. 
 * The calculator will have single, double precision points and scientific option.
 * Error button will change color to red depending on the mode.
 * @author Ababiya Abajobir
 * @version 1.0
 * @see calculator
 * @since Java 2
 */
public class CalculatorViewController extends JPanel 
{
	/**
	 * A reference to display1
	 */
	private JTextField display1; // the calculator display1 field reference
	/**
	 * A reference to display2
	 */
	private JTextField display2; // the calculator display2 field reference
	/**
	 * A reference to mode and error
	 */
	private JLabel error; // the mode/error display label reference
	/**
	 * A reference to the decimal point button
	 */
	private JButton dotButton; //the decimal point (dot) button reference
	/**
	 * A reference to the equal button
	 */
	private static String eq = "=";
	/**
	 * This variable is use to create the two C buttons on the calculator 
	 */
	private static String clr = "C";

	/**
	 * This array will be used to give me keypad value. The plus minus symbol is represented in Unicode.
	 */
	private static String buttons[] = {	"7", "8", "9", "/", 
										"4", "5", "6", "*", 
										"1", "2","3","-",
										"0",".","\u00B1", "+",}; 

	
	/**
	 * The Calculator panels, buttons and check box are built using this constructor
	 */
	public CalculatorViewController() 
	{
		/**
		 * This panel is for my two display screens, error and backspace
		 */
		JPanel topPane = new JPanel(new BorderLayout()); 
		
		/**
		 * Top panel display, error, backspace, check box and radio buttons
		 */
		JPanel fullTopPane = new JPanel(new BorderLayout());
		
		/**
		 * Bottom panel that consists of equals, Cs and keypad
		 */
		JPanel bottomPane = new JPanel(new BorderLayout());
		
		/**
		 * Backspace button in Unicode
		 */
		JButton bSpace = new JButton("\u21da");
		
		/**
		 * Check box with a name of Int
		 */
		JCheckBox cBox = new JCheckBox("Int"); 
		
		/**
		 * Single Precision radio button
		 */
		JRadioButton singleP = new JRadioButton(".0", false); 
		
		/**
		 * Double Precision and set as defaults
		 */
		JRadioButton doubleP = new JRadioButton(".00", true);
		
		/**
		 * Scientific option radio button
		 */
		JRadioButton scien = new JRadioButton("Sci", false); 
		
		/**
		 * First Equal button
		 */
		JButton equal = new JButton(); 
		
		/**
		 * Second Equal button
		 */
		JButton equal2 = new JButton();
		
		/**
		 * First C button that will reset the display
		 */
		JButton cBut = new JButton(); 
		
		/**
		 * Second C button
		 */
		JButton cBut2 = new JButton(); 
		
		/**
		 * This panel is used to store the C buttons and the keypad at the center
		 */
		JPanel centerPanel = new JPanel(); 
		
		/**
		 * Object access the class Controller to handle actions
		 */
		Controller control = new Controller(); 
		
		/**
		 * This panel holds the keypad panel
		 */
		JPanel buttonPanel = new JPanel();

		
		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
		setLayout(new BorderLayout());
		
		/* Setting up my error label to match assignment requirements */
		error = new JLabel("F", SwingConstants.CENTER);
		error.setPreferredSize(new Dimension(46, 55));
		error.setBackground(Color.YELLOW);
		error.setBorder(new MatteBorder(0, 1/5, 0, 1/5, Color.BLACK));
		error.setFont(new Font(getName(), Font.BOLD, 20)); //my choice
		
		/****** My backspace settings for my button *******/
		bSpace.setPreferredSize(new Dimension(45, 55));
		bSpace.setBackground(Color.YELLOW);
		bSpace.setOpaque(true);
		bSpace.setBorder(new MatteBorder(0, 5/1, 0, 5/1, Color.BLACK));
		bSpace.setFont(new Font("Code2000", Font.BOLD, 20));
		bSpace.setToolTipText("BackSpace (Alt-B)");
		bSpace.setMnemonic('b');
		bSpace.setActionCommand("\u21da");
		bSpace.addActionListener(control);
        

        buttonPanel.setLayout(new GridLayout(4,4,5,5));

        for (int i = 0; i < 16; i++)
        {
            JButton button = new JButton();
            if(buttons[i] == "/" || buttons[i] == "*" || buttons[i] == "-" || buttons[i] == "+")
            	{
            	
            	button =createButton(buttons[i], buttons[i], Color.BLACK, Color.CYAN, new Controller());
            	button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
            	}
            else if(buttons[i] == "\u00B1") //Unicode for plus-minus symbol
            	{
            	button =createButton(buttons[i], buttons[i], Color.BLACK, Color.PINK, new Controller());
            	button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
            	}
            else
            	{
            	button =createButton(buttons[i], buttons[i], Color.BLACK, Color.BLUE, new Controller());
            	button.setBorder(new MatteBorder(0, 0, 0, 0, Color.WHITE));
            	}
            //button.addActionListener(this.);
            //buttonPanel.setLayout(sets);
            buttonPanel.add(button);
            buttonPanel.setBorder(new MatteBorder(5/1, 5/1, 5/1, 5/1, Color.WHITE));
            //buttonPanel.setComponentOrientation(ComponentOrientation.);
        }
        
        /*** C buttons options being setup ***/
		cBut = createButton(clr, clr, Color.BLACK, Color.RED, new Controller());
		cBut.setPreferredSize(new Dimension(0, 45));
		//cBut.setFont(new Font(getName(), Font.BOLD, 23));
		cBut.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
		cBut2 = createButton(clr, clr, Color.BLACK, Color.RED, new Controller());
		cBut2.setPreferredSize(new Dimension(0, 45));
		//cBut2.setFont(new Font(getName(), Font.BOLD, 23));
		cBut2.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
		
		/*** Keypad buttons and C buttons being placed in the pane ***/
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(cBut, BorderLayout.NORTH);
		centerPanel.add(cBut2, BorderLayout.SOUTH);
		centerPanel.add(buttonPanel, BorderLayout.CENTER);
		
		/*** Setting up my displays ***/
		display1 = new JTextField();
		display1.setColumns(16);
		display1.setPreferredSize(new Dimension(0, 30));
		display1.setBackground(Color.WHITE);
		display1.setEditable(false);
		display1.setHorizontalAlignment(JTextField.RIGHT);
		display1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		display2 = new JTextField();
		display2.setColumns(16);
		display2.setPreferredSize(new Dimension(0, 30));
		display2.setBackground(Color.WHITE);
		display2.setEditable(false);
		display2.setHorizontalAlignment(JTextField.RIGHT);
		display2.setText("0.0");
		display2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		/*** Pane contains my two display screens ***/
		JPanel displayPane = new JPanel(new BorderLayout());
		displayPane.setBorder(new MatteBorder(0, 3, 0, 0, Color.BLACK)); //my setting
		displayPane.add(display1, BorderLayout.NORTH);
		displayPane.add(display2, BorderLayout.SOUTH);
		
        /*** Setting up my check box ***/
		cBox.setBackground(Color.GREEN);
		cBox.setPreferredSize(new Dimension(40, 0));
		cBox.addActionListener(control);
		
		/*** Single precision options being set ***/
		singleP.setBackground(Color.YELLOW);
		singleP.addActionListener(control);
		
		/*** Double precision ***/
		doubleP.setBackground(Color.YELLOW);
		doubleP.addActionListener(control);
		
		/*** Scientific options ***/
		scien.setBackground(Color.YELLOW);
		scien.addActionListener(control);
		
		/*** ButtonGroup is established for radio buttons and check box ***/
		ButtonGroup rButton = new ButtonGroup();
		rButton.add(singleP);
		rButton.add(doubleP);
		rButton.add(scien);
		rButton.add(cBox);
		
		JPanel radioGroup = new JPanel();
		radioGroup.setLayout(new GridLayout(1, 1, 5, 5));
		radioGroup.add(singleP);
		radioGroup.add(doubleP);
		radioGroup.add(scien);
		
		/*** Grouping the radio buttons ***/
		Box butBox = Box.createHorizontalBox(); //Needed to add to pane2 and set it to the right as a group
		butBox.add(cBox);
		butBox.add(singleP);
		butBox.add(doubleP);
		butBox.add(scien);
		//butBox.setBorder(new MatteBorder(1/5, 1/5, 1/5, 1/5, Color.BLACK));
		
		/*Pane used to store the check box and the radio buttons */
		JPanel mode = new JPanel(new BorderLayout());
		mode.setBackground(Color.BLACK);
		mode.add(butBox, BorderLayout.EAST);
		mode.add(cBox, BorderLayout.WEST);
		mode.setBorder(new MatteBorder(5/1, 0, 5/1, 5/1, Color.BLACK));
		
		equal = createButton(eq, eq, Color.BLACK, Color.YELLOW, new Controller());
		equal.setPreferredSize(new Dimension(46, 55));
		equal.setBorder(new MatteBorder(0, 5/1, 0, 5/1, Color.BLACK));
		equal2 = createButton(eq, eq, Color.BLACK, Color.YELLOW, new Controller());
		equal2.setPreferredSize(new Dimension(46, 55));
		//equal2.setFont(new Font(getName(), Font.BOLD, 23));
		equal2.setBorder(new MatteBorder(0, 0, 0, 5/1, Color.BLACK));
		

		//pane3.add(equal, BorderLayout.EAST);
		//pane3.add(equal2, BorderLayout.WEST);
		
		topPane.setBackground(Color.YELLOW);
		topPane.add(error, BorderLayout.WEST);
		topPane.add(displayPane, BorderLayout.CENTER);
		topPane.add(bSpace, BorderLayout.EAST);
		topPane.setBackground(Color.YELLOW);
		
		fullTopPane.setLayout(new BorderLayout()); 
		fullTopPane.setBackground(Color.YELLOW);
		fullTopPane.add(topPane, BorderLayout.NORTH);
		fullTopPane.add(mode, BorderLayout.SOUTH);
		
		bottomPane.add(equal, BorderLayout.EAST);
		bottomPane.add(equal2, BorderLayout.WEST);
		bottomPane.add(centerPanel, BorderLayout.CENTER);
		
		add(fullTopPane, BorderLayout.NORTH);
		add(bottomPane, BorderLayout.CENTER);
	
	}
	
	/**
	 * The Controller class will build the GUI
	 * @author Ababiya Abajobir
	 * @version 1.0
	 * @see calculator
	 * @since Java 2
	 */
	private class Controller implements ActionListener
	{
		
		public Controller()
		{
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			display2.setText(e.getActionCommand());
		}
	}

	/**
	 * This method creates the button by assigning the string in the button, the color of
	 * the button, the color of string in the button and the action command for the string.
	 * @param String text represents the value that will be displayed on the button
	 * @param String ac represents the action command for the button in question
	 * @param Color fg represents the color of the text in the button
	 * @param Color bg represents the color of the button
	 * @param ActionListener handler represents an instance of the action listener
	 * @return JButton that has been created after 
	 */
	private JButton createButton(String text, String ac, Color fg, Color bg, ActionListener handler) {
		// TODO Auto-generated method stub
		
		JButton nBut = new JButton(text);
		
		nBut.setForeground(fg);
		nBut.setBackground(bg);
		
		if ( ac != null)
		{
			nBut.setActionCommand(ac);
		}
		nBut.setFont(new Font(ac, ABORT, 20));
		nBut.addActionListener(handler);
		
		if (text.equals("."))
		{
			dotButton = nBut;
		}
		
		
		return nBut;
	}
	
}
