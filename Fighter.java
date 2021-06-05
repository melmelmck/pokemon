import java.util.*;

public class Fighter implements java.io.Serializable {

    // class variables
    public String name;
    private double currentHealthPercentage; // starts at 100?
    private double score;
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
    
    public double getScore(){
        return this.score;
    }
    
    public void setScore(double Score){
       this.score = score;
    }

    public ArrayList<Move> getMoves() {
        return this.moves;
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStamina() {
        return this.stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getFlyingPower() {
        return this.flyingPower;
    }

    public void setFlyingPower(int flyingPower) {
        this.flyingPower = flyingPower;
    }

    public int getTechnologySupport() {
        return this.technologySupport;
    }

    public void setTechnologySupport(int technologySupport) {
        this.technologySupport = technologySupport;
    }

    public int getCombatAbility() {
        return this.combatAbility;
    }

    public void setCombatAbility(int combatAbility) {
        this.combatAbility = combatAbility;
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
        overallrating();

        // print method
        System.out.println("New Fighter: " + name + " has stats " + strength + " " + speed + " " + stamina + " "
                + flyingPower + " " + technologySupport + " " + combatAbility);

    }

    // attack/move related methods

    private double calculateCurrentHP(double critDamage) {

        double currentHP = getHP() - critDamage;

        setHP(currentHP);

        return currentHP;

    }

    public void printStats() {
        // print method
        System.out.println("New Fighter: " + getName() + " has stats " + getStrength() + " " + getSpeed() + " "
                + getStamina() + " " + getFlyingPower() + " " + getTechnologySupport() + " " + getCombatAbility());
    }

    // calculate overall score
    
    public void overallrating(String name, int strength, int speed, int stamina, int flyingPower, int technologySupport,
            int combatAbility){
        Integer total = strength + speed + stamina + flyingPower + technologySupport + combatAbility; 
        Integer rating = total / 6;
        System.out.println("Overall Rating" + rating);
    }
    
    public void printscore(double critDamage){
       double cscore = getScore + critDamage;
       setScore(cscore);
       System.out.println ("Current Score: " + cscore);
    }

}
