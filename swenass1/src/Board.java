/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4160.f573280ad modeling language!*/


import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javax.swing.JFileChooser;

// line 38 "model.ump"
// line 142 "model.ump"
public class Board
{

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	//Board Attributes
	//private List<String> board;
	private String[][] board;  // the array representing the board
	private int rows;                  // the height of the board
	private int cols;                   // the width of the board

	//Board Associations
	private List<Room> rooms;
	private CluedoGame cluedoGame;

	private JFileChooser fileChooser;


	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Board()
	{
		load();
	
	}

	//------------------------
	// INTERFACE
	//------------------------

	
	/**
	 * Reads the cluedo txt file for the board layout to set up
	 * placement for board layout of rooms and starting positions etc.
	 */
	public void load() {

		fileChooser = new JFileChooser();
		
//		int result = fileChooser.showOpenDialog(null);

//		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", ".txt");
//		fileChooser.setFileFilter(filter);
//
//		int returnVal = fileChooser.showOpenDialog(null);
//		if(returnVal == fileChooser.APPROVE_OPTION) {
//			System.out.println("You picked: " + fileChooser.getSelectedFile().getName());
//		}

		BufferedReader reader = null;
		try {			
			reader = new BufferedReader(new FileReader(new File("clue-board.txt")));

			for(String line = reader.readLine();line!=null;reader.readLine()) {
				for(int row=0;row<board.length;row++) {
					for(int col=0;col<board.length;col++) {
						String values[] = line.split("");
						board[row][col]=values[col];
						System.out.println(values[col]);
					}
				}
			}

		}catch(IOException e) {
			e.printStackTrace();
		}

		draw();
	}


	/** Draw the board */
	public void draw() {
		// draw board
		for(int row = 0; row<rows; row++)
			for(int col = 0; col<cols; col++) {
				System.out.println(board[row][col]);
			}
		System.out.println("\n");
	}

	/* Code from template association_GetMany */
	public Room getRoom(int index)
	{
		Room aRoom = rooms.get(index);
		return aRoom;
	}

	/**
	 * TODO:creating and hold list rooms incl. entire space
	 */
	public List<Room> getRooms()
	{
		List<Room> newRooms = Collections.unmodifiableList(rooms);
		return newRooms;
	}

	public int numberOfRooms()
	{
		int number = rooms.size();
		return number;
	}

	public boolean hasRooms()
	{
		boolean has = rooms.size() > 0;
		return has;
	}

	public int indexOfRoom(Room aRoom)
	{
		int index = rooms.indexOf(aRoom);
		return index;
	}
	/* Code from template association_GetOne */
	public CluedoGame getCluedoGame()
	{
		return cluedoGame;
	}
	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfRooms()
	{
		return 0;
	}
	/* Code from template association_AddManyToOne */
	public Room addRoom(String aName)
	{
		return new Room(aName, this);
	}

	public boolean addRoom(Room aRoom)
	{
		boolean wasAdded = false;
		if (rooms.contains(aRoom)) { return false; }
		Board existingBoard = aRoom.getBoard();
		boolean isNewBoard = existingBoard != null && !this.equals(existingBoard);
		if (isNewBoard)
		{
			aRoom.setBoard(this);
		}
		else
		{
			rooms.add(aRoom);
		}
		wasAdded = true;
		return wasAdded;
	}

	public boolean removeRoom(Room aRoom)
	{
		boolean wasRemoved = false;
		//Unable to remove aRoom, as it must always have a board
		if (!this.equals(aRoom.getBoard()))
		{
			rooms.remove(aRoom);
			wasRemoved = true;
		}
		return wasRemoved;
	}
	/* Code from template association_AddIndexControlFunctions */
	public boolean addRoomAt(Room aRoom, int index)
	{  
		boolean wasAdded = false;
		if(addRoom(aRoom))
		{
			if(index < 0 ) { index = 0; }
			if(index > numberOfRooms()) { index = numberOfRooms() - 1; }
			rooms.remove(aRoom);
			rooms.add(index, aRoom);
			wasAdded = true;
		}
		return wasAdded;
	}

	public boolean addOrMoveRoomAt(Room aRoom, int index)
	{
		boolean wasAdded = false;
		if(rooms.contains(aRoom))
		{
			if(index < 0 ) { index = 0; }
			if(index > numberOfRooms()) { index = numberOfRooms() - 1; }
			rooms.remove(aRoom);
			rooms.add(index, aRoom);
			wasAdded = true;
		} 
		else 
		{
			wasAdded = addRoomAt(aRoom, index);
		}
		return wasAdded;
	}

	public void delete()
	{
		for(int i=rooms.size(); i > 0; i--)
		{
			Room aRoom = rooms.get(i - 1);
			aRoom.delete();
		}
		CluedoGame existingCluedoGame = cluedoGame;
		cluedoGame = null;
		if (existingCluedoGame != null)
		{
			existingCluedoGame.delete();
		}
	}


	/**
	 * player positions -> a getPlayerPosition(Player) method to get positions?
	 */
	// line 48 "model.ump"
	public Coord getPosition(Player p){
		return null; //TODO:
	}


	/**
	 * holds player positions
	 * starting positions of players
	 */
	// line 54 "model.ump"
	public Coord getStartPosition(String String){
		return null; //TODO:
	}


	public String toString()
	{
		return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
				"  " + "cluedoGame = "+(getCluedoGame()!=null?Integer.toHexString(System.identityHashCode(getCluedoGame())):"null");
	}
}