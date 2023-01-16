/**
 * класс для описания копейщика
 */
public class Spearman extends BaseHero {
    static final String initHeroType = "Копейщик";
    static final byte initAttack = 4;
    static final byte initDefence = 5;
    static final byte initHealth = 10;
    static final byte initSpeed = 4;
    static final byte initMinDamage = 1;
    static final byte initMaxDamage = 3;

    public Spearman(String name){
        super(initHeroType, name, initAttack, initDefence, initHealth, initSpeed, initMinDamage, initMaxDamage);
    }
}
