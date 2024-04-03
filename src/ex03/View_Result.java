package src.ex03;

import src.ex02.Calculate;
import src.ex02.Item2d;

import java.io.*;
import java.util.ArrayList;

/**
 * Клас для відображення результатів обчислень.
 */
public class View_Result implements View {
    private ArrayList<Item2d> items = new ArrayList<>();
    
    /**
     * Конструктор класу View_Result без параметрів.
     */
    public View_Result() {
        super();
    }

    @Override
    public void show() {
        header();
        body();
        footer();
    }

    public void header() {
        System.out.println("========Результати обчислень========");
    }

    public void body() {
        double sum = 0;
        System.out.print("Аргументи: ");
        for (Item2d item : items) {
            double[] arguments = item.getArguments();
            for (int i = 0; i < arguments.length; i++) {
                System.out.print(arguments[i]);
                sum += arguments[i];
                if (i < arguments.length - 1 || items.indexOf(item) < items.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
        double average = sum / items.size();
        System.out.println("Середнє арифметичне: " + average);
        System.out.println("Результат у двійковому форматі: " + Calculate.toBinaryString(average));
        System.out.println("Кількість одиниць у двійковому поданні цілої частини: " + Calculate.countOnes(average));
    }

    public void footer() {
        System.out.println("===================================");
    }

    @Override
    public void init() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            items.clear();
            for (int i = 0; i < 4; i++) {
                System.out.print("Введіть " + (i + 1) + "-й аргумент: ");
                double argument = Double.parseDouble(br.readLine());
                double[] arguments = {argument};
                Item2d item = new Item2d(arguments);
                items.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initDefault() {
        items.clear();
        double[] defaultArguments = {Math.PI / 6, Math.PI, 3 * Math.PI / 2, Math.PI / 2};
        for (double argument : defaultArguments) {
            double[] arguments = {Calculate.roundValue(argument, 2)};
            Item2d item = new Item2d(arguments);
            items.add(item);
        }
    }

    @Override
    public void save(String path) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this.items);
            System.out.println("    Об'єкти збережено у файл " + path);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void restore(String path) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(path);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            this.items = (ArrayList<Item2d>) objectIn.readObject();
            System.out.println("    Об'єкти відновлено з файлу " + path);
        }
    }
}
