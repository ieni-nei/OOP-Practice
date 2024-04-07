package ex06;

import ex05.Command;

public interface Queue {
    void put(Command command);
    Command take() throws InterruptedException;
}
