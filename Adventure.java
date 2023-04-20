/*
 * Adventure.java
 * Author:  Arthur Pacheco 
 * Submission Date:  04/11/2023
 *
 * Purpose: This Class is where the entire text adventure game is put together.
 * All the objects that have been created within the other classes come together to
 * form this adventure. In this Class there are tons of scenarios that play out based on
 * the inputs of the user. They can explore, open the chest, look around, etc. This is 
 * essentially where anything and everything that can happen in the game is defined.
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

import java.util.Scanner;
public class Adventure {
	public static Player getKey(Player player, Map map) {
		
		Room theRoom = map.getRoom(player.getX(), player.getY());
		
		//this sets the if statement if there is no key in the room
		if (theRoom.getKey() == null) {
			System.out.println("No key present");
			return player;
		}
		
		//this is the else statement if there is a key inside of the room
		else {
			if (player.getKey() == null) {
				System.out.println("OK");
				player.setKey(theRoom.getKey());
				theRoom.clearKey();
				return player;
			}
			else {
				System.out.println("Player already has key");
				return player;
			}
		}
	}
	
	//if the lamp is in the room, then the player can add the lamp into their inventory
	public static Player getLamp(Player player, Map map) {
			
		Room theRoom = map.getRoom(player.getX(), player.getY());
		
		//in such case that there is no lamp...
		if (theRoom.getLamp() == null) {
			System.out.println("No lamp present");
			return player;
		}
		
		//in such case that there is a lamp in the room...
		else {
			if (player.getLamp() == null) {
				System.out.println("OK");
				player.setLamp(theRoom.getLamp());
				theRoom.clearLamp();
				return player;
			}
			else {
				System.out.println("Player already has lamp");
				return player;
			}
		}
	}
	
	//the player, once they have the lamp can light it if they choose to
	public static Player lightLamp(Player player) {
			
		//if the player has the lamp
		if (player.getLamp() != null) {
			//if lamp is Lit
			if (player.getLamp().getIsLit()) {
				System.out.println("Lamp is already lit");
				return player;
			}
			//if the lamp is not lit
			else {
				System.out.println("OK");
				player.getLamp().setIsLit(true);
				return player;
			}
		}
		//in such case that the player does not have the lamp...
		else {
			System.out.println("You don't have a lamp to light");
			return player;
		}
	}
	
	//this is what allows the player to move freely from room to room
	public static Player movePlayer(String userInput, Player player, Map map) {
			
		Room theRoom = map.getRoom(player.getX(), player.getY());
		
		//if statement for when the player decides to move north
		if (userInput.equalsIgnoreCase("north") && theRoom.canGoNorth() && !isPlayerAtRisk(player, map)) {
			//if player stumbles into a grue
			if (isPlayerAtRisk(player, map)) {
				System.out.println("You stumbled into a passing grue, and have been eaten.");
				System.exit(0);
			}
			//player moves north
			player.setX(player.getX() - 1);
			return player;
		}
		//if statement for when the player decides to move south
		else if (userInput.equalsIgnoreCase("south") && theRoom.canGoSouth() && !isPlayerAtRisk(player, map)) {
			//if player stumbles into grue 
			if (isPlayerAtRisk(player, map)) {
				System.out.println("You stumbled into a passing grue, and have been eaten.");
				System.exit(0);
			}
			//player moves south
			player.setX(player.getX() + 1);
			return player;
		}
		//if statement for when the player decides to move east
		else if (userInput.equalsIgnoreCase("east") && theRoom.canGoEast() && !isPlayerAtRisk(player, map)) {
			//if player stumbles into grue 
			if (isPlayerAtRisk(player, map)) {
				System.out.println("You stumbled into a passing grue, and have been eaten.");
				System.exit(0);
			}
			//player moves east
			player.setY(player.getY() + 1);
			return player;
		}
		//if statement for when the player decides to move west
		else if (userInput.equalsIgnoreCase("west") && theRoom.canGoWest() && !isPlayerAtRisk(player, map)) {
			//if player stumbles into grue 
			if (isPlayerAtRisk(player, map)) {
				System.out.println("You stumbled into a passing grue, and have been eaten.");
				System.exit(0);
			}
			//player moves west
			player.setY(player.getY() - 1);
			return player;
		}
		//else statement for when the player decides to move in an invalid direction 
		else {
			System.out.println("Can't go that way");
		}
			
		return player;
	}
	
	//checks to see if player is at risk of dying 
	//also checks to see if the player has a lamp
	public static boolean isPlayerAtRisk(Player player, Map map) {
		Room theRoom = map.getRoom(player.getX(), player.getY());
		if ((theRoom.isDark() && (player.getLamp() == null)) || (theRoom.isDark() && (!player.getLamp().getIsLit()))) {
			System.out.println("You have stumbled into a passing grue, and have been eaten.");
			System.exit(0);
			return true;
		}
		else {
			return false;
		}
	}
	
	//this gives the room description of the room that the player is currently in
	public static void look(Player player, Map map, boolean giveDetails) {
		
		Room theRoom = map.getRoom(player.getX(), player.getY());
		
		//when there is no light
		if((theRoom.isDark() && player.getLamp() == null) || (theRoom.isDark() && (!player.getLamp().getIsLit()))) {
			System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
		}
		else {
			System.out.println(theRoom.getDescription());
		}
		
		//room description
		if (giveDetails) {
			if (theRoom.getLamp() != null) {
				System.out.println("There is an old oil lamp here that was made long ago.");
			}
			if (theRoom.getKey() != null) {
				System.out.println("You see the outline of a key on a dusty shelf that's covered in dust.");
			}
			if (theRoom.getKey() != null) {
				System.out.println("There is a large, wooden, massive, oaken chest here with the word 'CHEST' carved into it");
			}
			
			System.out.print("Exits are: ");
				
			if (theRoom.canGoNorth()) {
				System.out.println("north");
			}
			if (theRoom.canGoSouth()) {
				System.out.println("south");
			}
			if (theRoom.canGoEast()) {
				System.out.println("east");
			}
			if (theRoom.canGoWest()) {
				System.out.println("west");
			}
		}
	}
	
	//allows the player to unlock the chest if they have a key with them
	public static Chest unlockChest(Player player, Map map) {
			
		Room theRoom = map.getRoom(player.getX(), player.getY());
		Chest chest = theRoom.getChest();
		Key key = player.getKey();
		
		//if the player has the key
		if (!(chest == null) && !(key == null) && chest.isLocked() == true) {
			System.out.println("OK");
			key.use(chest);
			return chest;
		}
		//if chest is already open
		else if (!(chest == null) && chest.isLocked() == false) {
			System.out.println("The chest is unlocked.");
			return chest;
		}
		//if the player does not have the key
		else if (!(chest == null) && key == null) {
			System.out.println("Need a key to do any unlocking");
			return chest;
		}
		//if there is no chest
		else {
			System.out.println("No chest to unlock");
			return chest;
		}
	}
	
	//allows the player open a chest
	public static void openChest(Player player, Map map) {
			
		Room theRoom = map.getRoom(player.getX(), player.getY());
		Chest chest = theRoom.getChest();
		
		//if the player opens a chest
		if (!(chest == null) && chest.isLocked() == false) {
			System.out.println(chest.getContents());
			System.exit(0);
		}
		//if the chest is locked when the player tries to open
		else if (!(chest == null) && chest.isLocked() == true) {
			System.out.println("The chest is locked");
		}
		//if no chest is present
		else {
			System.out.println("No chest present");
		}
		
	}
	
	//controls for the game
	public static void main(String[] args) {
		
		//initializing the scanner
		Scanner sc = new Scanner(System.in);
		
		//game introductions
		System.out.println("Welcome to UGA Adventures: Episode 1\n" 
		+ "The adventure of the Cave of Redundance Adventure\n" 
		+ "By: Arthur Pacheco\n");
		
		//initialization of objects
		Player player = new Player();
		player.setX(0);
		player.setY(0);
		Map map = new Map();
		
		String userInput = "";
		Room theRoom = map.getRoom(0, 0);
		Lamp lamp = new Lamp();
		Key key = new Key();
		Chest chest = new Chest();
		
		boolean play = true;
		
		//the while loop for when the player is within a room to the point where they decide to leave the room
		while (play) {
			
			//this sets the variables to where the player entered
			theRoom = map.getRoom(player.getX(), player.getY());
			lamp = theRoom.getLamp();
			key = theRoom.getKey();
			chest = theRoom.getChest();
			
			look(player, map, false);
			
			//user input
			userInput = sc.nextLine().trim().toLowerCase();
			
			//this keeps the player in the room until they decide to leave
			while (!(userInput.equalsIgnoreCase("north")) && !(userInput.equalsIgnoreCase("south")) && !(userInput.equalsIgnoreCase("east")) && !(userInput.equalsIgnoreCase("west"))) {
				
				//actions that can be performed while the player is inside the room
				if (userInput.equalsIgnoreCase("look")) {
					look(player, map, true);
				}
				else if (userInput.equalsIgnoreCase("get lamp")) {
					player = getLamp(player, map);
				}
				else if (userInput.equalsIgnoreCase("get key")) {
					player = getKey(player, map);
				}
				else if (userInput.equalsIgnoreCase("light lamp")) {
					player = lightLamp(player);
				}
				else if (userInput.equalsIgnoreCase("unlock chest")) {
					chest = unlockChest(player, map);
				}
				else if (userInput.equalsIgnoreCase("open chest")) {
					openChest(player, map);
				}
				else {
					System.out.println("I'm sorry I don't know how to do that");
				}
				
				userInput = sc.nextLine().trim().toLowerCase();
			}
			
			player = movePlayer(userInput, player, map);	
		}
		
		//ends the game
		sc.close();
		System.exit(0);
	}
	
	
}
