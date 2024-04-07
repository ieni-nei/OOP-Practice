package ex05;

import ex03.View;

/**Консольна команда Restore
 *
 */
public class RestoreConsoleCommand implements ConsoleCommand {

    private View view;

    public RestoreConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'r';
    }

    @Override
    public String toString() {
        return "'r'estore";
    }

    @Override
    public void execute() {
        try {
            view.restore("temp/Task-5/item.dat");
        } catch (Exception e) {
            System.err.println("Помилка серіалізації: " + e);
        }
    }
}
