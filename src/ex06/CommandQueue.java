package ex06;

import ex05.Command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Клас, що реалізує чергу команд.
 */
public class CommandQueue {

    private final Queue<Command> tasks;
    private boolean shutdown = false;

    /**
     * Закриває чергу команд.
     */
    public synchronized void shutdown() {
        this.shutdown = true;
        notifyAll();
    }

    /**
     * Конструктор класу CommandQueue.
     */
    public CommandQueue() {
        tasks = new LinkedList<>();
    }

    /**
     * Додає команду до черги.
     *
     * @param command Команда, яку потрібно додати до черги.
     */
    public synchronized void put(Command command) {
        tasks.add(command);
        notifyAll();
    }

    /**
     * Повертає та видаляє команду з черги.
     *
     * @return Команда, що вийшла з черги.
     * @throws InterruptedException Виникає, якщо виникає помилка під час очікування команди у черзі.
     */
    public synchronized Command take() throws InterruptedException {
        while (tasks.isEmpty() && !shutdown) {
            wait();
        }
        return tasks.poll();
    }
}
