package src.ex04;

import src.ex03.View;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Клас для демонстрації збереження та відновлення стану об'єкта з використанням серіалізації.
 * 
 * @author Головненко Леонід aka @ieni-nei
 */
public class Main {
    /**
     * Головний метод програми.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        View view = new Viewable_Table().getView();

        // Очистити консоль
        System.out.print("\033[H\033[2J");
        System.out.flush();

        while (true) {
            System.out.println("Оберіть дію:");
            System.out.println("1. Ввести чотири довільні аргументи");
            System.out.println("2. Використати аргументи за замовчуванням");
            System.out.println("3. Показати результати");
            System.out.println("4. Зберегти результати у файл");
            System.out.println("5. Відновити результати з файлу");
            System.out.println("6. Вийти");
            System.out.print("Введіть номер дії: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        view.init();
                        break;
                    case 2:
                        view.initDefault();
                        break;
                    case 3:
                        view.show();
                        break;
                    case 4:
                        view.save("temp/Task-4/item.dat");
                        break;
                    case 5:
                        File file = new File("temp/Task-4/item.dat");
                        if (file.exists()) {
                            view.restore("temp/Task-4/item.dat");
                        } else {
                            System.out.println("Спочатку збережіть результати у файл.");
                        }
                        break;
                    case 6:
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Невірний вибір, введіть номер дії зі списку.");
                        break;
                }
            } catch (NoSuchElementException e) {
                System.out.println("Невірний ввід, введіть ціле число.");
                scanner.nextLine(); // Consume invalid input
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
