import java.util.*;

public class Pokedex {

    private static final Map<String, Pokemon> POKEMAP;

    static {
        Map<String, Pokemon> temp = new HashMap<>();

        temp.put("Bulbasaur", createBasePokemon(
                "Bulbasaur",
                PokemonType.GRASS,
                100,
                Map.of(
                        "Vine Whip", new Attack("Vine Whip", 25),
                        "Tackle", new Attack("Tackle", 15),
                        "Razor Leaf", new Attack("Razor Leaf", 45)
                )
        ));

        temp.put("Charmander", createBasePokemon(
                "Charmander",
                PokemonType.FIRE,
                100,
                Map.of(
                        "Ember", new Attack("Ember", 35),
                        "Scratch", new Attack("Scratch", 25),
                        "Flamethrower", new Attack("Flamethrower", 50)
                )
        ));

        temp.put("Squirtle", createBasePokemon(
                "Squirtle",
                PokemonType.WATER,
                100,
                Map.of(
                        "Splash", new Attack("Splash", 35),
                        "Tackle", new Attack("Tackle", 30),
                        "Water Attack", new Attack("Water Attack", 45)
                )
        ));

        POKEMAP = Collections.unmodifiableMap(temp);
    }

    private static Pokemon createBasePokemon(String specie, PokemonType type, int hp, Map<String, Attack> attacks) {
        return new Pokemon(specie, specie, type, hp, attacks);
    }

    public static Pokemon createPokemon(String specie) {
        Pokemon model = POKEMAP.get(specie);

        if (model == null) {
            throw new IllegalArgumentException("Specie not found: " + specie);
        }

        Map<String, Attack> attacksCopy = new LinkedHashMap<>();
        for (Attack attack : model.getAllAttacks()) {
            attacksCopy.put(attack.getNAME(), new Attack(attack.getNAME(),attack.getDamageAmount()));
        }

        return new Pokemon(
                model.getSpecie(),
                model.getSpecie(),
                model.getType(),
                model.getMaxHp(),
                attacksCopy
        );
    }
}