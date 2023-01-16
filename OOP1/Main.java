import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Это список из случайно сгенерированных героев");
        List<BaseHero> heroes = generateRandomHeroes(50);
        print(heroes);
        System.out.println("А это отфильтрованный список по заданному типу персонажа");
        List<BaseHero> selectedHeroes = selectHeroes(heroes, new Peasant("Вася"));
        print(selectedHeroes);
    }
    public static List<BaseHero> generateRandomHeroes(int heroesNumber){
        final int numberOfClasses = 7;
        List<BaseHero> heroes = new ArrayList<>(heroesNumber);
        Random rnd = new Random();
        int choise;
        for (byte i = 0; i < heroesNumber; i++){
            choise = rnd.nextInt(numberOfClasses);
            BaseHero newHero;
            switch (choise){
                case (0): newHero = new Bandit(Names.getName()); break;
                case (1): newHero = new Crossbowman(Names.getName()); break;
                case (2): newHero = new Monk(Names.getName()); break;
                case (3): newHero = new Peasant(Names.getName()); break;
                case (4): newHero = new Sniper(Names.getName()); break;
                case (5): newHero = new Spearman(Names.getName()); break;
                case (6): newHero = new Wisard(Names.getName()); break;
                default: newHero = new Peasant("Вася");
            }
            heroes.add(newHero);
        }
    return heroes;
    }
    public static List<BaseHero> selectHeroes(List<BaseHero> heroes, BaseHero heroToSelect){
        List<BaseHero> selectedHeroes = new ArrayList<>();
        for (BaseHero hero: heroes){
            if (hero.getClass().equals(heroToSelect.getClass())){
                selectedHeroes.add(hero);
            }
        }
        return selectedHeroes;
    }
    public static void print(List<BaseHero> heroes){
        for (BaseHero hero: heroes){
            System.out.println(hero);
        }
    }
}
