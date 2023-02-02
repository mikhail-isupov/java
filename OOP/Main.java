import units.*;
import view.ConsoleView;
//import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        String[] whiteTeamMembers = {Sniper.HEROTYPE, Bandit.HEROTYPE, Bandit.HEROTYPE, Peasant.HEROTYPE, Peasant.HEROTYPE, Monk.HEROTYPE};
        String[] darkTeamMembers = {Crossbowman.HEROTYPE, Spearman.HEROTYPE, Spearman.HEROTYPE, Peasant.HEROTYPE, Peasant.HEROTYPE, Wisard.HEROTYPE};
        var whiteSide = TeamConstructor.createTeam(whiteTeamMembers);
        var darkSide = TeamConstructor.createTeam(darkTeamMembers);
        
        Scanner scanner = new Scanner(System.in);
        
        while (TeamConstructor.isTeamAlive(whiteSide) && TeamConstructor.isTeamAlive(darkSide)){
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
}
