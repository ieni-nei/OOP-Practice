package ex05;

import ex03.View;

/**
 * Консольна команда, що скасовує команду. 
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
        boolean un = History.undo(view);

        if (!un) {
            System.out.println("Зміни відсутні.");
        }
    }
}
