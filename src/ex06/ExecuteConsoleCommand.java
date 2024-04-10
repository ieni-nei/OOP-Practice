package ex06;

import ex03.View;
import ex03.View_Result;
import ex05.ConsoleCommand;

import java.util.concurrent.TimeUnit;

public class ExecuteConsoleCommand implements ConsoleCommand {

    private View view;

    public ExecuteConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'e';
    }

    @Override
    public String toString() {
        return "'e'xecute";
    }

    @Override
    public void execute() {
        System.out.println("Запуст виконання потоків...");

        CommandQueue queue1 = new CommandQueue();
        CommandQueue queue2 = new CommandQueue();

        AvgCommand avgCommand = new AvgCommand(view);
        MaxCommand maxCommand = new MaxCommand(view);
        MinCommand minCommand = new MinCommand(view);

        queue1.put(avgCommand);
        queue2.put(maxCommand);
        queue2.put(minCommand);

        while (avgCommand.isRunning() || maxCommand.isRunning() || minCommand.isRunning()) {
            TimeUnit.MICROSECONDS.sleep(100);
        }

        queue1.shutdown();
        queue2.shutdown();

        System.out.println("Звершення роботи потоків.");
    }
}
