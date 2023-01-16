/*
 * Класс для описания колдуна
 */
public class Wisard extends Supernatural{
    static final String initHeroType = "Колдун";
    static final byte initAttack = 17;
    static final byte initDefence = 12;
    static final byte initHealth = 30;
    static final byte initSpeed = 9;
    static final byte initDamage = -5;
    static final byte initMagic = 1;
    public Wisard(String name){
        super(initHeroType, name, initAttack, initDefence, initHealth, initSpeed, initDamage, initMagic);
    }
}
