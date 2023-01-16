/**
 * класс для описания снайпера
 */
public class Sniper extends Shooter {
    static final String initHeroType = "Снайпер";
    static final byte initAttack = 12;
    static final byte initDefence = 10;
    static final byte initHealth = 15;
    static final byte initSpeed = 9;
    static final byte initMinDamage = 8;
    static final byte initMaxDamage = 10;
    static final byte initShots = 32;
    public Sniper(String name){
        super(initHeroType, name, initAttack, initDefence, initHealth, initSpeed, initMinDamage, initMaxDamage, initShots);
    }
}
