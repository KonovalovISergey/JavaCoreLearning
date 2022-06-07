import java.util.concurrent.Callable;

public class MyCallTask implements Callable<Long>{

	@Override
	public Long call() throws Exception {
		
		System.out.println(Thread.currentThread().getName());
		
		long summa = 0;
		for(long i = 1; i <= 100000000L; i++) 
			summa+= i;
		
		return summa;
	}
	
}
