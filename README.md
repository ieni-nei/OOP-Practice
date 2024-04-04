# Практика з ООП
### **Навігація**
<img src="images/GIF/Webarebears.gif" height="175px" align="right">

| Завдання та зображення                             |      Коди       |        Тести        |
| :------------------------------------------------- | :-------------: | :-----------------: |
| [Завдання 4]()                                     | [Код](src/ex04) | [Тест](test/Task-4) |
| [Завдання 3](#завдання-3---спадкування-020424)     | [Код](src/ex03) |          —          |
| [Завдання 2](#завдання-2---класи-та-обєкти-010424) | [Код](src/ex02) | [Тест](test/Task-2) |
| [Завдання 1](#завдання-1-290323)                   | [Код](src/ex01) |          —          |

## Завдання 3 - Спадкування (02.04.24)
Забезпечити розміщення результатів обчислень у колекції з можливістю збереження/відновлення. <br>

Використовуючи шаблон проектування Factory Method (Virtual Constructor), розробити ієрархію, що передбачає розширення рахунок додавання нових відображуваних класів.<br>

Розширити ієрархію інтерфейсом "фабрикованих" об'єктів, що представляє набір методів для відображення результатів обчислень.<br>

Реалізувати ці методи виведення результатів у текстовому виді.<br>

Розробити та реалізувати інтерфейс для "фабрикуючого" методу.<br>

Результат:

https://github.com/ieni-nei/OOP-Practice/assets/113203792/0cc35245-c4e1-4c48-a9ec-6acfae7b3155

`Main.java`:
```java
package src.ex03;

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
        View_Result view = new View_Result();

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
                        view.save("temp/Task-3/item.dat");
                        break;
                    case 5:
                        File file = new File("temp/Task-3/item.dat");
                        if (file.exists()) {
                            view.restore("temp/Task-3/item.dat");
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

```

`View_Result.java`:
```java
package src.ex03;

import src.ex02.Calculate;
import src.ex02.Item2d;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас для відображення результатів обчислень.
 * 
 * @author Головненко Леонід aka @ieni-nei
 */
public class View_Result implements View {
    private final List<Item2d> items = new ArrayList<>();

    /**
     * Виводить результат.
     */
    @Override
    public void show() {
        header();
        body();
        footer();
    }

    /**
     * Виводить заголовок.
     */
    public void header() {
        System.out.println("========Результати обчислень========");
    }

    /**
     * Виводить тіло.
     */
    public void body() {
        for (Item2d item : items) {
            System.out.println("Аргументи: " + item.getArguments());
            double average = item.getResult();
            System.out.println("Середнє арифметичне: " + average);
            System.out.println("Результат у двійковому форматі: " + Calculate.toBinaryString(average));
            System.out.println("Кількість одиниць у двійковому поданні цілої частини: " + Calculate.countOnes(average));
        }
    }

    /**
     * Виводить підвал.
     */
    public void footer() {
        System.out.println("===================================");
    }

    /**
     * Ініціалізує результати згенерованими значеннями.
     */
    @Override
    public void init() {
        items.clear();
        List<Double> arguments = Calculate.randomArguments();
        double average = Calculate.calculateAverage(arguments);
        items.add(new Item2d(arguments, average));
        System.out.println("Згенеровано 4 довільних аргументи");
    }

    /**
     * Ініціалізує результати зі стандартними значеннями.
     */
    @Override
    public void initDefault() {
        items.clear();
        double[] defaultArguments = {Math.PI / 6, Math.PI, 3 * Math.PI / 2, Math.PI / 2};
        List<Double> arguments = new ArrayList<>();
        for (double argument : defaultArguments) {
            arguments.add(Calculate.roundValue(argument, 2));
        }
        double average = Calculate.calculateAverage(arguments);
        items.add(new Item2d(arguments, average));
        System.out.println("Обрано 4 статичних аргументи");
    }


    /**
     * Зберігає результати у файл за вказаним шляхом.
     *
     * @param path Шлях до файлу.
     * @throws IOException Виникає, якщо виникає помилка при збереженні даних у файл.
     */
    @Override
    public void save(String path) throws IOException {
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOut.writeObject(items);
            System.out.println("Об'єкти збережено у файл " + path);
        }
    }

    /**
     * Відновлює раніше збережені результати з вказаного шляху.
     *
     * @param path Шлях до файлу збереження.
     * @throws IOException            Виникає, якщо виникає помилка при відновленні даних з файлу.
     * @throws ClassNotFoundException Виникає, якщо не вдається знайти клас під час відновлення даних з файлу.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void restore(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(path))) {
            items.clear();
            items.addAll((ArrayList<Item2d>) objectIn.readObject());
            System.out.println("Об'єкти відновлено з файлу " + path);
        }
    }
}

```

`View.java`:
```java
package src.ex03;

import java.io.IOException;

/**
 * Інтерфейс для відображення результатів обчислень.
 * 
 * @author Головненко Леонід aka @ieni-nei
 */
interface View {
    /**
     * Показує весь об'єкт.
     */
    void show();

    /**
     * Показує заголовок.
     */
    void header();

    /**
     * Показує основну частину.
     */
    void body();

    /**
     * Показує колонтитул.
     */
    void footer();

    /**
     * Виконує ініціалізацію.
     */
    void init();

    /**
     * Виконує ініціалізацію за замовчуванням.
     */
    void initDefault();

    /**
     * Зберігає дані у файл за вказаним шляхом.
     *
     * @param path Шлях до файлу.
     * @throws IOException Виникає, якщо виникає помилка при збереженні даних у файл.
     */
    void save(String path) throws IOException;

    /**
     * Відновлює раніше збережені дані з вказаного шляху.
     *
     * @param path Шлях до файлу збереження.
     * @throws Exception Виникає, якщо виникає помилка при відновленні даних з файлу.
     */
    void restore(String path) throws Exception;
}

```

[До початку](#практика-з-ооп)


https://github.com/ieni-nei/OOP-Practice/assets/113203792/ca28a50f-4ddb-48aa-9505-a63bc507c9b0


## Завдання 2 - Класи та об'єкти (01.04.24)
**Індивідуальне завдання №1:** </br>
Визначити кількість одиниць у двійковому поданні цілої частини середнього арифметичного значення функції 1000*sin(α) для чотирьох довільних аргументів. <br>
![](images/Task-2/Result.png)

Результат тестування:<br>
![](images/Task-2/Test_Result.png)

Розробити клас, що серіалізується, для зберігання параметрів і результатів обчислень.<br>
![](images/Task-2/Item2d.png)

Використовуючи агрегування, розробити клас для знаходження рішення задачі.<br>
![](images/Task-2/Calculate.png)

Розробити клас для демонстрації в діалоговому режимі збереження та відновлення стану об'єкта, використовуючи серіалізацію. Показати особливості використання transient полів.<br>
![](images/Task-2/Main.png)

Розробити клас для тестування коректності результатів обчислень та серіалізації/десеріалізації.<br>
![](images/Task-2/MainTest.png)

[До початку](#практика-з-ооп)

## Завдання 1 (29.03.23)
 Написати просту консольну програму (наприклад вивід на екран аргументів командної строки).<br>
![](images/Task-1/Task-1.png)
