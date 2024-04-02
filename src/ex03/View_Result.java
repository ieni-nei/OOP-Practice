package src.ex03;

import src.ex02.Calculate;
import src.ex02.Item2d;

import java.text.DecimalFormat;


/**
 * Клас для відображення результатів обчислень.
 */
public class View_Result extends View implements Viewable_Result {
    /**
     * Конструктор класу View_Result з параметрами.
     * @param item Об'єкт, результати якого будуть відображені.
     */
    public View_Result(Item2d item) {
        super(item);
    }

    @Override
    public void display() {
        displayResult();
    }

    @Override
    public void displayResult() {
        System.out.print("Аргументи: ");
        for (double arg : item.getArguments()) {
            System.out.print(roundValue(arg, 2) + " ");
        }
        System.out.println();
        System.out.println("Середнє арифметичне: " + roundValue(item.getResult(), 1));
        System.out.println("Результат у двійковому форматі: " + Calculate.toBinaryString(item.getResult()));
        System.out.println("Кількість одиниць у двійковому поданні цілої частини: " + Calculate.countOnes(item.getResult()));
    }

    private static double roundValue(double value, int decimalPlaces) {
        String pattern = "#.";
        for (int i = 0; i < decimalPlaces; i++) {
            pattern += "#";
        }
        DecimalFormat df = new DecimalFormat(pattern);
        return Double.parseDouble(df.format(value));
    }
}
