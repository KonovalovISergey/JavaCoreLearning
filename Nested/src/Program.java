
public class Program {

	public static void main(String[] args) {

		Outer.Nested n = new Outer.Nested(); // ������ � ��������� ������� � ���������
		
		Outer o = new Outer(10);
		
		Outer.Inner i = o.new Inner();
		
		//n.increment(o);
		i.increment();
		
		System.out.println(o.getData());
		
		Invoice inv = new Invoice("����&������");
		//inv.new Line("����", 10, 100);
		inv.addLine("����", 10, 100);
		//Invoice.Line l2 = inv.new Line("������", 20, 40);
		Invoice.Line l2 = inv.addLine("������", 20, 40);
		l2.setPrice(30);
		System.out.println(inv);
		
	}

}
