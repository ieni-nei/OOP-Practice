package src.ex03;

import java.io.Serializable;

/**
 * Інтерфейс для об'єктів, що можуть бути відображені.
 */
public interface Viewable extends Serializable {
    /**
     * Метод для відображення об'єкта.
     */
    void display();
}
