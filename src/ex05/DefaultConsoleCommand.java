package ex05;

import ex03.View;

public class DefaultConsoleCommand implements ConsoleCommand {
        
    private final View view;
    
    public DefaultConsoleCommand(View view){
        this.view = view;
    }
    
    @Override
    public char getKey(){
        return 'd';
    }
    
    @Override
    public String toString(){
        return "'d'efault";
    }
    
    @Override
    public void execute(){
        view.initDefault();
        view.show();
    }
}
