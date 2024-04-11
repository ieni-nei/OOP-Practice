package ex06;

import ex03.View;
import ex05.Command;
import ex05.ConsoleCommand;

import java.util.concurrent.*;

/**
 * Команда для виконання інших команд у відокремленому потоці.
 * Забезпечує виконання переданих команд у відокремленому потоці, використовуючи ExecutorService.
 */
public class ExecuteConsoleCommand implements ConsoleCommand {

    private View view;

    /**
     * Конструктор, що ініціалізує об'єкт класу ExecuteConsoleCommand з переданим інтерфейсом View.
     * @param view інтерфейс для відображення результатів обчислень
     */
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
        System.out.println("Запуск виконання потоків...");

        // Створення ExecutorService з двома потоками
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Подання команд до сервісу виконання
        executorService.execute(new CommandRunner(new AvgCommand(view)));
        executorService.execute(new CommandRunner(new MinMaxCommand(view)));

        // Зупинка сервісу виконання
        executorService.shutdown();

        // Очікування завершення виконання всіх команд
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Завершення роботи потоків.");
    }

    // Внутрішній клас для адаптації класів Command до Runnable
    private static class CommandRunner implements Runnable {
        private final Command command;

        /**
         * Конструктор, що ініціалізує об'єкт CommandRunner з переданою командою.
         * @param command команда для виконання
         */
        public CommandRunner(Command command) {
            this.command = command;
        }

        @Override
        public void run() {
            command.execute();
        }
    }
}
