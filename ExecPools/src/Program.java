import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Program {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		//ExecutorService pool = Executors.newSingleThreadExecutor();
		//ExecutorService pool = Executors.newFixedThreadPool(5);
		//ExecutorService pool = Executors.newCachedThreadPool();
		ExecutorService pool = Executors.newWorkStealingPool();
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		long t1 = System.currentTimeMillis();
		
		Future[] tasks = new Future[10];
		
		for(int i =0; i < 10; i++) 
			tasks[i] = pool.submit(new MyCallTask());
		
		for(Future t : tasks)
			System.out.println(t.get());

		long t2 = System.currentTimeMillis();
		
		System.out.println(t2-t1);
		
		pool.shutdown();
	}

}
