package units;
/**
 * класс для описания копейщика
 */
public class Spearman extends BaseHero {
    static final String HEROTYPE = "Копейщик";
    static final byte ATTACK = 4;
    static final byte DEFENCE = 5;
    static final byte HEALTH = 10;
    static final byte SPEED = 4;
    static final byte MINDAMAGE = 1;
    static final byte MAXDAMAGE = 3;

    public Spearman(String name){
        super(HEROTYPE, name, ATTACK, DEFENCE, HEALTH, SPEED, MINDAMAGE, MAXDAMAGE);
    }
}
