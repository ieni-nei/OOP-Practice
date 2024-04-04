package src.ex05;

import src.ex03.View;

/**Консольна команда View
 *
 */
public class ViewConsoleCommand implements ConsoleCommand {

    private final View view;

    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'v';
    }

    @Override
    public String toString() {
        return "'v'iew";
    }

    @Override
    public void execute() {
        System.out.println("Переглянути поточний.");
        view.show();
    }
}