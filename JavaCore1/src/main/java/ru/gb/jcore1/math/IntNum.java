package ru.gb.jcore1.math;

/**
 * Класс для создания Data обьекта, содержащего:
 * Первый целочисленный аргумент;
 * Второй целочисленный аргумент;
 * Обозначение математической операции;
 * Результат операции;
 */
public class IntNum {
    public final String mathOperation;
    public final int firstArg, secondArg, result;
    public final boolean isOperationPossible;

    /**
     * Конструктор для создания IntNum обьекта в случае возможности выполнения требуемой математической операции
     *
     * @param firstArg      первый целочисленный аргумент
     * @param secondArg     второй целочисленный аргумент
     * @param mathOperation обозначение математической операции
     * @param result        результат операции
     */
    public IntNum(int firstArg, int secondArg, String mathOperation, int result) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        this.mathOperation = mathOperation;
        this.result = result;
        this.isOperationPossible = true;
    }

    /**
     * Конструктор для создания Num обьекта при условии, что операция невозможна, содержит:
     *
     * @param firstArg      первый целочисленный аргумент
     * @param secondArg     второй целочисленный аргумент
     * @param mathOperation обозначение математической операции
     */
    public IntNum(int firstArg, int secondArg, String mathOperation) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        this.mathOperation = mathOperation;
        this.result = 0; // Результат не имеет смысла, но переменную инициализировать надо
        this.isOperationPossible = false;
    }

    /**
     * Переопределение метода toString для IntNum обьекта
     *
     * @return возвращает строку с математическим выражением и результатом его выполнения
     */
    @Override
    public String toString() {
        if (this.isOperationPossible) {
            return String.format("%d %s %d = %d", this.firstArg, this.mathOperation, this.secondArg, this.result);
        }
        return String.format("%d %s %d = UNDEFINED", this.firstArg, this.mathOperation, this.secondArg);
    }
}
