package src.ex03;

import src.ex02.Calculate;
import src.ex02.Item2d;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас для демонстрації збереження та відновлення стану об'єкта за допомогою серіалізації.
 */
public class Main {
    /**
     * Головний метод.
     *
     * @param args Аргументи командного рядка (не використовуються в цій програмі).
     */
    public static void main(String[] args) {
        double[] arguments = {Math.PI / 6, Math.PI, 3 * Math.PI / 2, Math.PI / 2};
        double average = Calculate.calculateAverage(arguments);
        Item2d item = new Item2d(arguments, average);

        // Створення списку для зберігання об'єктів типу Viewable
        List<Viewable> views = new ArrayList<>();
        views.add(new View_Result(item));

        // Відображення представлень
        for (Viewable view : views) {
            view.display();
        }
    }
}
