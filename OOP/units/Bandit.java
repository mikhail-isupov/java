package units;
/**
 * класс для описания разбойника
 */
public class Bandit extends BaseHero {
    static final String HEROTYPE = "Разбойник";
    static final byte ATTACK = 8;
    static final byte DEFENCE = 3;
    static final byte HEALTH = 10;
    static final byte SPEED = 6;
    static final byte MINDAMAGE = 2;
    static final byte MAXDAMAGE = 4;

    public Bandit(String name){
        super(HEROTYPE, name, ATTACK, DEFENCE, HEALTH, SPEED, MINDAMAGE, MAXDAMAGE);
    }
}
