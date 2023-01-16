/**
 * класс для описания свойств базового персонажа
 */
public class BaseHero{
    private byte attack, defence, health, speed, minDamage, maxDamage;
    private String heroType, name;
    public BaseHero(String heroType, String name, byte attack, byte defence, byte health, byte speed, byte minDamage, byte maxDamage){
        this.heroType = heroType;
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.speed = speed;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }
    public BaseHero(String heroType, String name, byte attack, byte defence, byte health, byte speed, byte damage){
        this(heroType, name, attack, defence, health, speed, damage, damage);
    }
    @Override
    public String toString(){
        String stringHero;
        if (this.minDamage==this.maxDamage){
            stringHero = String.format("%s %s, Атака: %d, Защита: %d, Урон: %d, Здоровье: %d, Скорость: %d",this.heroType, this.name, this.attack, this.defence, this.minDamage, this.health, this.speed);
        } else {
            stringHero = String.format("%s %s, Атака: %d, Защита: %d, Урон: [%d, %d], Здоровье: %d, Скорость: %d",this.heroType, this.name, this.attack, this.defence, this.minDamage, this.maxDamage, this.health, this.speed);
        }
        return stringHero;
    }

}