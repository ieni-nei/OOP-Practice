package ex06;

import ex03.View;
import ex03.View_Result;
import ex05.ConsoleCommand;

import java.util.concurrent.TimeUnit;

public class ExecuteConsoleCommand implements ConsoleCommand {

    private View view;
    private CommandQueue commandQueue;

    public ExecuteConsoleCommand(View view, CommandQueue commandQueue) {
        this.view = view;
        this.commandQueue = commandQueue;
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
        System.out.println("Запустити всі потоки...");

        StatisticCommand statisticCommand = new StatisticCommand((View_Result) view);
        commandQueue.put(statisticCommand);

        try {
            while (!commandQueue.isEmpty()) {
                TimeUnit.MILLISECONDS.sleep(100);
            }

            commandQueue.shutdown();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
        System.out.println("Виконано.");
    }
}
