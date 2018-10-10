package unrestrictedgame;

import java.io.File;

import javax.swing.JFrame;

/**
 * GUI Unrestricted Guessing Game
 * 
 * @author Nikki Wei
 * @version 1
 */

public class UnrestrictedGameApplication {
	
	/** Set the width of the frame*/
	public static final int FRAME_WIDTH = 1350;
	
	/** Set the height of the frame*/
	public static final int FRAME_HEIGHT = 750;
	
	/**
	 * Creates and draws the frame for the game. Start the game.
	 * @param args xml file path
	 */
	public static void main(String[] args) {
		
		// create a frame to hold the game panel
		JFrame gameFrame = new JFrame("Unrestricted Gussing Game");
		
		// set up the xml file
		File xmlFile = new File( args[0] );
		
		// add the game panel
		gameFrame.add(new UnrestrictedGameController( xmlFile ));
		
		// set size
		gameFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		// exit normally on closing the window
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// show frame
		gameFrame.setVisible(true);
	}
}
