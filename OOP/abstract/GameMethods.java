import java.util.List;

public interface GameMethods {
    byte[] getInfo();
    String getHeroType();
    int getHealth();
    void setHealth(byte damage);
    void step(List<BaseHero> heroes);
}
