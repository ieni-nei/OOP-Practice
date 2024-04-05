package src.ex05;

import src.ex02.Item2d;
import java.util.Scanner;

/**
 * Команда консолі для зміни елемента.
 */
public class ChangeItemCommand implements Command {

    private Item2d item;
    private int offset;
    private Scanner scanner;

    /**
     * Конструктор з параметрами.
     *
     * @param scanner Сканер для введення користувача.
     * @param item    Елемент, який потрібно змінити.
     */
    public ChangeItemCommand(Scanner scanner, Item2d item) {
        this.scanner = scanner;
        this.item = item;
    }

    /**
     * Встановлює новий елемент.
     *
     * @param item Новий елемент.
     */
    public void setItem(Item2d item) {
        this.item = item;
    }

    /**
     * Повертає поточний елемент.
     *
     * @return Поточний елемент.
     */
    public Item2d getItem() {
        return this.item;
    }

    /**
     * Встановлює нове значення зміщення.
     *
     * @param offset Нове значення зміщення.
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * Повертає поточне значення зміщення.
     *
     * @return Поточне значення зміщення.
     */
    public int getOffset() {
        return this.offset;
    }

    /**
     * Виконує команду зміни елемента.
     */
    @Override
    public void execute() {
        if (item != null) {
            System.out.print("Введіть нове значення зміщення: ");
            int newOffset = scanner.nextInt();
            setOffset(newOffset);
            double newResult = item.getResult() + getOffset();
            item.setResult(newResult);
            System.out.println("Змінено значення елемента. Новий результат: " + newResult);
        } else {
            System.out.println("Помилка: елемент не було ініціалізовано.");
        }
    }
}
