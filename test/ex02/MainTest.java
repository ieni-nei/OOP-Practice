package test.ex02;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import src.ex02.Calculate;
import src.ex02.Item2d;

/**
 * Клас для тестування коректності результатів обчислень та серіалізації/десеріалізації.
 */
public class MainTest {
    /**
     * Головний метод.
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        testCalculate();
        testSerialization();
    }

    /**
     * Тестує коректність результатів обчислень.
     */
    private static void testCalculate() {
        double[] arguments = {Math.PI/6, Math.PI, 3 * Math.PI/2, Math.PI/2};
        double average = Calculate.calculateAverage(arguments);
        int onesCount = Calculate.countOnes(average);
        
        // Перевірити, чи відповідає onesCount очікуваному значенню
        if (onesCount == 6) {
            System.out.println("Тест обчислень пройдено успішно.");
        } else {
            System.err.println("Помилка: Очікувана кількість одиниць: 6, Фактична кількість одиниць: " + onesCount);
        }
    }

    /**
     * Тестує коректність серіалізації та десеріалізації об'єкта.
     */
    private static void testSerialization() {
        double[] arguments = {Math.PI/6, Math.PI, 3 * Math.PI/2, Math.PI/2};
        double average = Calculate.calculateAverage(arguments);
        Item2d item = new Item2d(arguments, average);

        // Серіалізація та десеріалізація об'єкта
        Item2d deserializedItem = (Item2d) deserializeObject(serializeObject(item));

        // Перевірка коректності десеріалізованого об'єкта
        if (deserializedItem != null && deserializedItem.getResult() == item.getResult()) {
            System.out.println("Тест серіалізації та десеріалізації пройдено успішно.");
        } else {
            System.err.println("Помилка серіалізації/десеріалізації");
        }
    }

    /**
     * Серіалізує об'єкт та повертає його у вигляді масиву байтів.
     * @param obj Об'єкт для серіалізації.
     * @return Масив байтів.
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
     * Десеріалізує об'єкт з масиву байтів.
     * @param bytes Масив байтів.
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
}
