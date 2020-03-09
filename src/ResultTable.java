import java.util.HashMap;

/**
 * a class that creates a hashmap based on a size
 * that then expects keys from 0-size that correspond to integer values
 * @author Danny Clyde
 */
public class ResultTable {
    private volatile HashMap<Integer, Integer> _results;
    private int _size;

    public ResultTable(int size) {
        this._size = size;
        this._results = new HashMap<Integer, Integer>(size);
    }

    public synchronized void addResult(int key, int val) throws Exception {
        if (key > this._size || key < 0) {
            throw new Exception("Got a key not within size of result table");
        } else {
            this._results.put(key, val);
        }
    }

    public void printResults() {
        for (int i = 0; i < this._size; i++) {
            System.out.print(this._results.get(i));
        }
    }
}
