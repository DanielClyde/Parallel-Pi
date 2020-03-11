/**
 * Creates PiThreads based on the number of processors and has them calculate 1000
 * digits of pi in concurrently
 * @author Danny Clyde
 */
public class Assign4 {
	public static void main(String[] args) throws InterruptedException {
		final int NUM_DIGITS = 1000;
		ResultTable results = new ResultTable(NUM_DIGITS);
		TaskQueue queue = new TaskQueue(NUM_DIGITS);

		int availableProcessors = Runtime.getRuntime().availableProcessors();
		PiThread[] threads = new PiThread[availableProcessors];
		long start = System.currentTimeMillis();
		for (int i = 0; i < availableProcessors; i++) {
			threads[i] = new PiThread(results, queue);
			threads[i].start();
		}

		for (PiThread t : threads) {
			t.join();
		}

		long time = System.currentTimeMillis() - start;
		results.printResults();
		System.out.printf("Pi computation took %d ms\n", time);
	}
}