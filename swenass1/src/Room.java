/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4160.f573280ad modeling language!*/


import java.util.*;

// line 83 "model.ump"
// line 110 "model.ump"
public class Room
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Room Attributes
  private String name;
  private List<Coord> doors;

  //Room Associations
  private Board board;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Room(String aName, Board aBoard)
  {
    name = aName;
    doors = new ArrayList<Coord>();
    boolean didAddBoard = setBoard(aBoard);
    if (!didAddBoard)
    {
      throw new RuntimeException("Unable to create room due to board");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetMany */
  public boolean addDoor(Coord aDoor)
  {
    boolean wasAdded = false;
    wasAdded = doors.add(aDoor);
    return wasAdded;
  }

  public boolean removeDoor(Coord aDoor)
  {
    boolean wasRemoved = false;
    wasRemoved = doors.remove(aDoor);
    return wasRemoved;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template attribute_GetMany */
  public Coord getDoor(int index)
  {
    Coord aDoor = doors.get(index);
    return aDoor;
  }

  public Coord[] getDoors()
  {
    Coord[] newDoors = doors.toArray(new Coord[doors.size()]);
    return newDoors;
  }

  public int numberOfDoors()
  {
    int number = doors.size();
    return number;
  }

  public boolean hasDoors()
  {
    boolean has = doors.size() > 0;
    return has;
  }

  public int indexOfDoor(Coord aDoor)
  {
    int index = doors.indexOf(aDoor);
    return index;
  }
  /* Code from template association_GetOne */
  public Board getBoard()
  {
    return board;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBoard(Board aBoard)
  {
    boolean wasSet = false;
    if (aBoard == null)
    {
      return wasSet;
    }

    Board existingBoard = board;
    board = aBoard;
    if (existingBoard != null && !existingBoard.equals(aBoard))
    {
      existingBoard.removeRoom(this);
    }
    board.addRoom(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Board placeholderBoard = board;
    this.board = null;
    if(placeholderBoard != null)
    {
      placeholderBoard.removeRoom(this);
    }
  }


  /**
   * checks if player or weapon is in room
   */
  // line 90 "model.ump"
   public void isWithin(Coord p){
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "board = "+(getBoard()!=null?Integer.toHexString(System.identityHashCode(getBoard())):"null");
  }
}