import java.io.IOException;

class MyThread extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++)
			System.out.printf("%s : %d\n", getName(), i);
	}
}

class MySuperTread implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++)
			System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);

	}

}

class CounterThread implements Runnable {

	private int a, b;

	public CounterThread(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {
		for (int i = a; i <= b; i++)
			System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);

	}

}

public class Program {

	public static void main(String args[]) {
		System.out.println(Thread.currentThread().getName());
		MyThread t0 = new MyThread();
		MyThread t1 = new MyThread();

		Thread t2 = new Thread(new MySuperTread());

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 100; i++)
					System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);

			}
		});

		Thread t4 = new Thread(() -> {
			for (int i = 1; i <= 100; i++)
				System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);

		});
		
		Thread t5 = new Thread( new CounterThread(150, 200) );
		
		int a = 250; // final
		int b = 270; // final
		
		Thread t6 = new Thread(() -> {
			for (int i = a; i <= b; i++)
				System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);

		});

		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
		System.out.println("Main - " + Thread.currentThread().getState());
		System.out.println("t6 - " + t6.getState());
		System.out.println("t1 - " + t1.getState());
	}

}
