/**
 * класс для описания Крестьянина
 */
public class Peasant extends BaseHero {
    static final String initHeroType = "Крестьянин";
    static final byte initAttack = 1;
    static final byte initDefence = 1;
    static final byte initHealth = 1;
    static final byte initSpeed = 3;
    static final byte initDamage = 1;
    static final byte initDelivery = 1;
    
    private byte delivery;

    private Peasant(String heroType, String name, byte attack, byte defence, byte health, byte speed, byte damage, byte delivery){
        super(heroType, name, attack, defence, health, speed, damage);
        this.delivery = delivery;
    }
    public Peasant(String name){
        this(initHeroType, name, initAttack, initDefence, initHealth, initSpeed, initDamage, initDelivery);
    }
    @Override
    public String toString(){
        return super.toString() + ", Доставка: " + this.delivery;
    }
}
