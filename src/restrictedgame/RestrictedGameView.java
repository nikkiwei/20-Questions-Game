package restrictedgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import datastructures.BinaryTree;
import datastructures.BinaryTreeNode;
import datastructures.LinkedList;
import xmlreader.FileReader;

/**
 * Store all parts of the view on screen
 * 
 * @author Nikki Wei
 * @version 1
 */

public class RestrictedGameView {
	
	/** The number of rows **/
	public static final int NUM_ROW = 4;
	
	/** The number of columns **/
	public static final int NUM_COL = 4;
	
	// JLabel array to store all the choices
	private JLabel[][] labels;
	
	// the list of name of all the choices
	private LinkedList<String> texts;
	
	// xml file reader to convert xml file to decision tree
	private FileReader reader;
	
	// the decision tree to store xml file data
	private BinaryTree<String> gameTree;
	
	// the node that stores current question
	private BinaryTreeNode<String> currentNode;
	
	// the label displays the question;
	private JLabel question;
	
	/**
	 * Constructor for the game view
	 * @param file the xml file to be converted
	 */
	public RestrictedGameView(File file) {
		
		// initialize labels array, the file reader, the decision tree, and the list of choices
		labels = new JLabel[NUM_ROW][NUM_COL];
		reader = new FileReader();
		gameTree = reader.readFile(file);
		texts = new LinkedList<String>();
		
		// find all the names of the possible choices
		gameTree.findLeafNodes(gameTree.getRoot(), texts);
		currentNode = gameTree.getRoot();
	}
	
	/**
	 * Display 16 possible choices in a panel
	 * @return the panel containing all the choices
	 */
	public JPanel setUpChoices() {
		
		// the choices panel
		JPanel choices = new JPanel(new GridBagLayout());
		choices.setBackground(new Color(200, 50, 30));
		
		// loop through label array, create all labels, and display them on screen
		for (int i = 0; i < labels.length; i ++) {
			for (int j = 0; j < labels[i].length; j ++) {

				// create the label image
				ImageIcon icon = createImageIcon("icons/" + (i*4 + j) + ".gif");
				Image image = icon.getImage();
				icon = new ImageIcon(image.getScaledInstance(120, 120, Image.SCALE_DEFAULT));
				
				// create the label text, set the position of the text relative to the icon
				labels[i][j] = new JLabel(texts.get(i*4 + j), icon, JLabel.CENTER);
				labels[i][j].setVerticalTextPosition(JLabel.BOTTOM);
				labels[i][j].setHorizontalTextPosition(JLabel.CENTER);
				
				// set the color of the background and the texts
				labels[i][j].setForeground(Color.YELLOW);

				// Display the label on the screen
				GridBagConstraints c = new GridBagConstraints();
				c.fill = GridBagConstraints.HORIZONTAL;
				c.gridx = i;
				c.gridy = j;
				c.gridwidth = 1;
				c.gridheight = 1;
				c.ipadx = 40;
				c.weightx = 1.0;
				c.insets = new Insets(10, 10, 10, 10);
				choices.add(labels[i][j], c);
			}
		}
		
		return choices;
	}
	
	/**
	 * Returns an ImageIcon, or null if the path was invalid.
	 * @param path directory to the specified file
	 * @return the image icon
	 */
	private ImageIcon createImageIcon(String path) {
		
	    java.net.URL imgURL = getClass().getResource(path);
	    
	    if (imgURL != null) {
	        return new ImageIcon(imgURL);
	    }
	    
	    else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
	
	/**
	 * Return a label that displays the current question
	 * @return the label containing the question
	 */
	public JLabel setUpQuestion() {
		question = new JLabel();
		question.setHorizontalAlignment(JLabel.CENTER);
		question.setVerticalAlignment(JLabel.CENTER);
		question.setFont(new Font("Calligrapher", Font.BOLD + Font.ITALIC, 20));
		question.setBackground(new Color(250, 235, 155));
		question.setOpaque(true);
		question.setText(currentNode.getData());
		return question;
	}
	
	/**
	 * Return a label that displays the theme
	 * @return the label containing the title
	 */
	public JLabel setUpTitle() {
		ImageIcon icon = createImageIcon("icons/title.png");
		Image image = icon.getImage();
		icon = new ImageIcon(image.getScaledInstance(500, 120, Image.SCALE_DEFAULT));
		JLabel title = new JLabel(icon);		
		return title;
	}
	
	/**
	 * Return a label that displays the logo
	 * @return the label containing the logo
	 */
	public JLabel setUpLogo() {
		ImageIcon icon = createImageIcon("icons/logo.png");
		Image image = icon.getImage();
		icon = new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		JLabel logo = new JLabel(icon);		
		return logo;
	}
	
	/**
	 * Update the text of the question label
	 * @param answer the user's choice
	 */
	public void updateQuestion(String answer) {

		if (currentNode != null) {

			// if yes, go to left
			if (answer.equals("yes")) {
				currentNode = currentNode.getLeftChild();
				if (currentNode != null) {
					question.setText(currentNode.getData());
				}
			}

			// if no, go to right
			else if (answer.equals("no")) {
				currentNode = currentNode.getRightChild();
				if (currentNode != null) {
					question.setText(currentNode.getData());
				}
			}
		}
		
		// if restart, restart from the root
		if (answer.equals("restart")) {
			currentNode = gameTree.getRoot();
			question.setText(currentNode.getData());
		}
	}
}
