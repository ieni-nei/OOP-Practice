package src.ex05;

import src.ex02.Item2d;
import src.ex03.View;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Консольна команда для сортування.
 */
public class SortConsoleCommand implements ConsoleCommand {

    private final View view;

    /**
     * Конструктор, що приймає екземпляр View.
     *
     * @param view Об'єкт, який показує дані.
     */
    public SortConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Повертає ключ команди.
     *
     * @return Ключ команди.
     */
    @Override
    public char getKey() {
        return 'S';
    }

    /**
     * Повертає рядок-опис команди.
     *
     * @return Опис команди.
     */
    @Override
    public String toString() {
        return "'S'ort";
    }

    /**
     * Виконує сортування елементів та показує їх.
     */
    @Override
    public void execute() {
        // Отримання списку елементів з представлення
        List<Item2d> items = view.getItems();

        // Сортування елементів за допомогою Comparator, який порівнює результати
        Collections.sort(items, Comparator.comparing(Item2d::getResult));

        // Показ результатів після сортування
        view.show();
    }
}
