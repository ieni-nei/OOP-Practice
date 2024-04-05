package src.ex05;

import src.ex03.View;

import java.io.IOException;

/**Консольна команда Save
 */
public class SaveConsoleCommand implements ConsoleCommand {

    private final View view;

    public SaveConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 's';
    }

    @Override
    public String toString() {
        return "'s'ave";
    }

    @Override
    public void execute() {
        try {
            view.save("temp/Task-5/item.dat");
        } catch (IOException e) {
            System.err.println("Помилка серіалізації: " + e);
        }
    }
}
