/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4160.f573280ad modeling language!*/


import java.util.*;

// line 97 "model.ump"
// line 154 "model.ump"
public class Coord
{

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	//Coord Attributes
	private int col;
	private int row;

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Coord(int aX, int aY)
	{
		col = aX;
		row = aY;
	}

	//------------------------
	// INTERFACE
	//------------------------

	
	public Coord next(String direction) {
        if (direction.equals("up"))    return new Coord(row-1, col);
        if (direction.equals("down"))  return new Coord(row+1, col);
        if (direction.equals("left"))  return new Coord(row, col-1);
        if (direction.equals("right")) return new Coord(row, col+1);
        return this;
    }
	
	public boolean setX(int aX)
	{
		boolean wasSet = false;
		col = aX;
		wasSet = true;
		return wasSet;
	}

	public boolean setY(int aY)
	{
		boolean wasSet = false;
		row = aY;
		wasSet = true;
		return wasSet;
	}

	public int getX()
	{
		return col;
	}

	public int getY()
	{
		return row;
	}




	public String toString()
	{
		return super.toString() + "["+
				"col" + ":" + getX()+ "," +
				"row" + ":" + getY()+ "]";
	}
}