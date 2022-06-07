import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BounderBuffer {

	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	final Object[] items = new Object[100];

	int putptr, takeptr, count;

	public void put(Object x) { // Добавить
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();
			items[putptr] = x;
			if (putptr == items.length)
				putptr = 0;
			++count;
			notEmpty.signal();
			System.out.printf("Thread %s has put and signal data: %s\n", Thread.currentThread().getName(), x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public Object take() { // Забрать
		lock.lock();
		try {
			while (count == 0) {
				notEmpty.await();
				System.out.printf("Thread %s take waiting...\n", Thread.currentThread().getName());
			}
			System.out.printf("Thread %s is going to take data\n", Thread.currentThread().getName());

			Object x = items[takeptr];
			if (++takeptr == items.length)
				takeptr = 0;
			--count;
			notFull.signal();
			return x;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		} finally {
			lock.unlock();
		}
	}
}
