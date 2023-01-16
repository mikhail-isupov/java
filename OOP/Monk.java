/*
 * Класс для описания монаха
 */
public class Monk extends Supernatural{
    static final String initHeroType = "Монах";
    static final byte initAttack = 12;
    static final byte initDefence = 7;
    static final byte initHealth = 30;
    static final byte initSpeed = 5;
    static final byte initDamage = -4;
    static final byte initMagic = 1;
    public Monk(String name){
        super(initHeroType, name, initAttack, initDefence, initHealth, initSpeed, initDamage, initMagic);
    }
}
