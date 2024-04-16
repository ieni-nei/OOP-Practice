package ex07;

import ex04.View_Table;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Спостерігаємоий клас на основі View_Table.
 * Реалізацію шаблону Observer.
 */
public class ObservableViewTable extends View_Table implements Observable {
    private final ArrayList<Observer> observers = new ArrayList<>();

    /**
     * Додає спостерігача
     */
    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    /**
     * Оповіщає всіх спостерігачів
     */
    @Override
    public void notify(String type, String message) {
        for (Observer observer : observers) {
            observer.notify(type, message);
        }
    }

    // Відправляє повідомлення про генерацію випадкових даних
    @Override
    public void init() {
        notify(
                "генерація",
                "Викликана випадкова генерація даних."
        );

        super.init();
    }

    // Відправляє повідомлення про генерацію статичних даних
    @Override
    public void initDefault() {
        notify(
                "генерація",
                "Викликана статична генерація даних."
        );

        super.initDefault();
    }

    // Відправляє повідомлення про серіалізацію
    @Override
    public void save(String path) throws IOException {
        notify("серіалізація", "Викликана серіалізація");
        super.save(path);
    }

    // Відправляє повідомлення про десеріалізацію
    @Override
    public void restore(String path) throws IOException, ClassNotFoundException {
        notify("десеріалізація", "Викликана десеріалізація");
        super.restore(path);
    }
}
