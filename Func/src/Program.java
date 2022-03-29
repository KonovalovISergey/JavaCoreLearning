import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.out;

public class Program {

	public static void main(String[] args) {
		ArrayList<Person> persons = new ArrayList<Person>();

		persons.add(new Person("Сергей", 23));
		persons.add(new Person("Саша", 24));
		persons.add(new Person("Филипп", 22));
		persons.add(new Person("Настя", 21));

		// for (Person p : persons)
		// out.println(p);
		// persons.stream().forEach(out::println);
		
		//for (Person p : persons)
		//	if(p.age > 22)
		//		out.println(p);
		//persons.stream().filter(p->p.age>22).forEach(out::println);
		
		/*ArrayList<Person> result = new ArrayList<Person>();
		for (Person p : persons)
			if(p.age > 22)
				result.add(p);
		Collections.sort(result, (p1, p2)->p1.name.compareTo(p2.name));
		for (Person p : result)
			out.println(p);*/
		persons.parallelStream(). // stream.
			filter(p->p.age>22).
			sequential(). // Конец распараллелирования
			sorted((p1, p2)->p1.name.compareTo(p2.name)).
			map(p->p.name). // Обрабатываем вывод
			forEach(out::println);
	}

}
