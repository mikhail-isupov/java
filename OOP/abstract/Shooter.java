/**
 * класс для описания стрелков
 */
public abstract class Shooter extends BaseHero {
    static final String HEROTYPE = "Стрелок";// все стреляющие персонажи относятся к Стрелкам
    private byte shots;
    public Shooter(String heroType, String name, byte attack, byte defence, byte health, byte speed, byte minDamage, byte maxDamage, byte shots){
        super(heroType, name, attack, defence, health, speed, minDamage, maxDamage);
        this.shots = shots;
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
}
