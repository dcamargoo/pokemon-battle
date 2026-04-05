import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trainer {

    private static int nextID = 1;

    private final int ID;
    private String name;
    private double cash;
    private final List<Pokemon> pokemonInventory;
    private int wins;

    public Trainer(String name){
        this.ID = nextID++;
        this.name = name;
        this.cash = 100.0;
        this.pokemonInventory = new ArrayList<>();
        this.wins = 0;
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

    public int getWins(){ return this.wins; }

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

    public void increaseWins(){
        this.wins++;
    }

    public void tame(Pokemon pokemon, String pokemonName){
        if(pokemon == null) return;
        if(pokemonInventory.contains(pokemon)) return;
        pokemonInventory.add(pokemon);
        pokemon.setName(pokemonName);
    }

    public String showPokemons() {
        if (pokemonInventory.isEmpty()) {
            return "This trainer has no Pokemons.";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pokemonInventory.size(); i++) {
            Pokemon p = pokemonInventory.get(i);
            sb.append(i + 1)
                    .append(" - ")
                    .append(p.getName())
                    .append(" (")
                    .append(p.getSpecie())
                    .append(") | Type: ")
                    .append(p.getType())
                    .append(" | HP: ")
                    .append(p.getHp())
                    .append("/")
                    .append(p.getMaxHp())
                    .append(" | Level: ")
                    .append(p.getLevel())
                    .append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", cash=" + cash +
                ", pokemonInventory=" + pokemonInventory +
                ", wins: " + wins +
                '}';
    }
}
