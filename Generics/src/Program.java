
public class Program {

	public static <T extends Comparable<? super T>> boolean isGreater(T a, T b) {
		return a.compareTo(b) > 0;
	}

	public static void main(String[] args) {
		
		System.out.println(isGreater(10, 7));
		System.out.println(isGreater(10.5, .3));
		System.out.println(isGreater("abc", "def"));
		
		ReadonlyStorage r0 = new ReadonlyStorage(10);

		ReadonlyStorage<Integer> r1 = new ReadonlyStorage<>(10);

		ReadonlyStorage<Double> r2 = new ReadonlyStorage<Double>(2.5);
		ReadonlyStorage<?> r3 = new ReadonlyStorage<String>("abc");
		// ReadonlyStorage<Program> r4 = new ReadonlyStorage<Program>(new Program());

		System.out.println(2 * r1.getData());
		System.out.println(r2.getData());
		System.out.println(r3.getData());
		// System.out.println(r4.getData());
	}

}
