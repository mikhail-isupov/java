import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<BaseHero> team1 = createTeam1();
        System.out.println("Исходная команда 1:");
        print(team1);
        List<BaseHero> team2 = createTeam2();
        System.out.println("Исходная команда 2:");
        print(team2);
        setDamage(team1);
        setDamage(team2);
        System.out.println("Поврежденная команда 1:");
        print(team1);
        System.out.println("Поврежденная команда 2:");
        print(team2);
        for (BaseHero hero: team1){
            hero.step(team1); // Вызываем у каждого персонажа команды 1 метод step который есть только у Волшебников
        }
        for (BaseHero hero: team2){
            hero.step(team2); // Вызываем у каждого персонажа команды 2 метод step который есть только у Волшебников
        }
        System.out.println("Пролеченная команда 1:");
        print(team1);
        System.out.println("Пролеченная команда 2:");
        print(team2);
    }
    
    public static void print(List<BaseHero> heroes){
        System.out.println();
        for (BaseHero hero: heroes){
            System.out.println(hero);
        }
        System.out.println();
    }
    public static List<BaseHero> createTeam1(){
        List<BaseHero> team1 = new ArrayList<>();
        team1.add(new Peasant(Names.getName()));
        team1.add(new Peasant(Names.getName()));
        team1.add(new Peasant(Names.getName()));
        team1.add(new Peasant(Names.getName()));
        team1.add(new Bandit(Names.getName()));
        team1.add(new Bandit(Names.getName()));
        team1.add(new Sniper(Names.getName()));
        team1.add(new Sniper(Names.getName()));
        team1.add(new Wisard(Names.getName()));
        team1.add(new Wisard(Names.getName()));
        return team1;
    }
    public static List<BaseHero> createTeam2(){
        List<BaseHero> team2 = new ArrayList<>();
        team2.add(new Peasant(Names.getName()));
        team2.add(new Peasant(Names.getName()));
        team2.add(new Peasant(Names.getName()));
        team2.add(new Peasant(Names.getName()));
        team2.add(new Spearman(Names.getName()));
        team2.add(new Spearman(Names.getName()));
        team2.add(new Crossbowman(Names.getName()));
        team2.add(new Crossbowman(Names.getName()));
        team2.add(new Monk(Names.getName()));
        team2.add(new Monk(Names.getName()));
        return team2;
    }
    public static void setDamage(List<BaseHero> heroes){// наносим повреждения героям
        Random rnd = new Random();
        byte heroHealth;
        for (BaseHero hero: heroes){
            heroHealth = hero.getInfo()[2];
            hero.setHealth((byte)rnd.nextInt(heroHealth + 1));//наносим случайное повреждение
        }
    }

}
