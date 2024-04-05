package src.ex05;

import src.ex03.View;
import src.ex02.Item2d;

import java.util.List;
import java.util.Random;

/**
 * Консольна команда, яка виконує зміну значень елементів на випадковий зсув.
 */
public class ChangeConsoleCommand implements ConsoleCommand {
    private final View view;

    /**
     * Конструктор з параметром.
     *
     * @param view Вид.
     */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'c';
    }

    @Override
    public String toString() {
        return "'c'hange";
    }

    @Override
    public void execute() {
        Random random = new Random();
        int offset = random.nextInt(10);

        List<Item2d> items = view.getItems();
        for (Item2d item : items) {
            double result = item.getResult() + offset;
            item.setResult(result);
        }
    }
}
