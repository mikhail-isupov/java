package ru.gb.jcore_final;

/**
 * Класс для создания объекта данных, характеризующего поле игры Крестики-Нолики
 */
public class GameField {
    public static final int FIELD_SIZE = 3; // Игровое поле состоит из 3X3 клеток

    public static final byte EMPTY_FIELD = 0; // Значение для пустого поля
    public static final byte X = 1; //Значение для крестика
    public static final byte O = 2; // Значение для нолика
    private  static final byte SHIFT = 4; // Множитель для сдвига битов при операциях сжатия/восстановления игрового поля
    private byte[][] gameField; // Игровое поле

    /**
     * Метод для кодирования данных игры в целочисленное значение типа int
     * @param field Объект данных GameField
     * @return - Integer
     */
    public static int encode(GameField field){
        int value = 0;
        byte[][] gameField = field.getGameField();
        for (int y = 0; y < FIELD_SIZE; y++){
            for (int x = 0; x < FIELD_SIZE; x++){
                value = value * SHIFT + gameField[x][y];
            }
        }
        return value;
    }

    /**
     * Метод для декодирования целочисленного значения и создания на его основе нового объекта GameField
     * @param value - закодированое методом encode целочисленное значение
     * @return Новый объект GameField
     */
    public static GameField decode(int value){
        int fieldValue;
        GameField field = new GameField();
        for (int y = FIELD_SIZE - 1; y >= 0; y--){
            for (int x = FIELD_SIZE - 1; x >=0; x--){
                fieldValue = value % SHIFT;
                value /= SHIFT;
                if (fieldValue == X) field.setX(x, y);
                if (fieldValue == O) field.setO(x, y);
            }
        }
        return field;
    }
    public GameField() {
        this.gameField = new byte[FIELD_SIZE][FIELD_SIZE];
        for (int y = 0; y < FIELD_SIZE; y++){
            for (int x= 0; x < FIELD_SIZE; x++){
                this.gameField[x][y] = EMPTY_FIELD;
            }
        }
    }
    public byte[][] getGameField(){
        return this.gameField.clone(); // Возвращается копия игрового массива с данными
    }
    public boolean setX(int x,int y){
        return setValue(x, y, X);// Пытаемся поставить в заданную ячейку крестик
    }
    public boolean setO(int x, int y){
        return setValue(x, y, O);// Пытаемся поставить в заданную ячейку нолик
    }
    private boolean setValue(int x, int y, byte value){// Ход в заданную ячейку поля
        if (x >= 0 && y >= 0 && x < FIELD_SIZE && y < FIELD_SIZE && this.gameField[x][y] == EMPTY_FIELD){
            this.gameField[x][y] = value;
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        StringBuilder field = new StringBuilder();
        for (int y = 0; y < FIELD_SIZE; y++){
            for (int x = 0; x < FIELD_SIZE; x++){
                if (this.gameField[x][y] == EMPTY_FIELD) field.append(" . ");
                if (this.gameField[x][y] == X) field.append(" X ");
                if (this.gameField[x][y] == O) field.append(" O ");
            }
            field.append("\n");
        }
        return field.toString();
    }
}
