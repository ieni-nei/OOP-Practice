package src.ex05;

import src.ex03.View;
/**Консольна команда Generate
 *
 */
public class GenerateConsoleCommand implements ConsoleCommand {
    
    private final View view;
    
    public GenerateConsoleCommand(View view){
        this.view = view;
    }
    
    @Override
    public char getKey(){
        return 'g';
    }
    
    @Override
    public String toString(){
        return "'g'enerate";
    }
    
    @Override
    public void execute(){
        view.init();
        view.show();
    }
}
