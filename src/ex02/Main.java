package ex02;

import java.io.*;

/**
 * Клас для демонстрації збереження та відновлення стану об'єкта з використанням серіалізації.
 */
public class Main {
    /**
     * Головний метод.
     * 
     * @author @ieni-nei
     * @param args Аргументи командного рядка (не використовуються в цій програмі).
     */
    public static void main(String[] args) {
        // Створення екземпляра Item2d
        Item2d item = new Item2d(Calculate.randomArguments());

        // Серіалізація Item2d до файлу
        serializeObject(item, "temp/Task-2/item.dat");

        // Десеріалізація Item2d з файлу
        Item2d deserializedItem = (Item2d) deserializeObject("temp/Task-2/item.dat");

        // Обчислення середнього значення
        double average = Calculate.calculateAverage(deserializedItem.getArguments());
        deserializedItem.setResult(average);

        // Виведення результатів
        System.out.println("Серіалізований та десеріалізований елемент:");
        System.out.print("Аргументи: ");
        for (double arg : deserializedItem.getArguments()) {
            System.out.print(Calculate.roundValue(arg, 2) + " ");
        }
        System.out.println();
        System.out.println("Середнє арифметичне: " + Calculate.roundValue(deserializedItem.getResult(), 1));
        System.out.println("Кількість одиниць у двійковому поданні цілої частини: " + Calculate.countOnes(deserializedItem.getResult()));
    }

    /**
     * Серіалізує об’єкт у файл.
     * @param obj Об’єкт для серіалізації.
     * @param fileName Назва файлу, куди буде збережено серіалізований об’єкт.
     */
    private static void serializeObject(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
            System.out.println("Об'єкт збережено у файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Десеріалізує об'єкт з файлу.
     * @param fileName Назва файлу, звідки буде відновлено об'єкт.
     * @return Десеріалізований об'єкт.
     */
    private static Object deserializeObject(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
