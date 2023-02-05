package units;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

/*
 * Класс для создания и инициализации команд 
 */
public class TeamConstructor {
    public static final byte GANG_SIZE = 10;
    private static byte x;
    static{
        x = 1;
    }
    
    public static List<BaseHero> createTeam(String[] heroes){
        List<BaseHero> team = new ArrayList<>();
        Random rnd = new  Random();
        int num;
        for (byte y = 1; y <= GANG_SIZE; y++){
            num = rnd.nextInt(heroes.length);
            if (Bandit.HEROTYPE.equals(heroes[num])) team.add(new Bandit(team, new Position(x, y)));
            if (Crossbowman.HEROTYPE.equals(heroes[num])) team.add(new Crossbowman(team, new Position(x, y)));
            if (Monk.HEROTYPE.equals(heroes[num])) team.add(new Monk(team, new Position(x, y)));
            if (Peasant.HEROTYPE.equals(heroes[num])) team.add(new Peasant(team, new Position(x, y)));
            if (Sniper.HEROTYPE.equals(heroes[num])) team.add(new Sniper(team, new Position(x, y)));
            if (Spearman.HEROTYPE.equals(heroes[num])) team.add(new Spearman(team, new Position(x, y)));
            if (Wisard.HEROTYPE.equals(heroes[num])) team.add(new Wisard(team, new Position(x, y)));           
        }
        x *= GANG_SIZE;
        return team;
    }
    public static boolean isTeamAlive(List<BaseHero> team){
        boolean isAnybodyHereAlive = false;
        for (BaseHero hero : team){
            if (hero.getHealth() > 0) {
                isAnybodyHereAlive = true;
                break;
            }
        }
        return isAnybodyHereAlive;
    }
    public static TreeMap<Byte, List<BaseHero>> createBattle(List<BaseHero> team1, List<BaseHero> team2){
        TreeMap<Byte, List<BaseHero>> battle = new TreeMap<>();
        for (BaseHero hero : team1){
            addHeroInBattle(hero, battle);
        }
        for (BaseHero hero : team2){
            addHeroInBattle(hero, battle);
        }
    return battle;
    }
    private static void addHeroInBattle(BaseHero hero, TreeMap<Byte, List<BaseHero>> battle){
        Byte speed = hero.getInfo()[3];
            if (!battle.containsKey(speed)){
                battle.put(speed, new ArrayList<BaseHero>());
            }
            battle.get(speed).add(hero);
    }
    
}
