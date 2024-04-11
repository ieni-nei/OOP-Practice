package ex06;

import ex05.Command;

/**
 * Інтерфейс, що представляє чергу команд.
 */
public interface Queue {

    /**
     * Додає команду до черги.
     *
     * @param command Команда, яку потрібно додати до черги.
     */
    void put(Command command);

    /**
     * Повертає та видаляє команду з черги.
     *
     * @return Команда, що вийшла з черги.
     * @throws InterruptedException Виникає, якщо виникає помилка під час очікування команди у черзі.
     */
    Command take() throws InterruptedException;
}
