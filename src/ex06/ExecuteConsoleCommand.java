package ex06;

import ex03.View;
import ex05.ConsoleCommand;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Команда для виконання інших команд у відокремленому потоці.
 * Забезпечує виконання переданих команд у відокремленому потоці, використовуючи ExecutorService.
 */
public class ExecuteConsoleCommand implements ConsoleCommand {

    private View view;

    /**
     * Конструктор, що ініціалізує об'єкт класу ExecuteConsoleCommand з переданим інтерфейсом View.
     *
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
        executorService.submit(() -> {
            new AvgCommand(view).execute();
        });

        executorService.submit(() -> {
            new MinMaxCommand(view).execute();
        });

        // Зупинка сервісу виконання
        executorService.shutdown();

        // Очікування завершення виконання всіх команд
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executorService.shutdown();

        System.out.println("Завершення роботи потоків.");
    }
}
