package ex07;

import ex02.Item2d;
import ex02.Calculate;
import ex05.History;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;

/**
 * Реалізує шаблон Observer.
 */
public class App extends JFrame {
    private static final History history = History.getInstance();
    private final ObservableViewTable view = new ObservableViewTable();

    private JPanel panel;
    private JTable table;
    private JLabel label;
    private JButton initButton;
    private JButton defaultButton;
    private JButton saveButton;
    private JButton restoreButton;
    private JButton undoButton;

    public App() {
        initializeUI();
        initializeListeners();
        registerObservers();
    }

    private void initializeUI() {
        setContentPane(panel);
        setSize(800, 300);
        setVisible(true);

        createTable();
    }

    private void initializeListeners() {
        initButton.addActionListener(e -> {
            history.add(view.getItems());
            view.init();
            label.setText("Генерація даних...");
            updateTable();
        });

        defaultButton.addActionListener(e -> {
            history.add(view.getItems());
            view.initDefault();
            label.setText("Застосування статичних даних...");
            updateTable();
        });

        saveButton.addActionListener(e -> {
            try {
                view.save("temp/Task-7/item.dat");
                label.setText("Збереження даних...");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            updateTable();
        });

        restoreButton.addActionListener(e -> {
            try {
                view.restore("temp/Task-7/item.dat");
                label.setText("Відновлення даних...");
            } catch (IOException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            updateTable();
        });

        undoButton.addActionListener(e -> {
            History.undo(view);
            label.setText("Скасування операції...");
            updateTable();
        });
    }

    private void registerObservers() {
        view.register(new SaveObserver());
        view.register(new InitObserver());
        view.register(new UndoObserver());
    }

    /** Створює пусту таблицю при запуску програми */
    private void createTable() {
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Аргументи", "Середнє арифметичне", "Двійкове", "К-ть одиниць"}
        ));
    }

    /**
     * Оновлює дані в таблиці
     */
    public void updateTable() {
        Object[][] values = new Object[view.getItems().size()][4];

        for (int i = 0; i < values.length; i++) {
            Item2d items = view.getItems().get(i);
            values[i][0] = items.getArguments();
            values[i][1] = items.getResult();
            values[i][2] = Calculate.toBinaryString(items.getResult());
            values[i][3] = Calculate.countOnes(items.getResult());
        }

        table.setModel(new DefaultTableModel(values,
                new String[]{"Аргументи", "Середнє арифметичне", "Двійкове", "К-ть одиниць"}));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}
