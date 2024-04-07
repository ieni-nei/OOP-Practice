package ex06;

import ex05.Command;

import java.util.LinkedList;
import java.util.Queue;

public class CommandQueue {

    private Queue<Command> tasks;
    private boolean waiting;
    private boolean shutdown;

    public void shutdown() {
        shutdown = true;
    }

    public CommandQueue() {
        tasks = new LinkedList<>();
        waiting = false;
        new Thread(new Worker()).start();
    }

    public void put(Command r) {
        tasks.add(r);
        if (waiting) {
            synchronized (this) {
                notifyAll();
            }
        }
    }

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
        return tasks.remove();
    }

    // Define isEmpty method to check if the queue is empty
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    private class Worker implements Runnable {

        @Override
        public void run() {
            while (!shutdown) {
                Command r = take();
                r.execute();
            }
        }
    }
}
