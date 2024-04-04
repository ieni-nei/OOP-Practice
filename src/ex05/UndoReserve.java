package src.ex05;

import src.ex02.Item2d;
import src.ex03.View;
import src.ex03.View_Result;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Виконує функціонал консольної команди Undo.
 */
public class UndoReserve {

    private static final String LAST_FILE = "temp/Task-5/last.dat";
    private static final String BACKUP_FILE = "temp/Task-5/back.dat";

    private List<Item2d> items;
    private View view;

    public UndoReserve(View view) {
        this.view = view;
    }

    /**
     * Записує поточний стан об'єктів до файлу.
     *
     * @throws IOException Виникає, якщо сталася помилка вводу/виводу.
     * @throws Exception   Виникає, якщо сталася помилка.
     */
    public void write() throws IOException, Exception {
        items = ((View_Result) view).getItems();
        reWrite();
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(LAST_FILE));
        os.writeObject(items);
        os.flush();
        os.close();
    }

    /**
     * Перезаписує дані з резервного файлу до основного.
     *
     * @throws Exception Виникає, якщо сталася помилка.
     */
    @SuppressWarnings("unchecked")
    public void reWrite() throws Exception {
        items = ((View_Result) view).getItems();
        if (new File(LAST_FILE).exists()) {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(LAST_FILE));
            items = (ArrayList<Item2d>) is.readObject();
            is.close();

            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(BACKUP_FILE));
            os.writeObject(items);
            os.flush();
            os.close();
        }
    }

    /**
     * Відновлює дані з резервного файлу.
     *
     * @throws Exception Виникає, якщо сталася помилка.
     */
    @SuppressWarnings("unchecked")
    public void undo() throws Exception {
        if (new File(BACKUP_FILE).exists()) {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(BACKUP_FILE));
            items = (ArrayList<Item2d>) is.readObject();
            is.close();
        } else {
            System.out.println("Файл резервної копії відсутній.");
        }
    }
}
