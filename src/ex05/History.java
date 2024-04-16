package ex05;

import ex02.Item2d;
import ex03.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Клас який зберігає попередні результати обчислень для подальшого скасування команд.
 * Використовує патерн Singleton для створення єдиного екземпляра класу.
 */

public class History  {
    private static final History instance = new History();
    private static final Stack<List<Item2d>> history = new Stack<>();

    // Приватний конструктор класу
    private History() {}

    // Повертає єдиний екземпляр класу
    public static History getInstance() {
        return instance;
    }

    // Додає результати в історію результатів
    public void add(List<Item2d> items) {
        history.push(new ArrayList<>(items));
    }

    /**
     * Видаляє зі стеку та повертає останній список результатів.
     *
     * @return Минулі результати обчислень
     */
    public static boolean undo(View view) {
        if (history.isEmpty()) {
            return false;
        }

        view.setItems(history.pop());
        return true;
    }
}
