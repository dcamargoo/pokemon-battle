public class Main {

    public static void main(String[] args){

        System.out.println("\n * Welcome to the Pokemon Land! *\n");

        Trainer dan = new Trainer("Daniel");
        Trainer jon = new Trainer("Jonba");
        Trainer mar = new Trainer("Maria");

        Pokemon b = Pokedex.createPokemon("Bulbasaur");
        dan.tame(b, "Arthur");

        Pokemon c = Pokedex.createPokemon("Charmander");
        dan.tame(c, "Pyro");

        Pokemon c2 = Pokedex.createPokemon("Charmander");
        jon.tame(c2, "Peter");

        Pokemon s = Pokedex.createPokemon("Squirtle");
        mar.tame(s, "Aqua");

        Battle b1 = new Battle();
        b1.initiateFight(dan, jon);
    }
}
