package src.ex03;

import src.ex02.Item2d;

/**
 * Абстрактний клас для відображення результатів обчислень.
 */
public abstract class View {
    protected Item2d item;

    /**
     * Конструктор класу View.
     * @param item Об'єкт, результати якого будуть відображені.
     */
    public View(Item2d item) {
        this.item = item;
    }

    /**
     * Метод для відображення результатів.
     */
    public abstract void display();
}
