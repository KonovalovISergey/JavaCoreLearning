import java.io.Closeable;

public class DBConnection implements Closeable {

	public DBConnection() {
		System.out.println("Open connection...");
	}
	public void execute() {
		System.out.println("execute command...");
	}
	
	private boolean isClosed = false;
	@Override
	public void close() {
		if (!isClosed) {
			System.out.println("close connection");
			isClosed = true;
		}	
	}
	
	/*@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("close connection");
	}*/
	
}
