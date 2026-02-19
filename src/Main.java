public class Main {

    public static void main(String[] args){

        Trainer dan = new Trainer("Daniel");
        Trainer jon = new Trainer("Jonba");
        Trainer mar = new Trainer("Maria");

        Pokemon b = Pokedex.createPokemon("Bulbasaur");
        dan.tame(b, "Arthur");
        System.out.println(dan.getAllPokemons());

        Pokemon c = Pokedex.createPokemon("Charmander");
        jon.tame(c, "Bobo");
        System.out.println(jon.getAllPokemons());

        Pokemon s = Pokedex.createPokemon("Squirtle");
        mar.tame(s, "Choco");
        System.out.println(mar.getAllPokemons());
    }

}
