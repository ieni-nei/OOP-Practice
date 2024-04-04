import java.text.DecimalFormat;

/**
 * Клас для обчислення середнього арифметичного та кількості одиниць у двійковому поданні цілої частини.
 */
public class Calculate {
    /**
     * Обчислює середнє арифметичне значення функції 1000*sin(α) для заданих аргументів.
     *
     * @param arguments Масив аргументів.
     * @return Результат обчислення.
     */
    public static double calculateAverage(double[] arguments) {
        double sum = 0;
        for (double arg : arguments) {
            sum += 1000 * Math.sin(arg);
        }
        double value = roundValue(sum / arguments.length, 1);
        return value;
    }

    /**
     * Обчислює кількість одиниць у двійковому поданні цілої частини середнього арифметичного.
     *
     * @param average Середнє арифметичне значення.
     * @return Кількість одиниць у двійковому поданні цілої частини.
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
     * Перетворює число в двійкове представлення.
     *
     * @param number Число для перетворення.
     * @return Двійкове представлення числа.
     */
    public static String toBinaryString(double number) {
        int intValue = (int) number;
        return Integer.toBinaryString(intValue);
    }

    /**
     * Округлює число до заданої кількості знаків після коми.
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
        return Double.parseDouble(df.format(value));
    }
}
