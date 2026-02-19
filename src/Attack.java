public class Attack {

    private final String NAME;
    private int damageAmount;

    public Attack(String param_name, int param_damage_amount){
        this.NAME = param_name;
        this.damageAmount = param_damage_amount;
    }

    public String getNAME() {
        return NAME;
    }

    public int getDamageAmount() {
        return damageAmount;
    }

    public void setDamageAmount(int damageAmount) {
        this.damageAmount = damageAmount;
    }

    @Override
    public String toString() {
        return "Attack{" +
                "NAME='" + NAME + '\'' +
                ", damageAmount=" + damageAmount +
                '}';
    }
}
