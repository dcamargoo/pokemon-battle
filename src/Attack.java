public class Attack {

    private final String NAME;
    private int damage;

    public Attack(String name, int damage){
        this.NAME = name;
        this.damage = damage;
    }

    public String getNAME() {
        return NAME;
    }

    public int getDamageAmount() {
        return damage;
    }

    public void setDamageAmount(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Attack{" +
                "NAME='" + NAME + '\'' +
                ", damage=" + damage +
                '}';
    }
}
