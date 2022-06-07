import java.util.concurrent.ExecutionException;

public class Program {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Integral.singleThread(Math::sin, 0d, Math.PI/2);
		Integral.singleThread(Math::sin, 0d, Math.PI/2);
		
		long t1 = System.currentTimeMillis();

		double r1 = Integral.singleThread(Math::sin, 0d, Math.PI/2);
		
		long t2 = System.currentTimeMillis();
		
		System.out.printf("Single thread: %f Time %d\n", r1, t2-t1);
		
		Integral.multiThread(Math::sin, 0d, Math.PI/2);
		Integral.multiThread(Math::sin, 0d, Math.PI/2);
		
		long t3 = System.currentTimeMillis();

		double r2 = Integral.multiThread(Math::sin, 0d, Math.PI/2);
		
		long t4 = System.currentTimeMillis();
		
		System.out.printf("Multi thread: %f Time %d\n", r2, t4-t3);
		
		
		Integral.multiThread2(Math::sin, 0d, Math.PI/2);
		Integral.multiThread2(Math::sin, 0d, Math.PI/2);
		
		long t5 = System.currentTimeMillis();

		double r3 = Integral.multiThread2(Math::sin, 0d, Math.PI/2);
		
		long t6 = System.currentTimeMillis();
		
		System.out.printf("Multi thread2: %f Time %d\n", r3, t6-t5);
		
		
		Integral.multiThread3(Math::sin, 0d, Math.PI/2);
		Integral.multiThread3(Math::sin, 0d, Math.PI/2);
		
		long t7 = System.currentTimeMillis();

		double r4 = Integral.multiThread2(Math::sin, 0d, Math.PI/2);
		
		long t8 = System.currentTimeMillis();
		
		System.out.printf("Multi3 thread2: %f Time %d\n", r4, t8-t7);
		
	}

}
