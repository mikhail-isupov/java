package BasicAPI5;
import java.util.ArrayList;

public class Task4 {
//Расставить ферзей на шахматной доске чтобы они не били друг друга
//Пусть есть ферзи с координатами Xi,Yi ... Xj,Yj ... X1, Y1
// Для всех значений индексов должны выполняться неравенства Xi != Xj, Yi != Yj, |Xi-Xj| != |Yi-Yj|
//ищем перебором

public static final byte BOARDSIZE = 8;
public static final byte QUEENSNUMBER = 8;
public static void main(String[] args) {
    ArrayList<Byte[]> queens = new ArrayList<>();
    byte row = 0;
    byte column = 0;
    while (row < BOARDSIZE && queens.size() != QUEENSNUMBER){
        column = 0;
        while (column < BOARDSIZE && queens.size() != QUEENSNUMBER){
            queens.clear();
            Byte[] firstQueen = {row, column}; 
            queens.add(firstQueen); // Гоняем ферзя
            arrangeQueens(queens);
            column+=1;
        }
    row+=1;
    }
    printChessBoard(queens);
    

}

public static void arrangeQueens(ArrayList<Byte[]> queens){
    byte queensCounter = (byte)queens.size(); // сколько ферзей уже расставлено
    boolean isQueenUnderAttack;
    byte previousRow, previousColumn, row, column;
    row = 0;

    while (row < BOARDSIZE && queensCounter != QUEENSNUMBER){
        column = 0;
        do{
            isQueenUnderAttack = false;
            byte queen = 0;
            while(queen < queensCounter && !isQueenUnderAttack){ // перебираем всех предыдущих ферзей, если попал под удар то прекращаем цикл
                previousRow = queens.get(queen)[0];
                previousColumn = queens.get(queen)[1]; 

                if (row == previousRow || column == previousColumn || Math.abs(row - previousRow) == Math.abs(column - previousColumn)){
                    isQueenUnderAttack = true; // смотрим попадает ли под удар
                }
                queen+=1;
            }

        if (isQueenUnderAttack) {
            column += 1;
        }
        } while (isQueenUnderAttack && column < BOARDSIZE); // цикл выполняется до тех пор пока не найдем новое место для ферзя или не дойдем до конца доски
        if (!isQueenUnderAttack){ // если нашли новое место для ферзя
            Byte[] queenPosition = new Byte[2]; // для координат нового ферзя
            queenPosition[0] = row;
            queenPosition[1] = column;
            queens.add(queenPosition);
            queensCounter+=1;// 
            row+=1; // переходим на следующий ряд
        } else {
            row+=1;
        }
    }

}
public static void printChessBoard(ArrayList<Byte[]> queens){
    
    char[][] board = new char[BOARDSIZE][BOARDSIZE];
    for (byte row = 0; row < BOARDSIZE; row++){
        for (byte column = 0; column < BOARDSIZE; column++){
            board[row][column] = '.';
        }
    }
    for (Byte[] item: queens){
        byte row = item[0];
        byte column = item[1];
        board[row][column] = 'A';
    }
    for (byte row = 0; row < BOARDSIZE; row++){
        for (byte column = 0; column < BOARDSIZE; column++){
            System.out.printf(" %s ", board[row][column]);
        }
        System.out.println();
    }
}

}
