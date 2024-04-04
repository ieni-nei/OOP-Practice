package test.ex02;

import src.ex02.Calculate;
import src.ex02.Item2d;

import java.io.*;

/**
 * Клас для тестування серіалізації/десеріалізації та обчислення середнього значення.
 * 
 * @author Головненко Леонід aka @ieni-nei
 */
public class MainTest {
    /**
     * Головний метод, який запускає тестування серіалізації/десеріалізації та обчислення середнього значення.
     * @param args Аргументи командного рядка (не використовуються в цій програмі).
     */
    public static void main(String[] args) {
        testSerializationDeserialization();
        testCalculateAverage();
    }

    /**
     * Тестує серіалізацію/десеріалізацію об'єкта Item2d.
     */
    private static void testSerializationDeserialization() {
        clearConsole();
        System.out.println("Тестування серіалізації/десеріалізації...");

        // Створення тестового об'єкта Item2d
        double[] arguments = {Math.PI/6, Math.PI, 3 * Math.PI/2, Math.PI/2};
        Item2d originalItem = new Item2d(arguments);

        // Серіалізація та десеріалізація об'єкта
        serializeAndDeserialize(originalItem);
    }

    /**
     * Тестує обчислення середнього значення за допомогою методу calculateAverage класу Calculate.
     */
    private static void testCalculateAverage() {
        System.out.println("Тестування Calculate.calculateAverage()...");
        // Створення тестового об'єкта Item2d
        double[] arguments = {Math.PI/6, Math.PI, 3 * Math.PI/2, Math.PI/2};
        Item2d item = new Item2d(arguments);

        // Обчислення середнього значення
        double calculatedAverage = Calculate.calculateAverage(item.getArguments());

        // Очікуване середнє значення
        double expectedAverage = (1000 * Math.sin(arguments[0]) +
                1000 * Math.sin(arguments[1]) +
                1000 * Math.sin(arguments[2]) +
                1000 * Math.sin(arguments[3])) / 4;

        // Порівняння обчисленого середнього значення з очікуваним
        if (Math.abs(calculatedAverage - expectedAverage) < 0.0001) {
            System.out.println("Тест Calculate.calculateAverage() пройдено.");
        } else {
            System.out.println("Тест Calculate.calculateAverage() не пройдено.");
        }
    }

    /**
     * Серіалізує та десеріалізує об'єкт, а потім порівнює оригінальний та десеріалізований об'єкти.
     * @param originalItem Оригінальний об'єкт для серіалізації та десеріалізації.
     */
    private static void serializeAndDeserialize(Item2d originalItem) {
        // Серіалізація об'єкта
        serializeObject(originalItem, "temp/Task-2/item.dat");

        // Десеріалізація об'єкта
        Item2d deserializedItem = (Item2d) deserializeObject("temp/Task-2/item.dat");

        // Відлагоджувальна інформація
        System.out.println("Оригінальний об'єкт: " + originalItem);
        System.out.println("Десеріалізований об'єкт: " + deserializedItem);

        // Порівняння оригінального та десеріалізованого об'єктів
        if (originalItem.equals(deserializedItem)) {
            System.out.println("Тест серіалізації/десеріалізації пройдено.");
        } else {
            System.out.println("Тест серіалізації/десеріалізації не пройдено.");
        }
    }

    /**
     * Серіалізує об'єкт до файлу.
     * @param obj Об'єкт для серіалізації.
     * @param fileName Назва файлу, куди буде збережено серіалізований об'єкт.
     */
    private static void serializeObject(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
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

    /**
     * Очищає консоль.
     */
    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
