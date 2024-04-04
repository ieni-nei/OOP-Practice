package src.ex05;

import src.ex03.View;
/**Консольна команда Undo 
 *
 */
public class UndoConsoleCommand implements ConsoleCommand {

    private final View view;
    
    public UndoConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'u';
    }

    @Override
    public String toString() {
        return "'u'ndo";
    }

    @Override
    public void execute() {
        UndoReserve un = new UndoReserve(view);
        System.out.println("Скасувано останню команду.");
        try {
            un.undo();
        } catch (Exception e) {
            System.err.println("Помилка серіалізації: " + e);
        }
        view.show();
    }
}
