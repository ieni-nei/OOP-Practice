package ex07;

/**
 * Інтерфейс об'єкта який буде спостерігати.
 * Реалізацію шаблону Observer.
 */
public interface Observer {
	/**
	 * Оновлює спостерігача
	 */
	void notify(String type, String message);
}
