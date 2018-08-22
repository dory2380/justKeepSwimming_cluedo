/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4160.f573280ad modeling language!*/


import java.util.*;

// line 15 "model.ump"
// line 136 "model.ump"
public class Player
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Attributes
  private String playerName;
  private boolean activePlayer;
  private Coord coord;

  //Player Associations
  private List<Card> cards;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Player(String aPlayerName, boolean aActivePlayer, Coord aCoord)
  {
    playerName = aPlayerName;
    activePlayer = aActivePlayer;
    coord = aCoord;
    cards = new ArrayList<Card>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPlayerName(String aPlayerName)
  {
    boolean wasSet = false;
    playerName = aPlayerName;
    wasSet = true;
    return wasSet;
  }

  public boolean setActivePlayer(boolean aActivePlayer)
  {
    boolean wasSet = false;
    activePlayer = aActivePlayer;
    wasSet = true;
    return wasSet;
  }

  public boolean setCoord(Coord aCoord)
  {
    boolean wasSet = false;
    coord = aCoord;
    wasSet = true;
    return wasSet;
  }

  public String getPlayerName()
  {
    return playerName;
  }

  /**
   * TODO:set of Cards -> hand;
   * active player
   */
  public boolean getActivePlayer()
  {
    return activePlayer;
  }

  public Coord getCoord()
  {
    return coord;
  }
  /* Code from template attribute_IsBoolean */
  public boolean isActivePlayer()
  {
    return activePlayer;
  }

  /* Code from template association_GetMany */
  public Card getCard(int index)
  {
    Card aCard = cards.get(index);
    return aCard;
  }

  public List<Card> getCards()
  {
    List<Card> newCards = Collections.unmodifiableList(cards);
    return newCards;
  }

  public int numberOfCards()
  {
    int number = cards.size();
    return number;
  }

  public boolean hasCards()
  {
    boolean has = cards.size() > 0;
    return has;
  }

  public int indexOfCard(Card aCard)
  {
    int index = cards.indexOf(aCard);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCoords()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */


  public boolean addCard(Card aCard)
  {
    boolean wasAdded = false;
    if (cards.contains(aCard)) { return false; }
    Player existingPlayer = aCard.getPlayer();
    boolean isNewPlayer = existingPlayer != null && !this.equals(existingPlayer);
    if (isNewPlayer)
    {
      aCard.setPlayer(this);
    }
    else
    {
      cards.add(aCard);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCard(Card aCard)
  {
    boolean wasRemoved = false;
    //Unable to remove aCard, as it must always have a player
    if (!this.equals(aCard.getPlayer()))
    {
      cards.remove(aCard);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCardAt(Card aCard, int index)
  {  
    boolean wasAdded = false;
    if(addCard(aCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCards()) { index = numberOfCards() - 1; }
      cards.remove(aCard);
      cards.add(index, aCard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCardAt(Card aCard, int index)
  {
    boolean wasAdded = false;
    if(cards.contains(aCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCards()) { index = numberOfCards() - 1; }
      cards.remove(aCard);
      cards.add(index, aCard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCardAt(aCard, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=cards.size(); i > 0; i--)
    {
      Card aCard = cards.get(i - 1);
      aCard.delete();
    }
  }

  // line 25 "model.ump"
   public void refute(String room, String character, String weapon){
    
  }

  // line 27 "model.ump"
   public void suggest(String room, String character, String weapon){
    
  }

  // line 29 "model.ump"
   private void accuse(String room, String character, String weapon){
    
  }

  // line 33 "model.ump"
   public Integer rollDice(){
    return 0;
  }


  public String toString()
  {
    return super.toString() + "["+
            "playerName" + ":" + getPlayerName()+ "," +
            "activePlayer" + ":" + getActivePlayer()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "coord" + "=" + (getCoord() != null ? !getCoord().equals(this)  ? getCoord().toString().replaceAll("  ","    ") : "this" : "null");
  }
}