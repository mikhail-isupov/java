package units;

import java.util.List;

/**
 * класс для описания стрелков
 */
public abstract class Shooter extends BaseHero {
    private byte shots;
    private boolean needAnArrow;
    public Shooter(List <BaseHero> comrades, String heroType, Position position, byte attack, byte defence, byte health, byte speed, byte minDamage, byte maxDamage, byte shots){
        super(comrades, heroType, position, attack, defence, health, speed, minDamage, maxDamage);
        this.shots = shots;
        this.needAnArrow = false;
    }
    @Override
    public String toString(){
        return super.toString() + "\t➶ " + this.shots;
    }
    @Override
    public byte[] getInfo(){
        byte[] info = super.getInfo();
        info[info.length - 1] = this.shots;// Индивидуальный параметр кладется в зарезервированный элемент
        return info;       
    }
    @Override
    public void step(List<BaseHero> enemies){
        if (this.getHealth() > 0 && this.shots > 0){
            //Тут будет цикл по enemies и выстрел
            System.out.printf("%s выстрелил \n", this.getHeroType());
            this.shots -= 1;
            this.needAnArrow = true; // выстрел сделан, нужна стрела
        }
    }
    public boolean setItem(){
        if (this.getHealth() > 0 && this.needAnArrow){
            this.shots += 1;
            this.needAnArrow = false;
            return true; // Стрела передана успешно
        } else {
            return false; // Стрелу не взял 
        }

    }
}
