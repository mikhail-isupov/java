/**
 * класс для описания снайпера
 */
public class Sniper extends Shooter {
    static final String HEROTYPE = "Снайпер";
    static final byte ATTACK = 12;
    static final byte DEFENCE = 10;
    static final byte HEALTH = 15;
    static final byte SPEED = 9;
    static final byte MINDAMAGE = 8;
    static final byte MAXDAMAGE = 10;
    static final byte SHOTS = 32;
    public Sniper(String name){
        super(HEROTYPE, name, ATTACK, DEFENCE, HEALTH, SPEED, MINDAMAGE, MAXDAMAGE, SHOTS);
    }
}
