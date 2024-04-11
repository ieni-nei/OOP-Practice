package ex06;

import ex05.Command;

import java.util.Vector;

/**
 * Клас, що реалізує чергу команд.
 */
public class CommandQueue implements Queue {

    private final Vector<Command> tasks;
    private boolean waiting;
    private boolean shutdown = true;

    /**
     * Закриває чергу команд.
     */
    public void shutdown() {
        this.shutdown = true;
    }

    /**
     * Конструктор класу CommandQueue.
     */
    public CommandQueue() {
        tasks = new Vector<Command>();
        waiting = false;
        new Thread(new Worker()).start();
    }

    @Override
    public void put(Command command) {
        tasks.add(command);
        if (waiting) {
            synchronized (this) {
                notifyAll();
            }
        }
    }

    @Override
    public Command take() {
        if (tasks.isEmpty()) {
            synchronized (this) {
                waiting = true;
                try {
                    wait();
                } catch (InterruptedException ie) {
                    waiting = false;
                }
            }
        }
        return (Command) tasks.remove(0);
    }

    private class Worker implements Runnable {

        @Override
        public void run() {
            while (!shutdown) {
                Command command = take();
                try {
                    command.execute();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
