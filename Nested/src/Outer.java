import java.util.Comparator; // вынос ссылок абстрактного класса

public class Outer {

	public static class Nested {

		void increment(Outer o) {
			o.data++;
		}
	}

	public class Inner {

		void increment() {
			data++;
		}
	}

	private int data;

	public Outer(int data) {
		super();
		this.data = data;
		// Nested n; работа внутри класса
	}

	public int getData() {
		return data;
	}

	Comparator<Integer> xc;
	
	public boolean isGreater(int x) {
		/*
		class MyComparator implements Comparator<Integer>{
			public int compare(Integer a, Integer b) {
				return a-b;
			}
		}
		
		Comparator<Integer> c = new MyComparator();
		//xc = c;
		 Дальше то же самое*/
		Comparator<Integer> c = new Comparator<Integer>(){
			public int compare(Integer a, Integer b) {
				return a-b;
			}
		};
		
		return c.compare(data, x) > 0;
	}

}
