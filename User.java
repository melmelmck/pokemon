import java.util.*;

public class User {

    // class variables
    public String name;
    private Fighter f;
    private String fighterName;

    // roung specific
    private int roundsPlayed;
    private Queue<Move> movesPlayed;

    // accessor and modifier methods
    createUser();
    chooseFighter();


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

public chooseFighter(){
  Game g = new Game(); //create an instance of Game class
  System.out.println("Here are your character choices: " + g.printCharacters()); //print list of fighters
  System.out.println("Choose your fighter");
  Scanner s = new Scanner(System.in);
  while(s.hasNext){
    fighterName = s.nextLine(); 
    f = new Fighter(fighterName); //create a new fighter with the name
  }
}

public createUser(){
  Scanner sc = new Scanner(System.in);
  System.out.println("User name: ");
  while(sc.hasNext){
    name = sc.nextLine(); 
  }
}
