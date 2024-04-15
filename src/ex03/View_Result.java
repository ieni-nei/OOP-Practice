package ex03;

import ex02.Calculate;
import ex02.Item2d;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас для відображення результатів обчислень.
 * 
 * @author @ieni-nei
 */
public class View_Result implements View {
    private final List<Item2d> items = new ArrayList<>();

    /**
     * Виводить результат.
     */
    @Override
    public void show() {
        header();
        body();
        footer();
    }

    /**
     * Виводить заголовок.
     */
    public void header() {
        System.out.println("========Результати обчислень========");
    }

    /**
     * Виводить тіло.
     */
    public void body() {
        for (Item2d item : items) {
            System.out.println("Аргументи: " + item.getArguments());
            double average = item.getResult();
            System.out.println("Середнє арифметичне: " + average);
            System.out.println("Результат у двійковому форматі: " + Calculate.toBinaryString(average));
            System.out.println("Кількість одиниць у двійковому поданні цілої частини: " + Calculate.countOnes(average));
        }
    }

    /**
     * Виводить підвал.
     */
    public void footer() {
        System.out.println("===================================");
    }

    /**
     * Повертає список елементів, які будуть відображені.
     *
     * @return Список елементів.
     */
    @Override
    public List<Item2d> getItems() {
        return this.items;
    }

    /**
     * Ініціалізує результати згенерованими значеннями.
     */
    @Override
    public void init() {
        items.clear();
        List<Double> arguments = Calculate.randomArguments();
        double average = Calculate.calculateAverage(arguments);
        items.add(new Item2d(arguments, average));
        System.out.println("Згенеровано 4 випадкові аргументи.");
    }

    /**
     * Ініціалізує результати зі стандартними значеннями.
     */
    @Override
    public void initDefault() {
        items.clear();
        double[] defaultArguments = {Math.PI / 6, Math.PI, 3 * Math.PI / 2, Math.PI / 2};
        List<Double> arguments = new ArrayList<>();
        for (double argument : defaultArguments) {
            arguments.add(Calculate.roundValue(argument, 2));
        }
        double average = Calculate.calculateAverage(arguments);
        items.add(new Item2d(arguments, average));
        System.out.println("Обрано 4 статичних аргументи.");
    }


    /**
     * Зберігає результати у файл за вказаним шляхом.
     *
     * @param path Шлях до файлу.
     * @throws IOException Виникає, якщо виникає помилка при збереженні даних у файл.
     */
    @Override
    public void save(String path) throws IOException {
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOut.writeObject(items);
            System.out.println("Збережено поточний результату у файлі " + path);
        }
    }

    /**
     * Відновлює раніше збережені результати з вказаного шляху.
     *
     * @param path Шлях до файлу збереження.
     * @throws IOException            Виникає, якщо виникає помилка при відновленні даних з файлу.
     * @throws ClassNotFoundException Виникає, якщо не вдається знайти клас під час відновлення даних з файлу.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void restore(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(path))) {
            items.clear();
            items.addAll((ArrayList<Item2d>) objectIn.readObject());
            System.out.println("Об'єкти відновлено з файлу " + path);
        }
    }
}
