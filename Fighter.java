import java.util.*;

public class Fighter implements java.io.Serializable {

    // class variables
    public String name;
    private double currentHealthPercentage; // starts at 100?
    private ArrayList<Move> moves;

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

}
