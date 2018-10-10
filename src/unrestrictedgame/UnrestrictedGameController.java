package unrestrictedgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Change the view and the model according to user's interaction
 * 
 * @author Nikki Wei
 * @version 1
 */

public class UnrestrictedGameController extends JPanel implements ActionListener {
	
	// two buttons for user to answer the question
	private JButton yes;
	private JButton no;
	private JButton restart;
	
	// an instance of game view
	private UnrestrictedGameView view;
	
	// text fields for user to type in the answer
	private JTextField question;
	private JTextField answer;
	private JTextField yesOrNo;
	
	/**
	 * Constructor for the game controller
	 * @param file the xml file
	 */
	public UnrestrictedGameController(File file) {
		
		// set the layout to be gridbag layout
		super(new GridBagLayout());

		// set the background color
		setBackground(new Color(200, 50, 30));
		
		// initialize the view of all choices and display it
		view = new UnrestrictedGameView(file);
		createView();
		createButtons();
	}
	
	/**
	 * Display the view of 16 choices on the screen
	 */
	private void createView() {
		
		// get all the panels and labels from the view class
		JPanel choices = view.setUpChoices();
		JTextArea question = view.setUpQuestion();
		JLabel title = view.setUpTitle();
		JLabel logo = view.setUpLogo();
		answer = view.setUpTextField();
		this.question = view.setUpTextField();
		yesOrNo = view.setUpTextField();

		// Display everything
		GridBagConstraints c = new GridBagConstraints();
		
		// display the choices
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		c.gridwidth = 4;
		c.gridheight = 6;
		c.anchor = GridBagConstraints.LINE_START;
		this.add(choices, c);
		
		// display the logo
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.insets = new Insets(5, 0, 5, 0);
		this.add(logo, c);
		
		// display the question
		c.gridy = 3;
		c.gridwidth = 2;
		c.gridheight = GridBagConstraints.REMAINDER;
		this.add(question, c);

		// display the answer field
		c.gridx = 6;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(answer, c);
		answer.addActionListener(this);
		answer.setText("your thing");
		
		// display the yes or no field
		c.gridy = 4;
		this.add(yesOrNo, c);
		yesOrNo.addActionListener(this);
		yesOrNo.setText("yes or no");
		
		// display the question field
		c.gridy = 5;
		this.add(this.question, c);
		this.question.addActionListener(this);
		this.question.setText("your question");
		
		// display the title
		c.fill = GridBagConstraints.NONE;
		c.gridx = 4;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.PAGE_START;
		c.insets = new Insets(10, 0, 5, 0);
		this.add(title, c);
	}
	
	/**
	 * Initialize the buttons, add them to the panel, and add action listener
	 */
	private void createButtons() {
		
		// initialize the buttons
		yes = new JButton("Yes");
		no = new JButton("No");
		restart = new JButton("Restart");
		
		// make the buttons fancier
		yes.setBackground(new Color(250, 235, 155));
		yes.setOpaque(true);
		yes.setFont(new Font("Calligrapher", Font.BOLD + Font.ITALIC, 12));
		
		no.setBackground(new Color(250, 235, 155));
		no.setOpaque(true);
		no.setFont(new Font("Calligrapher", Font.BOLD + Font.ITALIC, 12));
		
		restart.setBackground(new Color(250, 235, 155));
		restart.setOpaque(true);
		restart.setFont(new Font("Calligrapher", Font.BOLD + Font.ITALIC, 12));
		
		// Display the buttons
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 4;
		c.gridy = 2;
		c.ipadx = 130;
		this.add(yes, c);
		
		c.gridx = 5;
		this.add(no, c);
		
		c.gridx = 6;
		this.add(restart, c);
		
		// Tell the Swing components that this class is providing the event handlers
        // for these components.
		yes.addActionListener(this);
		no.addActionListener(this);	
		restart.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Find out which JButton the user interacted with
		Object source = e.getSource();
		
		// update the current question according to user's choice
		if (source == yes) {
			view.updateQuestion("yes");
		}
		else if (source == no) {
			view.updateQuestion("no");
		}
		else if (source == restart) {
			view.updateQuestion("restart");
		}
		else if (source == yesOrNo || source == question || source == answer) {
			String userThing = answer.getText();
			String userQuestion = question.getText();
			String userAnswer = yesOrNo.getText();
			view.updateTree(userQuestion, userAnswer, userThing);
		}

	}

}
