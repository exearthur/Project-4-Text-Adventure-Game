/*
 * Player.java
 * Author:  Arthur Pacheco
 * Submission Date:  04/11/2023
 *
 * Purpose: This class creates the player as an object that has values 
 * such as the x value and the y value which tell the location of the player.
 * The player also has methods within it for when they use the lamp or the key
 * throughout the game.
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

public class Player {
	//Instance variables for the player class
	private int xCoord;
    private int yCoord;
    private Lamp theLamp;
    private Key theKey;
    
    //this retrives the current x coordinate of the player 
    public int getX() {
    	return xCoord;
    }
    //this retrieves the current y coordinate of the player
    public int getY() {
    	return yCoord;
    }
    
    //this sets the x coordinate of the player 
    public void setX(int xCoord) {
    	this.xCoord = xCoord;
    }
    
    //this sets the y coordinate of the player
    public void setY(int yCoord) {
    	this.yCoord = yCoord;
    }
    
    //this retrieves the key
    public Key getKey() {
    	return theKey;  	
    }
    //this retrieves the lamp
    public Lamp getLamp() {
    	return theLamp;
    }
    
    //this sets the key
    public void setKey(Key theKey) {
    	this.theKey = theKey;
    }
    
    //this sets the lamp
    public void setLamp(Lamp theLamp) {
    	this.theLamp = theLamp;
    }

}
