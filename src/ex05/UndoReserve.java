package ex05;

import ex02.Item2d;
import ex03.View;
import ex03.View_Result;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Виконує функціонал консольної команди Undo.
 */
public class UndoReserve {

    private static final String LAST_FILE = "temp/Task-5/item.dat";
    private static final String BACKUP_FILE = "temp/Task-5/item_backup.dat";

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
        ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(LAST_FILE));
        objectOut.writeObject(items);
        objectOut.flush();
        objectOut.close();
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
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(LAST_FILE));
            items = (ArrayList<Item2d>) objectIn.readObject();
            objectIn.close();

            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(BACKUP_FILE));
            objectOut.writeObject(items);
            objectOut.flush();
            objectOut.close();
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
            ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(BACKUP_FILE));
            items = (ArrayList<Item2d>) objectIn.readObject();
            objectIn.close();
        } else {
            System.out.println("Файл резервної копії відсутній.");
        }
    }
}
