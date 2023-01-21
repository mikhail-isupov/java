/**
 * класс для описания Крестьянина
 */
public class Peasant extends BaseHero {
    static final String HEROTYPE = "Крестьянин";
    static final byte ATTACK = 1;
    static final byte DEFENCE = 1;
    static final byte HEALTH = 1;
    static final byte SPEED = 3;
    static final byte DAMAGE = 1;
    static final byte DELIVERY = 1;
    
    private byte delivery;

    private Peasant(String heroType, String name, byte attack, byte defence, byte health, byte speed, byte damage, byte delivery){
        super(heroType, name, attack, defence, health, speed, damage);
        this.delivery = delivery;
    }
    public Peasant(String name){
        this(HEROTYPE, name, ATTACK, DEFENCE, HEALTH, SPEED, DAMAGE, DELIVERY);
    }
    @Override
    public String toString(){
        return super.toString() + ", Доставка: " + this.delivery;
    }
    @Override
    public byte[] getInfo(){
        byte[] info = super.getInfo();
        info[info.length - 1] = this.delivery;// Индивидуальный параметр кладется в зарезервированный элемент
        return info;
    }
}
