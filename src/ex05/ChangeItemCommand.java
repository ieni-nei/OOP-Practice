package src.ex05;

import src.ex02.Item2d;
import java.util.List;
import java.util.Scanner;

/** 
 * Консольна команда Зміна елементу.
 */
public class ChangeItemCommand implements Command {

    private final Scanner scanner;
    private final List<Item2d> items;

    public ChangeItemCommand(Scanner scanner, List<Item2d> items) {
        this.scanner = scanner;
        this.items = items;
    }

    @Override
    public void execute() {
        // Перевірка наявності елементів у списку
        if (items == null || items.isEmpty()) {
            System.out.println("Помилка: список елементів порожній.");
            return;
        }

        // Відображення списку елементів для вибору
        System.out.println("Список елементів:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ": " + items.get(i));
        }

        // Введення індексу елемента, який потрібно змінити
        System.out.print("Введіть індекс елемента, який ви хочете змінити: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Забираємо зайвий перехід на новий рядок

        // Перевірка дійсності індексу
        if (index < 0 || index >= items.size()) {
            System.out.println("Помилка: недійсний індекс.");
            return;
        }

        // Отримання вибраного елемента
        Item2d item = items.get(index);

        // Введення значення зміщення
        System.out.print("Введіть значення зміщення: ");
        double offsetValue = scanner.nextDouble();
        scanner.nextLine(); // Забираємо зайвий перехід на новий рядок

        // Застосування зміщення до елемента
        double newResult = item.getResult() + offsetValue;
        item.setResult(newResult);

        System.out.println("Елемент було змінено. Нове значення результату: " + newResult);
    }
}
