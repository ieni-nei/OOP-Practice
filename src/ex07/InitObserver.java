package ex07;

import java.util.Objects;

/**
 * Виконує розрахунки при натисненні на відповідну кнопку.
 */
public class InitObserver implements Observer {
	// Оповіщяє спостерігача
	@Override
	public void notify(String type, String message) {
		if (Objects.equals(type, "генерація")) {
			System.out.println("INIT: " + message);
		}
	}
}
