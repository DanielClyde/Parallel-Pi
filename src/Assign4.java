import java.util.ArrayList;
import java.util.Collections;

public class Assign4 {
	public static void main(String[] args) {
		final int NUM_DIGITS = 1000;
		ResultTable results = new ResultTable(NUM_DIGITS);
		TaskQueue queue = new TaskQueue();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= NUM_DIGITS; i++) {
			list.add(i);
		}
		Collections.shuffle(list);

		for (int i : list) {
			queue.push(i);
		}

		// create threads, pass in taskQueue and resultTable
		System.out.println("Hello World!");
	}
}