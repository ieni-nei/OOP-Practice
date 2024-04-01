package src.ex02;

import java.io.*;
import java.text.DecimalFormat;

/**
 * Клас для демонстрації збереження та відновлення стану об'єкта з використанням серіалізації.
 */
public class Main {
    /**
     * Головний метод.
     * @param args Аргументи командного рядка (не використовуються в цій програмі).
     */
    public static void main(String[] args) {
        // Створення екземпляра Item2d
        double[] arguments = {Math.PI/6, Math.PI, 3 * Math.PI/2, Math.PI/2};
        double average = Calculate.calculateAverage(arguments);
        int onesCount = Calculate.countOnes(average);
        Item2d item = new Item2d(arguments, average);

        // Серіалізація Item2d до байтового масиву
        byte[] serializedItem = serializeObject(item);

        // Десеріалізація Item2d з байтового масиву
        Item2d deserializedItem = (Item2d) deserializeObject(serializedItem);

        // Відображення перехідного значення поля до серіалізації та після десеріалізації
        System.out.println("Перехідне значення transient поля перед серіалізацією: " + item.getTransientField());
        System.out.println("Перехідне значення transient поля після десеріалізації: " + deserializedItem.getTransientField());
        System.out.println();

        // Виведення результатів
        System.out.println("Серіалізований та десеріалізований елемент:");
        System.out.print("Аргументи: ");
            for (double arg : deserializedItem.getArguments()) {
                System.out.print(round(arg, 2) + " ");
            }
        System.out.println();
        System.out.println("Середнє арифметичне: " + round(deserializedItem.getResult(), 1));
        System.out.println("Кількість одиниць у двійковому поданні цілої частини: " + onesCount);
    }

    /**
     * Серіалізує об’єкт у масив байтів.
     * @param obj Об’єкт для серіалізації.
     * @return Масив байтів, що містить серіалізований об’єкт.
     */
    private static byte[] serializeObject(Object obj) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(obj);
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Десеріалізує об'єкт із байтового масиву.
     * @param bytes Масив байтів, що містить серіалізований об’єкт.
     * @return Десеріалізований об'єкт.
     */
    private static Object deserializeObject(byte[] bytes) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Округлює подвійне значення до вказаної кількості знаків після коми.
     * @param value Значення, що округляється.
     * @param decimalPlaces Кількість знаків після коми для округлення.
     * @return Округлене значення.
     */
    private static double round(double value, int decimalPlaces) {
        String pattern = "#.";
        for (int i = 0; i < decimalPlaces; i++) {
            pattern += "#";
        }
        DecimalFormat df = new DecimalFormat(pattern);
        return Double.parseDouble(df.format(value));
    }
}
