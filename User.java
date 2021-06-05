import java.util.*;

public class User {

  // class variables
  public String name;
  private Fighter f;
  private String fighterName;

  // roung specific
  private int roundsPlayed;
  private int roundsWon;
  private Queue<Move> movesPlayed;
  private int userLevel;

  // accessor and modifier methods
  // Getter
  public int getUserLevel() {
    return userLevel;
  }

  // constructor
  public User(String name, Fighter fighter) {
    this.name = name;
    this.f = fighter;
    this.fighterName = name + " " + f.getName();
    this.roundsPlayed = 0;
    this.movesPlayed = new LinkedList<Move>();
    this.userLevel = 0;
  }

  // Setter
  public void setUserLevel(int userLevel) {
    this.userLevel = userLevel;
  }

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String newName) {
    this.name = newName;
  }

  // Getter
  public Fighter getFighter() {
    return f;
  }

  // Setter
  public void setFighter(Fighter f) {
    this.f = f;
  }

  // Getter
  public int getRoundsPlayed() {
    return roundsPlayed;
  }

  // Setter
  public void setRoundsPlayed(int newRoundsPlayed) {
    this.roundsPlayed = newRoundsPlayed;
  }

  public void playedRound() {
    this.roundsPlayed = this.roundsPlayed + 1;
  }

  // Getter
  public int getRoundsWon() {
    return roundsWon;
  }

  // Setter
  public void setRoundsWon(int newRoundsWon) {
    this.roundsWon = newRoundsWon;
  }

  public void wonRound() {
    this.roundsWon = this.roundsWon + 1;
    System.out.println("Congrats on winning!");
  }

  public void chooseFighter() {
    // Game g = new Game(); //create an instance of Game class
    // System.out.println("Here are your character choices: " +
    // g.printCharacters()); //print list of fighters
    System.out.println("Choose your fighter");
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      fighterName = s.nextLine().toLowerCase();
      f = new Fighter(fighterName); // create a new fighter with the name
    }
  }

  public void createUser() {
    Scanner sc = new Scanner(System.in);
    System.out.println("User name: ");
    while (sc.hasNext()) {
      name = sc.nextLine();
    }
  }

  public void updatePlayerLevel() {
    userLevel++;
  }
}
