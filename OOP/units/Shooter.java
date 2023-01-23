package units;

import java.util.List;

/**
 * класс для описания стрелков
 */
public abstract class Shooter extends BaseHero {
    static final String HEROTYPE = "Стрелок";// все стреляющие персонажи относятся к Стрелкам
    private byte shots;
    private boolean needAnArrow;
    public Shooter(String heroType, String name, byte attack, byte defence, byte health, byte speed, byte minDamage, byte maxDamage, byte shots){
        super(heroType, name, attack, defence, health, speed, minDamage, maxDamage);
        this.shots = shots;
        this.needAnArrow = false;
    }
    @Override
    public String toString(){
        return super.toString() + ", Выстрелы: " + this.shots;
    }
    @Override
    public byte[] getInfo(){
        byte[] info = super.getInfo();
        info[info.length - 1] = this.shots;// Индивидуальный параметр кладется в зарезервированный элемент
        return info;       
    }
    @Override
    public String getHeroType(){
        return HEROTYPE;
    }
    @Override
    public void step(List<BaseHero> comrades, List<BaseHero> enemies){
        if (this.getHealth() > 0 && this.shots > 0){
            //Тут будет цикл по enemies и выстрел
            System.out.printf("Стрелок %s выстрелил \n", this.getHeroName());
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
