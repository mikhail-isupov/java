package units;

import java.util.List;

/**
 * класс для описания свойств базового персонажа
 */
public abstract class BaseHero implements GameMethods{
    private List<BaseHero> comrades;
    private String heroType;
    private Position position;
    private byte attack, defence, health, maxHealth, speed, minDamage, maxDamage;
    public BaseHero(List<BaseHero> comrades,  String heroType, Position position, byte attack, byte defence, byte health, byte speed, byte minDamage, byte maxDamage){
        this.comrades = comrades;
        this.heroType = heroType;
        this.position = position;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.maxHealth = health;
        this.speed = speed;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }
    public BaseHero(List<BaseHero> comrades, String heroType, Position position, byte attack, byte defence, byte health, byte speed, byte damage){
        this(comrades, heroType, position, attack, defence, health, speed, damage, damage);
    }
    @Override
    public List<BaseHero> getComrades(){
        return this.comrades;
    }
    @Override
    public Position getPosition(){
        return this.position;
    }
    @Override
    public void setPosition(Position position){
        this.position = position;
    }
    @Override
    public String getHeroType(){
        return this.heroType;
    }
    @Override
    public String toString(){
        String stringHero;
        stringHero = String.format("%-12s\t⚔ %d\t🛡 %d\t☠ %d\t♥% d\tV %d",this.heroType, this.attack, this.defence, (this.minDamage + this.maxDamage) / 2, this.health, this.speed);       
        return stringHero;
    }  
    @Override
    public byte[] getInfo(){// полная информация о персонаже за исключением типа героя и его положения
        byte[] info = {attack, defence, health, speed, minDamage, maxDamage, 0}; 
        // последний элемент зарезервирован для классов-наследников добавляющих свой параметр
        return info;
    }
    @Override
    public int getHealth(){
        return 100 * this.health / this.maxHealth;// Здоровье в процентах
    }
    @Override
    public void setDamage(byte damage){
        this.health -= damage;
        if (this.health <= 0){
            this.health = 0;
            System.out.printf("%s %s погиб.\n", this.getHeroType(), this.position.toString());
        }
        if (this.health > this.maxHealth){
            this.health = this.maxHealth;
        }
    }
    @Override
    public boolean setItem(){
        return false;
    }
    @Override
    public void step(List<BaseHero> enemies){
        
    }
}