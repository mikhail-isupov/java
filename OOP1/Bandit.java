/**
 * класс для описания разбойника
 */
public class Bandit extends BaseHero {
    static final String initHeroType = "Разбойник";
    static final byte initAttack = 8;
    static final byte initDefence = 3;
    static final byte initHealth = 10;
    static final byte initSpeed = 6;
    static final byte initMinDamage = 2;
    static final byte initMaxDamage = 4;

    public Bandit(String name){
        super(initHeroType, name, initAttack, initDefence, initHealth, initSpeed, initMinDamage, initMaxDamage);
    }
}
