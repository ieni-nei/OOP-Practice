package test.ex04;

import ex04.View_Table;

import java.io.IOException;

/**
 * Клас для тестування основної функціональності.
 */
public class MainTest {
    /**
     * Головний метод для тестування основної функціональності.
     *
     * @param args Аргументи командного рядка (не використовуються в цій програмі).
     */
    public static void main(String[] args) {
        View_Table view = new View_Table();

        // Тестування ініціалізації
        System.out.println("Тестування ініціалізації:");
        view.init();
        view.show();

        // Тестування збереження та відновлення
        System.out.println("\nТестування збереження та відновлення:");
        try {
            view.save("temp/Task-4/test_item.dat");
            view.restore("temp/Task-4/test_item.dat");
            view.show();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
