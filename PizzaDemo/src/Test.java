
public class Test {

	public static void main(String[] args) {
		SimplePizzaFactory s = new SimplePizzaFactory();
		PizzaStore ps = new PizzaStore(s);
		String type = "clam";
		Pizza pi = ps.orderPizza(type);
		
	}
	
}
