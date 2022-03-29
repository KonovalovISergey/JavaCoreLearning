import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

public class Program {

	public static boolean testString(String s) {
		System.out.printf("%s : ", s);
		Stack<Character> st = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '(' || ch == '[')
				st.push(ch);
			if(ch == ')' || ch == ']') {
				if (st.size() == 0) return false;
				char p = st.pop();
				if(!((p == '(' && ch == ')') || (p == '[' && ch == ']')))
					return false;
			}
		}
		
		return st.size() == 0;
	}

	public static void main(String[] args) {

		System.out.println(testString("([sdaf])adsfj()ksd[()as()](sdf)"));

		Map<String, Integer> persons = new Hashtable<String, Integer>();

		persons.put("Сергей", 23);
		persons.put("Саша", 24);
		persons.put("Филипп", 25);
		persons.put("Настя", 21);

		persons.put("Филипп", 22);

		System.out.println(persons.size());

		String name = "Филипп";
		if (persons.containsKey(name)) {
			int age = persons.get(name);
			System.out.printf("%s - %d\n", name, age);
		}
	}

}
