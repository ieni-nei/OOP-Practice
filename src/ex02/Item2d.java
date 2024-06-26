package ex02;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Клас, що серіалізується, представляє параметри та результати обчислень.
 * 
 * @author @ieni-nei
 */
public class Item2d implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private List<Double> arguments;
    private double result;

    /**
     * Конструктор для створення екземпляра класу з параметрами.
     *
     * @param arguments Аргументи функції.
     * @param result    Результат обчислення.
     */
    public Item2d(List<Double> arguments, double result) {
        this.arguments = new ArrayList<>(arguments);
        this.result = result;
    }

    /**
     * Конструктор для створення екземпляра класу зі списку аргументів та розрахунком результату.
     *
     * @param arguments Список аргументів функції.
     */
    public Item2d(List<Double> arguments) {
        this.arguments = arguments;
        this.result = Calculate.calculateAverage(arguments);
    }

    /**
     * Конструктор для створення екземпляра класу з масиву аргументів та розрахунком результату.
     *
     * @param arguments Масив аргументів функції.
     */
    public Item2d(double[] arguments) {
        this.arguments = new ArrayList<>();
        for (double arg : arguments) {
            this.arguments.add(arg);
        }
        this.result = Calculate.calculateAverage(this.arguments);
    }

    /**
     * Повертає аргументи функції.
     *
     * @return Список аргументів функції.
     */
    public List<Double> getArguments() {
        return new ArrayList<>(arguments);
    }

    /**
     * Встановлює новий список аргументів функції.
     *
     * @param arguments Новий список аргументів функції.
     */
    public void setArguments(List<Double> arguments) {
        this.arguments = arguments;
        this.result = Calculate.calculateAverage(arguments);
    }

    /**
     * Повертає результат обчислення.
     *
     * @return Результат обчислення.
     */
    public double getResult() {
        return result;
    }

    /**
     * Встановлює новий результат обчислення.
     *
     * @param result Новий результат обчислення.
     */
    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Item2d other = (Item2d) obj;
        return Arrays.equals(arguments.toArray(), other.arguments.toArray()) &&
               Double.compare(result, other.result) == 0;
    }
}
