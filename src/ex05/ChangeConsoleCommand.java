package ex05;

import ex03.View;
import ex02.Item2d;

import java.util.List;

/**
 * Консольна команда, яка виконує зміну значень елементів на введений зсув.
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

    /**
     * Виконує зміну значень елементів.
     */
    @Override
    public void execute() {
        List<Item2d> items = view.getItems();
        for (Item2d item : items) {
            Command changeItemCommand = new ChangeItemCommand(item);
            changeItemCommand.execute();
        }
    }
}
