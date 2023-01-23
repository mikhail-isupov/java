import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import units.Bandit;
import units.BaseHero;
import units.Crossbowman;
import units.Monk;
import units.Peasant;
import units.Sniper;
import units.Spearman;
import units.Wisard;

public class Main {
    public static void main(String[] args) {
        List<BaseHero> comrades = createTeam1(6);
        List<BaseHero> enemies = createTeam2(6);
        List<BaseHero> swap;
        setDamage(comrades);
        setDamage(enemies);
        String command = "";
        Scanner keyboard = new Scanner(System.in);
        while (!command.equals("quit")){
            for (BaseHero hero: comrades){
                hero.step(comrades, enemies);  
            }
            print(comrades);
            swap = comrades;
            comrades = enemies;
            enemies = swap;
            command = keyboard.nextLine(); 
        }
        keyboard.close();    
    }
    public static void print(List<BaseHero> heroes){
        System.out.println();
        for (BaseHero hero: heroes){
            if (hero.getHealth() > 0){
                System.out.println(hero);
            }
            
        }
        System.out.println();
    }
    public static List<BaseHero> createTeam1(int n){
        List<BaseHero> team1 = new ArrayList<>();
        team1.add(new Peasant(Names.getName()));
        team1.add(new Bandit(Names.getName()));
        team1.add(new Sniper(Names.getName()));
        team1.add(new Wisard(Names.getName()));
        //4 персонажа должны быть в команде + n случайным образом
        Random rnd = new Random();
        for (int i = 1; i <=n; i++){
            switch(rnd.nextInt(4)){
                case(0): team1.add(new Peasant(Names.getName())); break;
                case(1): team1.add(new Bandit(Names.getName())); break;
                case(2): team1.add(new Sniper(Names.getName())); break;
                case(3): team1.add(new Wisard(Names.getName()));
            }
        }
        return team1;
    }
    public static List<BaseHero> createTeam2(int n){
        List<BaseHero> team2 = new ArrayList<>();
        team2.add(new Peasant(Names.getName()));
        team2.add(new Spearman(Names.getName()));
        team2.add(new Crossbowman(Names.getName()));
        team2.add(new Monk(Names.getName()));
        Random rnd = new Random();
        for (int i = 1; i <=n; i++){
            switch(rnd.nextInt(4)){
                case(0): team2.add(new Peasant(Names.getName())); break;
                case(1): team2.add(new Spearman(Names.getName())); break;
                case(2): team2.add(new Crossbowman(Names.getName())); break;
                case(3): team2.add(new Monk(Names.getName())); break;
            }
        }
        return team2;
    }
    public static void setDamage(List<BaseHero> heroes){// наносим повреждения героям
        Random rnd = new Random();
        byte heroHealth;
        for (BaseHero hero: heroes){
            heroHealth = hero.getInfo()[2];
            hero.setDamage((byte)rnd.nextInt(heroHealth));//наносим случайное повреждение
        }
    }

}
