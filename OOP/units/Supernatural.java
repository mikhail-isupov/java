package units;
import java.util.List;

/**
 * класс для описания персонажей с магией
 */
public abstract class Supernatural extends BaseHero {

    private byte magic;
    public Supernatural(List<BaseHero> comrades, String heroType, Position position, byte attack, byte defence, byte health, byte speed, byte damage, byte magic){
        super(comrades, heroType, position, attack, defence, health, speed, damage);
        this.magic = magic;
    }
    @Override
    public String toString(){
        return super.toString() + "\t🧪 " + this.magic;
    }
    @Override
    public byte[] getInfo(){
        byte[] info = super.getInfo();
        info[info.length - 1] = this.magic;// Индивидуальный параметр кладется в зарезервированный элемент
        return info;       
    }
    //@Override
    //public String getHeroType(){
    //    return HEROTYPE;
    //}
    @Override
    public void step(List<BaseHero> enemies){
        if (this.getHealth() > 0){
            int worstHealth = 100;
            int heroHealth;
            BaseHero mostDamagedHero = null;
            for (BaseHero hero: this.getComrades()){
                heroHealth = hero.getHealth();
                if (hero != this && heroHealth > 0 && heroHealth < worstHealth){// Волшебник не лечит себя и погибших
                    worstHealth = heroHealth;
                    mostDamagedHero = hero;
                }
            }
            if (mostDamagedHero != null){// Ежели нашли раненного
                mostDamagedHero.setDamage(this.getInfo()[5]);//Вычитаем из здоровья урон
                System.out.printf("%s %s подлечил %s %s\n",this.getHeroType(), this.getPosition().toString(), mostDamagedHero.getHeroType(), mostDamagedHero.getPosition().toString());
            }
        }  
    }
}
