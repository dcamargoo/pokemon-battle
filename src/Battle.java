public class Battle {

    public Battle(){}

    public void initiateFight(Trainer t1, Trainer t2){
        System.out.println("\nWelcome to the battle!\n" +
                            "Our two competitors are: " + t1.getName() + " and " + t2.getName() + "!!!\n" +
                            "Please choose your Pokemon, " + t1.getName() + "...\n");
        System.out.println(t1.showPokemons());
        // implementar o sistema de escolher o Pokemon do treinador 1

        System.out.println("Please choose your Pokemon, " + t2.getName() + "...\n");
        System.out.println(t2.showPokemons());
        // implementar o sistema de escolher o Pokemon do treinador 2

        // implementar o sistema de batalha
    }
}
