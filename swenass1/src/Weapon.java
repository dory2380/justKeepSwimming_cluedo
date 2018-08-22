/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4160.f573280ad modeling language!*/


import java.util.*;

// line 93 "model.ump"
// line 115 "model.ump"
public class Weapon
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Weapon Attributes
  private Coord position;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Weapon(Coord aPosition)
  {
    position = aPosition;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPosition(Coord aPosition)
  {
    boolean wasSet = false;
    position = aPosition;
    wasSet = true;
    return wasSet;
  }

  public Coord getPosition()
  {
    return position;
  }



  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "position" + "=" + (getPosition() != null ? !getPosition().equals(this)  ? getPosition().toString().replaceAll("  ","    ") : "this" : "null");
  }
}