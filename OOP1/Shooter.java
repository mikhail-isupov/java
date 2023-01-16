/**
 * класс для описания стрелков
 */
public class Shooter extends BaseHero {
    private byte shots;
    public Shooter(String heroType, String name, byte attack, byte defence, byte health, byte speed, byte minDamage, byte maxDamage, byte shots){
        super(heroType, name, attack, defence, health, speed, minDamage, maxDamage);
        this.shots = shots;
    }
    @Override
    public String toString(){
        return super.toString() + ", Выстрелы: " + this.shots;
    }
}
