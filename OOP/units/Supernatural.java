package units;
import java.util.List;

/**
 * класс для описания персонажей с магией
 */
public abstract class Supernatural extends BaseHero {
    //static final String HEROTYPE = "Волшебник";// Все персонажи с магией относятся к волшебникам
    private byte magic;
    public Supernatural(String heroType, String name, byte attack, byte defence, byte health, byte speed, byte damage, byte magic){
        super(heroType, name, attack, defence, health, speed, damage);
        this.magic = magic;
    }
    @Override
    public String toString(){
        return super.toString() + ", Магия: " + this.magic;
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
    public void step(List<BaseHero> comrades, List<BaseHero> enemies){
        if (this.getHealth() > 0){
            int worstHealth = 100;
            int heroHealth;
            BaseHero mostDamagedHero = null;
            for (BaseHero hero: comrades){
                heroHealth = hero.getHealth();
                if (hero != this && heroHealth > 0 && heroHealth < worstHealth){// Волшебник не лечит себя и погибших
                    worstHealth = heroHealth;
                    mostDamagedHero = hero;
                }
            }
            if (mostDamagedHero != null){// Ежели нашли раненного
                mostDamagedHero.setDamage(this.getInfo()[5]);//Вычитаем из здоровья урон
                System.out.printf("%s %s подлечил %s %s \n",this.getHeroType(), this.getHeroName(), mostDamagedHero.getHeroType(), mostDamagedHero.getHeroName());
            }
        }  
    }
}
