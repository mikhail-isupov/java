package units;

import java.util.List;

/**
 * класс для описания стрелков
 */
public abstract class Shooter extends BaseHero {
    public static final float MAX_DAMAGE_RANGE = 4;
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
            float minDistance = Position.MAXDISTANCE;
            float distance;
            BaseHero selectedEnemy = null;
            for (BaseHero enemy: enemies){
                distance = enemy.getPosition().getDistance(this.getPosition());
                if (enemy.getHealth() > 0 && distance < minDistance){
                    minDistance = distance;
                    selectedEnemy = enemy;
                }
            }
            if (selectedEnemy != null){
                System.out.printf("%s %s выстрелил в %s %s \n", this.getHeroType(), this.getPosition().toString(), selectedEnemy.getHeroType(), selectedEnemy.getPosition().toString());
                byte[] heroInfo = this.getInfo();
                byte selectedEnemyDefence = selectedEnemy.getInfo()[1];
                byte damage;
                if (minDistance <= MAX_DAMAGE_RANGE) {
                    damage = heroInfo[5];
                } else {
                    damage = (byte)Math.round(heroInfo[5] + (heroInfo[4] - heroInfo[5]) * (minDistance - MAX_DAMAGE_RANGE) / (Position.MAXDISTANCE - MAX_DAMAGE_RANGE));
                    if (heroInfo[0] > selectedEnemyDefence) {
                        damage += 1;
                    }
                    if (heroInfo[0] < selectedEnemyDefence) {
                        damage -= 1;
                    }
                }
                selectedEnemy.setDamage(damage);
                this.shots -= 1;
                this.needAnArrow = true; // выстрел сделан, нужна стрела
            }
            
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
