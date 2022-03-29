
enum Colors { 
	Red, Green, Blue;
	public static final Colors DEFAULT_COLOR = Colors.Blue;
	
	public String upperName() {
		return name().toUpperCase();
	}
}

public class Program {

	public static void main(String[] args) {
		
		Colors c1 = Colors.Red;
		System.out.println(c1.name());
		System.out.println(c1.upperName());
		System.out.println(c1.ordinal());
		
		Colors c2 = Colors.valueOf("Green");
		System.out.println(c2);
		
		for(Colors c : Colors.values())
			System.out.println(c);
	}

}
