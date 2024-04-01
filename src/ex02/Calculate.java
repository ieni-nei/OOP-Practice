package src.ex02;

/**
 * Клас для обчислення середнього арифметичного та кількості одиниць у двійковому поданні цілої частини.
 */
public class Calculate {
    /**
     * Обчислює середнє арифметичне значення функції 1000*sin(α) для заданих аргументів.
     * @param arguments Масив аргументів.
     * @return Результат обчислення.
     */
    public static double calculateAverage(double[] arguments) {
        double sum = 0;
        for (double arg : arguments) {
            sum += 1000 * Math.sin(arg);
        }
        return sum / arguments.length;
    }

    /**
     * Обчислює кількість одиниць у двійковому поданні цілої частини середнього арифметичного.
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
}
