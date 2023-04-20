/*
 * Lamp.java
 * Author:  Arthur Pacheco
 * Submission Date:  04/11/2023
 *
 * Purpose: This is the class that creates the lamp object in the game.
 * This class specifically checks for whether or not the lamp has been 
 * lit or not in the game.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */

public class Lamp {
	
	/*
	 * Instance variables and methods go here, you're responsible for 
	 * choosing and naming them.
	 */
	private boolean isLit;
	
	//this whole thing sets the lamp as either lit or not lit 
	//kind of funny when you think about it.
	//Like ITS LITTTTTTTT :)
	public void setIsLit(boolean newIsLit) {
		isLit = newIsLit;
	}
	
	public boolean getIsLit() {
		return isLit;
	}


	
	
}
