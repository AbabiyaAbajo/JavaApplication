/************************************************************************************
 * File name:	CalculatorViewController.java
 * Author: 		Ababiya Abajobir
 * Course: 		CST8221 – JAP, Lab Section: 301
 * Assignment: 	1 Part 2
 * Date: 		2018/11/06
 * Professor: 	Daniel Cormier
 * Purpose:		The purpose of this class is to build the calculator buttons and establish
 * 				the frame work for action command.
 * Class list: 	CalculatorViewController class extends JPanel; 
 * 				Controller class implements ActionListener (inner class);
 * 				KeyboardsEvent class extends AbstractAction (inner class);
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
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.border.MatteBorder;
import javax.swing.*;

/**
 * This class creates the calculator application using JPanel as a container. 
 * The calculator will have single, double precision points and scientific option.
 * Error button will change color to red depending on the mode.
 * @author Ababiya Abajobir
 * @version 2.2
 * @see calculator
 * @since Java 2
 */
public class CalculatorViewController extends JPanel 
{
	/**
	 * A reference to display1
	 */
	private JTextField display1; 
	/**
	 * A reference to display2
	 */
	private JTextField display2; 
	/**
	 * A reference to mode and error
	 */
	private JLabel error; 
	/**
	 * A reference to the decimal point button
	 */
	private JButton dotButton; 

	/**
	 * A reference to error panel
	 */
	private JPanel errorPanel;

	/**
	 * A reference to the equal button
	 */
	private static String eq = "=";
	/**
	 * This variable is use to create the two C buttons on the calculator 
	 */
	private static String clr = "C";

	/**
	 * A reference to the check box
	 */
	private JCheckBox cBox;

	/**
	 * A reference to the double precision radio button
	 */
	private JRadioButton doubleP;

	/**
	 * This array will be used to give me keypad value. The plus minus symbol is represented in Unicode.
	 */
	private static String buttons[] = {	"7", "8", "9", "/", 
										"4", "5", "6", "*", 
										"1", "2","3","-",
										"0",".","\u00B1", "+",}; 

	/**
	 * Array will be used to match keyboard keys with the keypad values
	 */
	private static final int keybButton[] = {	KeyEvent.VK_NUMPAD7, KeyEvent.VK_NUMPAD8, KeyEvent.VK_NUMPAD9, KeyEvent.VK_DIVIDE,
			KeyEvent.VK_NUMPAD4, KeyEvent.VK_NUMPAD5, KeyEvent.VK_NUMPAD6, KeyEvent.VK_MULTIPLY,
			KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUMPAD3, KeyEvent.VK_SUBTRACT,
			KeyEvent.VK_NUMPAD0, KeyEvent.VK_DECIMAL, KeyEvent.VK_MINUS, KeyEvent.VK_ADD};
	/**
	 * Array will be used to match keyboard keys with the keypad values
	 */
	private static final int keybButton2[] = {	KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9, KeyEvent.VK_SLASH,
			KeyEvent.VK_4, KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_MULTIPLY,
			KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_SUBTRACT,
			KeyEvent.VK_0, KeyEvent.VK_PERIOD, KeyEvent.VK_MINUS, KeyEvent.VK_ADD};

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
		cBox = new JCheckBox("Int"); 

		/**
		 * Single Precision radio button
		 */
		JRadioButton singleP = new JRadioButton(".0", false); 

		/**
		 * Double Precision and set as defaults
		 */
		doubleP = new JRadioButton(".00", true);

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
		 * Instance of the CalculatorMode Class
		 */
		CalculatorModel event = new CalculatorModel();

		/**
		 * Object access the class Controller to handle actions and takes an instance 
		 * of CalculatorModel as a parameter
		 */
		Controller control = new Controller(event); 

		/**
		 * This panel holds the keypad panel
		 */
		JPanel buttonPanel = new JPanel();



		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
		setLayout(new BorderLayout());

		/**
		 *  Setting up my error label to match assignment requirements 
		 */
		errorPanel = new JPanel();
		error = new JLabel("F", SwingConstants.CENTER);
		error.setPreferredSize(new Dimension(46, 55));
		errorPanel.setBackground(Color.YELLOW);
		
		error.setFont(new Font(getName(), Font.BOLD, 20)); 
		errorPanel.add(error);
		errorPanel.setPreferredSize(new Dimension(46, 55));
		errorPanel.setBorder(new MatteBorder(0, 1/5, 0, 1/5, Color.BLACK));

		/**
		 * My backspace settings for my button 
		 */
		bSpace.setPreferredSize(new Dimension(45, 55));
		bSpace.setBackground(Color.YELLOW);
		bSpace.setOpaque(false);
		bSpace.setBorder(new MatteBorder(0, 5/1, 0, 5/1, Color.BLACK));
		bSpace.setFont(new Font("Code2000", Font.BOLD, 20));
		bSpace.setToolTipText("BackSpace (Alt-B)");
		bSpace.setMnemonic('b');
		bSpace.setActionCommand("\u21da");
		bSpace.addActionListener(control);
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "\u21B2");
		getActionMap().put("\u21B2", new KeyboardsEvent(bSpace));

		buttonPanel.setLayout(new GridLayout(4,4,5,5));

		for (int i = 0; i < 16; i++)
		{
			/**
			 * A reference to the keypad button
			 */
			JButton button = new JButton();
			if(buttons[i] == "/" || buttons[i] == "*" || buttons[i] == "-" || buttons[i] == "+")
			{

				button =createButton(buttons[i], buttons[i], Color.BLACK, Color.CYAN, control);
				button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
			}
			else if(buttons[i] == "\u00B1")
			{
				button =createButton(buttons[i], buttons[i], Color.BLACK, Color.PINK, control);
				button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
			}
			else
			{
				button =createButton(buttons[i], buttons[i], Color.BLACK, Color.BLUE, control);
				button.setBorder(new MatteBorder(0, 0, 0, 0, Color.WHITE));
			}
			buttonPanel.add(button);
			buttonPanel.setBorder(new MatteBorder(5/1, 5/1, 5/1, 5/1, Color.WHITE));
			getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keybButton[i], 0), buttons[i]);
			getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keybButton2[i], 0), buttons[i]);
			getActionMap().put(buttons[i], new KeyboardsEvent((JButton)buttonPanel.getComponent(i)));
		}

		/**
		 * C buttons options being setup
		 */
		cBut = createButton(clr, clr, Color.BLACK, Color.RED, control);
		cBut.setPreferredSize(new Dimension(0, 45));
		cBut.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
		cBut2 = createButton(clr, clr, Color.BLACK, Color.RED, control);
		cBut2.setPreferredSize(new Dimension(0, 45));
		cBut2.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "C");
		getActionMap().put("C", new KeyboardsEvent(cBut));

		/**
		 * Keypad buttons and C buttons being placed in the pane
		 */
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(cBut, BorderLayout.NORTH);
		centerPanel.add(cBut2, BorderLayout.SOUTH);
		centerPanel.add(buttonPanel, BorderLayout.CENTER);

		/**
		 * Setting up my displays
		 */
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

		/**
		 * Pane contains my two display screens
		 */
		JPanel displayPane = new JPanel(new BorderLayout());
		displayPane.setBorder(new MatteBorder(0, 3, 0, 0, Color.BLACK)); 
		displayPane.add(display1, BorderLayout.NORTH);
		displayPane.add(display2, BorderLayout.SOUTH);

		/**
		 * Setting up my check box
		 */
		cBox.setBackground(Color.GREEN);
		cBox.setPreferredSize(new Dimension(40, 0));
		cBox.addActionListener(control);



		/**
		 * Single precision options being set
		 */
		singleP.setBackground(Color.YELLOW);
		singleP.addActionListener(control);


		/**
		 * Double precision
		 */
		doubleP.setBackground(Color.YELLOW);
		doubleP.addActionListener(control);

		/**
		 * Scientific options
		 */
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

		/**
		 * Grouping the radio buttons 
		 */
		Box butBox = Box.createHorizontalBox(); //Needed to add to pane2 and set it to the right as a group
		butBox.add(cBox);
		butBox.add(singleP);
		butBox.add(doubleP);
		butBox.add(scien);

		/**Pane used to store the check box and the radio buttons */
		JPanel mode = new JPanel(new BorderLayout());
		mode.setBackground(Color.BLACK);
		mode.add(butBox, BorderLayout.EAST);
		mode.add(cBox, BorderLayout.WEST);
		mode.setBorder(new MatteBorder(5/1, 0, 5/1, 5/1, Color.BLACK));

		equal = createButton(eq, eq, Color.BLACK, Color.YELLOW, control);
		equal.setPreferredSize(new Dimension(46, 55));
		equal.setBorder(new MatteBorder(0, 5/1, 0, 5/1, Color.BLACK));
		equal2 = createButton(eq, eq, Color.BLACK, Color.YELLOW, control);
		equal2.setPreferredSize(new Dimension(46, 55));
		equal2.setBorder(new MatteBorder(0, 0, 0, 5/1, Color.BLACK));
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, 0), "=");
		getActionMap().put("=", new KeyboardsEvent(equal));

		topPane.setBackground(Color.YELLOW);
		topPane.add(errorPanel, BorderLayout.WEST);
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
	 * This class is used to make the calculator application accept keyboard inputs
	 * @author Ababiya Abajobir
	 * @version 1.0
	 * @see calculator
	 * @since Java 2
	 */
	private class KeyboardsEvent extends AbstractAction {


		/**
		 * Serial version
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * A button that will handles the keyboard events
		 */
		AbstractButton keys;

		/**
		 * The constructor takes a button as a parameter and matches the button with the specified key
		 * @param button 
		 */
		public KeyboardsEvent(AbstractButton button) {
			keys = button;
		}

		/**
		 * acknowledge the key that is pressed as an action
		 * @param takes an action event as a parameter
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			keys.doClick();
		}

	}
	/**
	 * The Controller class will build the GUI
	 * @author Ababiya Abajobir
	 * @version 2.4
	 * @see calculator
	 * @since Java 2
	 */
	private class Controller implements ActionListener
	{
		/**
		 * Instance of a calculator model that will be used to pass data to the class
		 */
		private CalculatorModel event;

		/**
		 * String mode is used to set the mode (int or float)
		 */
		private String mode = ".00";
		private String operation = "";

		/**
		 * This flag is used to direct the application to overwrite the
		 * previous data in display2 if the flag is true
		 */
		private boolean flag = false; 

		/**
		 * Sets the event to the parameter of mainEvent
		 * @param is an instance of the CalculatorModel class
		 */
		public Controller(CalculatorModel mainEvent)
		{
			event = mainEvent;
		}

		/**
		 * This method will reset the mode
		 */
		public void mode()
		{
			if((event.getOpsMode().equals("Int")) && mode.equals("Int"))
			{
				//if(!error.getText().equals("E"))
					mode = ".00";
				cBox.setSelected(false);
				doubleP.setSelected(true);
			}

			if (mode.equals("Int"))
			{
				if(!error.getText().equals("E"))
				{
					display1.setText("");
					display2.setText("0");
					errorPanel.setBackground(Color.GREEN);
					error.setText("I");
				}
				cBox.setSelected(true);
				dotButton.setEnabled(false);
				dotButton.setBackground(new Color(178,156,250));
				event.setOpsMode(mode);
				event.resetVals();
				flag=true;
			}
			else
			{

				dotButton.setEnabled(true);
				dotButton.setBackground(Color.BLUE);
				if(!error.getText().equals("E"))
				{
					errorPanel.setBackground(Color.YELLOW);
					error.setText("F");

					display1.setText("");
					if (mode.equals(".0"))
					{
						display2.setText("0.0");						
					}
					else if (mode.equals(".00"))
					{
						display2.setText("0.0");
					}
					else if (mode.equals("Sci"))
					{
						display2.setText("0.0");
					}
				}
				event.setOpsMode(mode);
				event.resetVals();
				flag=true;
			}

		}

		/**
		 * The purpose of resetC is to reset all the displays, errors and data
		 */
		public void resetC()
		{
			display1.setText("");
			display2.setText("0.0");
			if(mode.equals("Int"))
			{
				errorPanel.setBackground(Color.GREEN);
				error.setText("I");
			}
			else
			{
				errorPanel.setBackground(Color.YELLOW);
				error.setText("F");
				dotButton.setEnabled(true);
			}
			event.resetVals();
		}

		/**
		 * Performs the action based on the keyed or clicked button
		 * @param takes an ActionEvent as a parameter.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String operand = "";


			if (e.getActionCommand().equals("+") || e.getActionCommand().equals("-") || e.getActionCommand().equals("*") || e.getActionCommand().equals("/"))
				operation = e.getActionCommand();
			else if(e.getActionCommand().equals("Int") || e.getActionCommand().equals(".0") || e.getActionCommand().equals(".00") || e.getActionCommand().equals("Sci"))
				mode = e.getActionCommand();
			else
				operand = e.getActionCommand();

			/**
			 * these statements will check for errors and if we're in an error state, only a few tasks can be performed.
			 */
			if(display2.getText().equals("Cannot divide by zero"))
			{
				if(operand.equals("C"))
				{
					resetC();
					return;
				}
				else if(e.getActionCommand().equals(mode))
				{
					
					mode();
					event.setOpsMode(mode);
					return;
				}
				else
					return;
			}
			else if(display2.getText().equals("Result is undefined"))
			{
				if(operand.equals("C"))
				{
					resetC();
					return;
				}
				else if(e.getActionCommand().equals(mode))
				{
					mode();
					event.setOpsMode(mode);
					return;
				}
				else
					return;
			}
			else if (display2.getText().equals("Value is too long"))
			{
				if(operand.equals("C"))
				{
					resetC();
					return;
				}
				else if(e.getActionCommand().equals(mode))
				{
					mode();
					event.setOpsMode(mode);
					return;
				}
				else
					return;
			}
			else if((display2.getText().length()>=16) || (display1.getText().length()>=16))
			{
				event.errState("2");
				display2.setText(event.getResults());
				errorPanel.setBackground(Color.RED);
				error.setText("E");
				event.resetVals();
				return;
			}

			/**
			 * this flag is used to manipulate the behavior. The responsibility is to remove the data in display2 if the flag is turned on
			 */
			if (flag)
			{
				if(e.getActionCommand().equals(operation))
				{
					flag=true;
				}
				else
				{
					display2.setText("");
					flag = false;
				}
			}

			/**
			 * Switch statement that will perform various tasks based on the action
			 */
			switch(e.getActionCommand())
			{
			case "+":
			case "-":
			case "*":
			case "/":
				if(!display1.getText().isEmpty() && (display1.getText().endsWith("+") || display1.getText().endsWith("-") || display1.getText().endsWith("*") || display1.getText().endsWith("/")))
				{
					display1.setText(display1.getText().substring(0, display1.getText().length()-1) + operation);
				}
				else
				{
					event.setFirstOperand(display2.getText());
					display1.setText(display2.getText() + operation);
				}
				event.setArithmetic(operation);
				event.setOpsMode(mode);
				flag=true;

				break;
			case "Int":
			case ".0":
			case ".00":
			case "Sci":
				mode();
				event.setOpsMode(mode);
				break;
			case "C":
				resetC();
				break;
			case "=":
			{{
				if (!display2.getText().isEmpty())
					display1.setText(display1.getText()+display2.getText());
				if(display1.getText().endsWith(operation))
					event.setResults();
				else
					event.setSecondOperand(display2.getText());
				display1.setText("");	
			}
			display2.setText(event.getResults());

			if (display2.getText().equals("Cannot divide by zero") || display2.getText().equals("Result is undefined"))
			{
				errorPanel.setBackground(Color.RED);
				error.setText("E");
				event.resetVals();
			}
			flag=true;}
			break;
			case "\u21da":
				if (display2.getText().length() > 0)
					display2.setText(display2.getText().substring(0, display2.getText().length()-1));
				if(display2.getText().equals("-"))
					display2.setText("0");
				break;
			case "\u00B1":
				if(display2.getText().equals("0.0"))
					display2.setText("");
				else if (display2.getText().equals("0"))
					display2.setText("0");
				if(display2.getText().startsWith("-"))
					display2.setText(display2.getText().substring(1));
				else
					display2.setText("-"+display2.getText());
				break;
			case ".":
			case "0":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
				if(display2.getText().contains(".") && operand.equals("."))
				{
					return;
				}
				else if (!display2.getText().equals("0.0") && (!display1.getText().endsWith("+") || !display1.getText().endsWith("-") || !display1.getText().endsWith("*") || !display1.getText().endsWith("/")))
				{
					display2.setText(display2.getText() + e.getActionCommand());
				}
				else
				{
					display2.setText(e.getActionCommand());
				}
				break;
			default:
				break;
			}
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
			return dotButton;
		}
		return nBut;
	}
}
