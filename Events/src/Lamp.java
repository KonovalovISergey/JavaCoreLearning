
public class Lamp implements ElectricityListener{

	@Override
	public void electricity(Object sourse) {
		
		System.out.println("Лампа зажглась");
	}
	
}
