package units;

import java.util.List;

/**
 * класс для описания свойств базового персонажа
 */
public abstract class BaseHero implements GameMethods{
    private byte attack, defence, health, maxHealth, speed, minDamage, maxDamage;
    private String heroType, name;
    public BaseHero(String heroType, String name, byte attack, byte defence, byte health, byte speed, byte minDamage, byte maxDamage){
        this.heroType = heroType;
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.maxHealth = health;
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
    @Override
    public byte[] getInfo(){// полная информация о персонаже за исключением имени и типа
        byte[] info = {attack, defence, health, speed, minDamage, maxDamage, 0}; 
        // последний элемент зарезервирован для классов-наследников добавляющих свой параметр
        return info;
    }
    @Override
    public String getHeroType(){
        return this.heroType;
    }
    @Override
    public String getHeroName(){
        return this.name;
    }
    @Override
    public int getHealth(){
        return 100 * this.health / this.maxHealth;// Здоровье в процентах
    }
    @Override
    public void setDamage(byte damage){
        this.health -= damage;
        if (this.health < 0){
            this.health = 0;
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
    public void step(List<BaseHero> comrades, List<BaseHero> enemies){
        
    }
}