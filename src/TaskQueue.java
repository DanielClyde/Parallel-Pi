import javafx.concurrent.Task;

import java.util.LinkedList;

public class TaskQueue {
    private volatile LinkedList<Integer> _queue;

    public TaskQueue() {
        this._queue = new LinkedList<Integer>();
    }

    public void push(int digit) {
        this._queue.addLast(digit);
    }

    public synchronized int pop() {
        return this._queue.pop();
    }

    public int getSize() {
        return this._queue.size();
    }
}
