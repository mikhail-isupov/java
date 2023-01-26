import units.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final byte GANG_SIZE = 10;
    

    public static void main(String[] args) {
        List<BaseHero> whiteSide = newWhiteTeam();
        List<BaseHero> darkSide = newDarkTeam();

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println();
            System.out.println("Ход Зеленых:");
            whiteSide.forEach(n -> n.step(darkSide));
            System.out.println();
            System.out.println("Ход Синих:");
            darkSide.forEach(n -> n.step(whiteSide));
            ConsoleView.view(whiteSide, darkSide);
            scanner.nextLine();
        }
        
    }

    private static List<BaseHero> newWhiteTeam(){
        List<BaseHero> whiteSide = new ArrayList<>(GANG_SIZE);
        byte x = 1;
        byte y = 1;
        Random rnd = new Random();
        for (byte i = 0; i < GANG_SIZE; i++) {
            switch (rnd.nextInt(5)) {
                case 0: whiteSide.add(new Peasant(whiteSide, new Position(x, y++))); break;
                case 1: whiteSide.add(new Bandit(whiteSide, new Position(x, y++))); break;
                case 2: whiteSide.add(new Sniper(whiteSide, new Position(x, y++))); break;
                case 3: whiteSide.add(new Monk(whiteSide, new Position(x, y++))); break;
                default: whiteSide.add(new Peasant(whiteSide, new Position(x, y++))); break;
            }
        }
        return whiteSide;

    }
    private static List<BaseHero> newDarkTeam(){
        List<BaseHero> darkSide = new ArrayList<>(GANG_SIZE);
        byte x = GANG_SIZE;
        byte y = 1;
        Random rnd = new Random();
        for (byte i = 0; i < GANG_SIZE; i++) {
            switch (rnd.nextInt(5)) {
                case 0: darkSide.add(new Peasant(darkSide, new Position(x, y++))); break;
                case 1: darkSide.add(new Spearman(darkSide, new Position(x, y++))); break;
                case 2: darkSide.add(new Crossbowman(darkSide, new Position(x, y++))); break;
                case 3: darkSide.add(new Wisard(darkSide, new Position(x, y++))); break;
                default: darkSide.add(new Peasant(darkSide, new Position(x, y++))); break;
            }
        }
        return darkSide;
    }
}
