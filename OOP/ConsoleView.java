
import units.BaseHero;
import units.Position;

import java.util.Collections;
import java.util.List;

public class ConsoleView {

    private static int step = 1;
    //----------------отрисовка строчек псевдографики таблицы ---------начало ----------------
    private static final String top10 = formateDiv("a") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1,formateDiv("-b"))) + formateDiv("-c");
    private static final String mid10 = formateDiv("d") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1,formateDiv("-e"))) + formateDiv("-f");
    private static final String bott10 = formateDiv("g") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1,formateDiv("-h"))) + formateDiv("-i");

    //----------------отрисовка строчек псевдографики таблицы --------конец-----------------
    public static void view(List<BaseHero> whiteSide, List<BaseHero> darkSide){

        if (ConsoleView.step == 1 ){
            System.out.println(AnsiColors.ANSI_GREEN + "First step" + AnsiColors.ANSI_RESET);
        } else {
            System.out.println("Step " + step + ".");
        }
        step++;

        System.out.println(ConsoleView.top10);

        for (byte i = 1; i <= Main.GANG_SIZE - 1; i++) {
            for (byte j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getHeroChar(whiteSide, darkSide, new Position(j,i)));
            }
//           System.out.println("|");
            System.out.println();
//            System.out.println(Main.darkSide.get(i).getInfo());
            System.out.println(ConsoleView.mid10);
        }
        for (byte j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getHeroChar(whiteSide, darkSide, new Position(j,Main.GANG_SIZE)));
        }
//        System.out.println("|");
        System.out.println();
        System.out.println(ConsoleView.bott10);
        System.out.println("Press Enter");
    }

    private static String formateDiv(String str){
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    private static String getHeroChar(List<BaseHero> whiteSide, List<BaseHero> darkSide, Position position){
        String str = "| ";
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (darkSide.get(i).getPosition().isEqual(position)) {
                str = "|" + AnsiColors.ANSI_BLUE + darkSide.get(i).getHeroType().charAt(0) + AnsiColors.ANSI_RESET + "|"
                        + "\t" + AnsiColors.ANSI_GREEN + whiteSide.get(i).toString() + AnsiColors.ANSI_RESET
                        + "\t" + AnsiColors.ANSI_BLUE + darkSide.get(i).toString() + AnsiColors.ANSI_RESET;
            }

            if (whiteSide.get(i).getPosition().isEqual(position)){
                str = "|" + AnsiColors.ANSI_GREEN + whiteSide.get(i).getHeroType().charAt(0) + AnsiColors.ANSI_RESET;
            }
        }
        return str;
    }



}
