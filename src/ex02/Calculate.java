package ex02;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Клас для обчислення значень та перетворення чисел.
 *
 * @author @ieni-nei
 */
public class Calculate {
    private static final Random random = new Random();

    /**
     * Генерує список випадкових аргументів.
     *
     * @return Список випадкових аргументів.
     */
    public static List<Double> randomArguments() {
        List<Double> arguments = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            // Генерує випадкове дійсне число від 0 до 1
            double argument = roundValue(random.nextDouble(), 2);
            arguments.add(argument);
        }
        return arguments;
    }

    /**
     * Обчислює середнє значення функції 1000*sin(α) для заданих аргументів.
     *
     * @param arguments Список аргументів.
     * @return Результат обчислення.
     */
    public static double calculateAverage(List<Double> arguments) {
        double sum = 0;
        for (double arg : arguments) {
            sum += 1000 * Math.sin(arg);
        }
        double average = sum / arguments.size();
        return roundValue(average, 1);
    }

    /**
     * Рахує кількість одиниць у двійковому представленні цілої частини середнього значення.
     *
     * @param average Середнє значення.
     * @return Кількість одиниць у двійковому представленні цілої частини середнього значення.
     */
    public static int countOnes(double average) {
        int intValue = (int) average;
        String binaryString = Integer.toBinaryString(intValue);
        int count = 0;
        for (char c : binaryString.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * Перетворює число в його двійкове представлення.
     *
     * @param number Число для перетворення.
     * @return Двійкове представлення числа.
     */
    public static String toBinaryString(double number) {
        int intValue = (int) number;
        return Integer.toBinaryString(intValue);
    }

    /**
     * Округлює число до вказаної кількості знаків після коми.
     *
     * @param value         Число для округлення.
     * @param decimalPlaces Кількість знаків після коми.
     * @return Округлене число.
     */
    public static double roundValue(double value, int decimalPlaces) {
        String pattern = "#.";
        for (int i = 0; i < decimalPlaces; i++) {
            pattern += "#";
        }
        DecimalFormat df = new DecimalFormat(pattern);
        // Замінюємо кому на крапку перед парсингом
        String formattedValue = df.format(value).replace(",", ".");
        return Double.parseDouble(formattedValue);
    }
}
