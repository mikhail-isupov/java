package units;
/*
 * Класс для описания монаха
 */
public class Monk extends Supernatural{
    static final String HEROTYPE = "Монах";
    static final byte ATTACK = 12;
    static final byte DEFENCE = 7;
    static final byte HEALTH = 30;
    static final byte SPEED = 5;
    static final byte DAMAGE = -4;
    static final byte MAGIC = 1;
    public Monk(String name){
        super(HEROTYPE, name, ATTACK, DEFENCE, HEALTH, SPEED, DAMAGE, MAGIC);
    }
}
