/*
 * Класс для описания колдуна
 */
public class Wisard extends Supernatural{
    static final String HEROTYPE = "Колдун";
    static final byte ATTACK = 17;
    static final byte DEFENCE = 12;
    static final byte HEALTH = 30;
    static final byte SPEED = 9;
    static final byte DAMAGE = -5;
    static final byte MAGIC = 1;
    public Wisard(String name){
        super(HEROTYPE, name, ATTACK, DEFENCE, HEALTH, SPEED, DAMAGE, MAGIC);
    }
}
