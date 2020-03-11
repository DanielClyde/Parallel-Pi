import java.util.ArrayList;
import java.util.Collections;

/**
 * Shared ArrayList that handles popping elements synchronously
 * @author Danny Clyde
 */
public class TaskQueue {
    private volatile ArrayList<Integer> _queue;
    private volatile int size = 0;

    public TaskQueue(int size) {
        this.size = size;
        this._queue = new ArrayList<Integer>(size);
        for (int i = 1; i <= size; i++) {
            this._queue.add(i);
        }
        Collections.shuffle(this._queue);
    }

    public synchronized int pop() {
        this.size--;
        return this._queue.remove(0);
    }

    public synchronized int getSize() {
        return this.size;
    }

    public void print() {
        for (Integer i : this._queue) {
            System.out.print(i);
        }
    }
}
