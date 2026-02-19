import java.util.*;

public class Pokemon {

    private final String specie;
    private String name;
    private final PokemonType type;
    private int hp;
    private final int MAX_HP;
    private int level;
    private final Map<String, Attack> attacks;
    private PokemonStatus status;

    public Pokemon(String specie, String name, PokemonType type, int hp, Map<String, Attack> attacks) {
        this.specie = specie;
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.MAX_HP = hp;
        this.level = 1;
        this.attacks = new LinkedHashMap<>(attacks);
        this.status = PokemonStatus.AVAILABLE;
    }

    public String getSpecie() {
        return specie;
    }

    public String getName() {
        return name;
    }

    public PokemonType getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return MAX_HP;
    }

    public int getLevel() {
        return level;
    }

    public Attack getAttack(String name) {
        return attacks.get(name);
    }

    public Collection<Attack> getAllAttacks() {
        return Collections.unmodifiableCollection(attacks.values());
    }

    public void setHp(int hp) {
        int previousHp = this.hp;

        this.hp = Math.max(0, Math.min(hp, MAX_HP));

        if (previousHp > 0 && this.hp == 0) {
            System.out.println(this.name + " has been defeated!");
            this.status = PokemonStatus.DEFEATED;
        }
        else if (previousHp == 0 && this.hp > 0) {
            System.out.println(this.name + " has been revived!");
            this.status = PokemonStatus.AVAILABLE;
        }
    }

    public void setName(String name) {
        System.out.println("Now your " + this.specie + " is called " + name + "!");
        this.name = name;
    }

    public void levelUp() {
        System.out.println(this.name + " leveled up!");
        this.level++;
    }

    public void setStatus(PokemonStatus status) {
        if(this.status == status){
            System.out.println(this.name + " is already with this status!");
            return;
        }
        this.status = status;
    }

    public boolean isAvailable(){
        return this.status == PokemonStatus.AVAILABLE;
    }

    public boolean isBattling(){
        return this.status == PokemonStatus.BATTLING;
    }

    public boolean isDefeated(){
        return this.status == PokemonStatus.DEFEATED;
    }

    public void receiveDamage(int damageAmount){
        setHp(this.hp-damageAmount);
    }

    public void attack(String attackName, Pokemon enemy) {
        if(isDefeated()){
            System.out.println(this.name + " is defeated!");
            return;
        }
        else if(!isBattling()){
            System.out.println(this.name + " is not in a current battle!");
            return;
        }

        if (enemy.isDefeated()) {
            System.out.println(enemy.getName() + " is already defeated!");
            return;
        }
        if (!enemy.isBattling()) {
            System.out.println(enemy.getName() + " is not in a current battle!");
            return;
        }

        Attack attack = this.attacks.get(attackName);

        if (attack == null) {
            throw new IllegalArgumentException("Attack not found: " + attackName);
        }

        int damage = attack.getDamageAmount();
        enemy.receiveDamage(damage);

        System.out.println(this.name + " used " + attackName + "!");
        System.out.println(enemy.getName() + " lost " + damage + " HP!");
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "specie='" + specie + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", hp=" + hp +
                ", MAX_HP=" + MAX_HP +
                ", level=" + level +
                ", attacks=" + attacks +
                ", status=" + status +
                '}';
    }
}
