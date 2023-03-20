import java.util.Random;

public class Pokemon {
    static String region = "Kanto";
    String type = "Unknown";
    String name = "Unknown";
    int damage = 1;
    static int damage_base = 15; // all pokemon use this as base
    // each pokemon has a set of moves
    Move[] moves;

    Pokemon(String name, String type, double damage_multiplier,
            Move[] moves) {
        this.name = name;
        this.type =  type;
        this.damage = (int) (Pokemon.damage_base * damage_multiplier);
        this.moves = moves;
    }
    public String toString() {
        return this.name + " (" + this.type + ")" ;
    }

    public String attack() {
        // An attack is a random move
        Random generator = new Random();
        Move move = this.moves[generator.nextInt(this.moves.length)];
        return this + " uses " + move + " for " 
            + move.damage + " damage";
    }

    public static void main(String[] args) {
        // These moves can be stored in a separate file
        // and managed by some other team member
        Move Growl = new Move("Growl", 5);
        Move Scratch = new Move("Scratch", 12);
        Move Ember = new Move("Ember", 20);
        Move Slash = new Move("Slash", 32);

        // Charmander has these four moves
        // In the game, it 'learns' these progressively
        Pokemon Charmander = new Pokemon("Charmander", "Fire", 2.1,
                new Move[]{Growl, Scratch, Ember, Slash});

        System.out.println(Charmander.attack());
    }
}

class Move {
    String name = "";
    int damage = 0;
    public String toString() {
        return this.name ;
    }
    Move(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
}