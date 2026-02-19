import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trainer {

    private static int nextID = 1;

    private final int ID;
    private String name;
    private double cash;
    private final List<Pokemon> pokemonInventory;

    public Trainer(String name){
        this.ID = nextID++;
        this.name = name;
        this.cash = 100.0;
        this.pokemonInventory = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public List<Pokemon> getAllPokemons() {
        return Collections.unmodifiableList(pokemonInventory);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCash(double cash) {
        this.cash = Math.max(0, cash);
    }

    public void increaseCash(double amount){
        System.out.println("Trainer " + this.name + " received $" + amount + "!");
        if(amount < 0) return;
        this.cash += amount;
    }

    public void decreaseCash(double amount){
        System.out.println("Trainer " + this.name + " lost $" + amount + "!");
        if(amount < 0) return;
        this.cash = Math.max(0, this.cash - amount);
    }

    public void tame(Pokemon pokemon, String pokemonName){
        if(pokemon == null) return;
        if(pokemonInventory.contains(pokemon)) return;
        pokemonInventory.add(pokemon);
        pokemon.setName(pokemonName);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", cash=" + cash +
                ", pokemonInventory=" + pokemonInventory +
                '}';
    }
}
