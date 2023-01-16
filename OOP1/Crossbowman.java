/**
 * класс для описания арбалетчика
 */
public class Crossbowman extends Shooter {
    static final String initHeroType = "Арбалетчик";
    static final byte initAttack = 6;
    static final byte initDefence = 3;
    static final byte initHealth = 10;
    static final byte initSpeed = 4;
    static final byte initMinDamage = 2;
    static final byte initMaxDamage = 3;
    static final byte initShots = 16;
    public Crossbowman(String name){
        super(initHeroType, name, initAttack, initDefence, initHealth, initSpeed, initMinDamage, initMaxDamage, initShots);
    }
}
