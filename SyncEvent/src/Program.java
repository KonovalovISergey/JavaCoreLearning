
public class Program {

	public static void main(String[] args) throws InterruptedException {

		class Sync {
			public int counter = 0;
		}
		
		Sync s = new Sync();
		
		//Object o = new Object();

		Thread t0 = new Thread(() -> {
			for (int i = 1; i <= 100; i++) {
				System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);
				if (i == 50) {
					synchronized (s) {
						//o.notify();
						s.counter = i;
						s.notify();
					}
				}
			}
		});

		Thread t1 = new Thread(() -> {
			try {
				synchronized (s) {
					while(s.counter < 50) {
						s.wait();
					}
					
					//o.wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int i = 1; i <= 100; i++)
				System.out.printf("%s : %d\n", Thread.currentThread().getName(), i);

		});
		
		t1.start();
		t0.start();
		//Thread.sleep(500);
		//t1.start();

	}

}
