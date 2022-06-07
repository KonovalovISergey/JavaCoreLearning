
public class Program {

	public static void main(String[] args) throws InterruptedException {
		Thread t0 = new Thread(() -> {
			for (int i = 1; i <= 100; i++)
				System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);
		});

		Thread t1 = new Thread(() -> {
			try {
				t0.join();
				for (int i = 1; i <= 100; i++)
					System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		t0.start();
		t1.start();

		t1.join();

		System.out.println(Thread.currentThread().getName());

	}

}
