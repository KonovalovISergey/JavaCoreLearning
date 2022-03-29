
public class Program {

	public static void main(String[] args) {

		try (DBConnection db = new DBConnection();
				DBConnection db1 = new DBConnection()) {
			db.execute();
			db1.execute();
		} // db.close
		/*DBConnection db = new DBConnection();
		try {
			db.execute();
		} 
		finally {
			db.close();
		}*/
		// System.gc();

	}

}
