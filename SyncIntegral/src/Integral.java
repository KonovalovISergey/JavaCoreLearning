import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.function.DoubleFunction;

public class Integral {

	public static final int STEPS = 10000000;
	public static final int TASKS = 10;

	public static double singleThread(DoubleFunction<Double> f, double a, double b) {
		return singleThread(f, a, b, STEPS);
	}

	static double singleThread(DoubleFunction<Double> f, double a, double b, int steps) {
		double h = (b - a) / steps;
		double summa = 0d;

		for (int i = 0; i < steps; i++) {
			double x = a + h * i + h / 2;
			double y = f.apply(x);
			summa += y * h;
		}
		return summa;
	}

	public static double multiThread(DoubleFunction<Double> f, double a, double b)
			throws InterruptedException, ExecutionException {

		// ExecutorService pool = Executors.newFixedThreadPool(TASKS);
		ExecutorService pool = Executors.newWorkStealingPool();

		double hx = (b - a) / TASKS;
		Future<Double>[] tasks = new Future[TASKS];
		for (int i = 0; i < TASKS; i++) {
			final double ax = a + i * hx;
			final double bx = ax + hx;
			tasks[i] = pool.submit(() -> Integral.singleThread(f, ax, bx, STEPS / TASKS));
		}

		double summa = 0d;
		for (Future<Double> t : tasks) {
			summa += t.get();
		}
		pool.shutdown();

		return summa;
	}

	public static double multiThread2(DoubleFunction<Double> f, double a, double b) throws InterruptedException {
		double hx = (b - a) / TASKS;
		Thread[] threads = new Thread[TASKS];
		final DoubleAdder r = new DoubleAdder();
		for (int i = 0; i < TASKS; i++) {
			final double ax = a + i * hx;
			final double bx = ax + hx;
			threads[i] = new Thread(() -> {
				double rx = Integral.singleThread(f, ax, bx, STEPS / TASKS);
				r.add(rx);
			});
			threads[i].start();
		}
		for (Thread t : threads)
			t.join();

		return r.sum();

	}

	public static double multiThread3(DoubleFunction<Double> f, double a, double b) {

		class Pair {
			double a;
			double b;

			public Pair(double a, double b) {
				this.a = a;
				this.b = b;
			}
		}
		double h = (b - a) / TASKS;
		List<Pair> ts = new ArrayList<Pair>();
		for (int i = 0; i < TASKS; i++)
			ts.add(new Pair(a + i * h, a + (i + 1) * h));

		// ForkJoinPool.commonPool();
		return ts.parallelStream().mapToDouble(p -> singleThread(f, p.a, p.b, STEPS / TASKS)).sum();
	}

}
