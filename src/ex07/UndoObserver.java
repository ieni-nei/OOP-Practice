package ex07;

import java.util.Objects;

/**
 * Виконує команду скасування.
 */
public class UndoObserver implements Observer {
	// Оповіщяє спостерігача
	@Override
	public void notify(String type, String message) {
		if (Objects.equals(type, "скасування")) {
			System.out.println("UNDO: " + message);
		}
	}
}
