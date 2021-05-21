import java.util.*;

public class Fighter implements java.io.Serializable {

    // class variables
    public String name;
    private double currentHealthPercentage; // starts at 100?
    private ArrayList<Move> moves;

    // stats data, ratings from one to ten
    private int strength;
    private int speed;
    private int stamina;
    private int flyingPower;
    private int technologySupport;
    private int combatAbility;

    // accessor and modifier methods
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHP() {
        return this.currentHealthPercentage;
    }

    public void setHP(double currentHealthPercentage) {
        this.currentHealthPercentage = currentHealthPercentage;
    }

    public ArrayList<Move> getMoves() {
        return this.moves;
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }

    // constructors
    public Fighter(String name) {
        this.name = name;

    }

    public Fighter(String name, ArrayList<Move> moves) {
        this.name = name;
        this.moves = moves;

    }

    public Fighter(String name, int strength, int speed, int stamina, int flyingPower, int technologySupport,
            int combatAbility) {
        this.name = name;

        this.strength = strength;
        this.speed = speed;
        this.stamina = stamina;
        this.flyingPower = flyingPower;
        this.technologySupport = technologySupport;
        this.combatAbility = combatAbility;

        // method calculating overall ratings

        // print method
        System.out.println("New Fighter: " + name + " has stats " + strength + " " + speed + " " + stamina + " "
                + flyingPower + " " + technologySupport + " " + combatAbility);

    }

}
