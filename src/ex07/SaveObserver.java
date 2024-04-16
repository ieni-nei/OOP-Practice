package ex07;

import java.util.Objects;

/**
 * Серіалізує дані.
 */
public class SaveObserver implements Observer {
	// Оповіщяє спостерігача
	@Override
	public void notify(String type, String message) {
		if (Objects.equals(type, "серіалізація")) {
			System.out.println("SERIALIZE: " + message);
		}
	}
}
