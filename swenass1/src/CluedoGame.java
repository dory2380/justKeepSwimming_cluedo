/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4160.f573280ad modeling language!*/
/**
	 * team: justKeepSwimming (Doris Tam & Priyal Patel)
	 */

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Scanner; //for user input


// line 2 "model.ump"
// line 104 "model.ump"
public class CluedoGame
{

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	//CluedoGame Attributes
	private List<Player> players;
	private Board board;
	private Set<Card> envelope;

	private Scanner user_input = new Scanner( System.in );
	private Map<Character, String> fileCharacterToSquareType;  // character in file -> game object


	//------------------------
	// CONSTRUCTOR
	//------------------------
	
	public CluedoGame()
	{		
		//INTIALIZE PLAYERS
		int numOfPlayers = 0;
		do{
			System.out.print("How many players are there? [3-6]:");
			if(user_input.hasNextInt()) {
				numOfPlayers = user_input.nextInt();
			}else {
				user_input.next();
				System.out.println("Please enter a number");
			}
		}while(numOfPlayers<3 || numOfPlayers>6);
		
		System.out.println("There are "+numOfPlayers+" players");

		//INITIALIZE BOARD
		//board.draw();
		board = new Board();
		players = new ArrayList<Player>();
		envelope = new HashSet<Card>();
	}

	//------------------------
	// INTERFACE
	//------------------------

	/* Code from template attribute_SetMany */
	public boolean addPlayer(Player aPlayer)
	{
		boolean wasAdded = false;
		wasAdded = players.add(aPlayer);
		return wasAdded;
	}

	public boolean removePlayer(Player aPlayer)
	{
		boolean wasRemoved = false;
		wasRemoved = players.remove(aPlayer);
		return wasRemoved;
	}

	public boolean setBoard(Board aBoard)
	{
		boolean wasSet = false;
		board = aBoard;
		wasSet = true;
		return wasSet;
	}

	/* Code from template attribute_GetMany */
	public Player getPlayer(int index)
	{
		Player aPlayer = players.get(index);
		return aPlayer;
	}

	public Player[] getPlayers()
	{
		Player[] newPlayers = players.toArray(new Player[players.size()]);
		return newPlayers;
	}

	public int numberOfPlayers()
	{
		int number = players.size();
		return number;
	}

	public boolean hasPlayers()
	{
		boolean has = players.size() > 0;
		return has;
	}

	public int indexOfPlayer(Player aPlayer)
	{
		int index = players.indexOf(aPlayer);
		return index;
	}

	/**
	 * state of game board
	 */
	public Board getBoard()
	{
		return board;
	}

	/**
	 * TODO:murder weapon, murder room, and murderer
	 * no set in umple
	 */
	public Card[] getEnvelope()
	{
		Card[] newEnvelope = envelope.toArray(new Card[envelope.size()]);
		return newEnvelope;
	}

	public void delete()
	{
		Board existingBoard = board;
		board = null;
		if (existingBoard != null)
		{
			existingBoard.delete();
		}
	}

	private void initialiseMappings() {
		fileCharacterToSquareType = new HashMap<Character, String>();
		fileCharacterToSquareType.put('.',  "empty");
		fileCharacterToSquareType.put('A', "empty");  // initial position of worker is an empty square beneath

		//starting position
		fileCharacterToSquareType.put('[',  "mrs white");
		fileCharacterToSquareType.put('!',  "mr green");
		fileCharacterToSquareType.put('$',  "mrs peacock");
		fileCharacterToSquareType.put('?',  "prof plum");
		fileCharacterToSquareType.put('%',  "miss scarlett");
		fileCharacterToSquareType.put('/',  "col mustard");

		fileCharacterToSquareType.put('K',  "kitchen");
		fileCharacterToSquareType.put('B',  "ballroom");
		fileCharacterToSquareType.put('C',  "convervatory");
		fileCharacterToSquareType.put('O',  "billiard room");
		fileCharacterToSquareType.put('L',  "library");
		fileCharacterToSquareType.put('S',  "study");
		fileCharacterToSquareType.put('H',  "hall");
		fileCharacterToSquareType.put('U',  "lounge");
		fileCharacterToSquareType.put('I',  "dining room");

		fileCharacterToSquareType.put('-',  "wall");
		fileCharacterToSquareType.put('D',  "door");
	}


	public String toString()
	{
		return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
				"  " + "state" + "=" + (getBoard() != null ? !getBoard().equals(this)  ? getBoard().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
				"  " + "envelope" + "=" + (getEnvelope() != null ? !getEnvelope().equals(this)  ? getEnvelope().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
				"  " + "board = "+(getBoard()!=null?Integer.toHexString(System.identityHashCode(getBoard())):"null");
	}

	public static void main(String[] args) {
		new CluedoGame();	





	}
}