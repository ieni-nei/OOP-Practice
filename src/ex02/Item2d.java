package src.ex02;

import java.io.*;

/**
 * Клас, що представляє параметри та результати обчислень.
 */
public class Item2d implements Serializable {
    private static final long serialVersionUID = 1L;
    private double[] arguments;
    private double result;

    /**
     * Конструктор для створення екземпляра класу з параметрами.
     * @param arguments Аргументи функції.
     * @param result Результат обчислення.
     */
    public Item2d(double[] arguments, double result) {
        this.arguments = arguments;
        this.result = result;
    }

    /**
     * Повертає аргументи функції.
     * @return Масив аргументів функції.
     */
    public double[] getArguments() {
        return arguments;
    }

    /**
     * Повертає результат обчислення.
     * @return Результат обчислення.
     */
    public double getResult() {
        return result;
    }

    /**
     * Зберігає об'єкт у двійковий файл.
     * @param fileName Назва файлу.
     * @throws IOException Якщо сталася помилка вводу-виводу.
     */
    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(this);
        }
    }

    /**
     * Відновлює об'єкт з двійкового файлу.
     * @param fileName Назва файлу.
     * @return Відновлений об'єкт.
     * @throws IOException Якщо сталася помилка вводу-виводу.
     * @throws ClassNotFoundException Якщо клас не був знайдений при десеріалізації.
     */
    public static Item2d restoreFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Item2d) inputStream.readObject();
        }
    }
}
