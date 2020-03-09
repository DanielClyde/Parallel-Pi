import java.util.HashMap;

/**
 * a class that creates a hashmap based on a size
 * that then expects keys from 0-size that correspond to integer values
 * @author Danny Clyde
 */
public class ResultTable {
    private volatile HashMap<Integer, Integer> results;
    private int size;

    public ResultTable(int size) {
        this.size = size;
        this.results = new HashMap<Integer, Integer>(size);
    }

    public synchronized void addResult(int key, int val) throws Exception {
        if (key > this.size) {
            throw new Exception("Got a key larger than size of result table");
        } else {
            this.results.put(key, val);
        }
    }

    public void printResults() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.results.get(i));
        }
    }
}
