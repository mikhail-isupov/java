/**
 * класс для описания персонажей с магией
 */
public class Supernatural extends BaseHero {
    private byte magic;
    public Supernatural(String heroType, String name, byte attack, byte defence, byte health, byte speed, byte damage, byte magic){
        super(heroType, name, attack, defence, health, speed, damage);
        this.magic = magic;
    }
    @Override
    public String toString(){
        return super.toString() + ", Магия: " + this.magic;
    }
}
