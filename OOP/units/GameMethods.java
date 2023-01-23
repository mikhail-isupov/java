package units;
import java.util.List;

public interface GameMethods {
    byte[] getInfo();
    int getHealth();
    String getHeroType();
    String getHeroName();
    boolean setItem();
    void setDamage(byte damage);
    void step(List<BaseHero> comrades, List<BaseHero> enemies);
}
