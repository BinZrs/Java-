
public class PizzaStore {
	private SimplePizzaFactory si;
	public PizzaStore(SimplePizzaFactory obj) {
		// TODO Auto-generated constructor stub
		si = obj;	
	}
	public Pizza orderPizza(String type){
		Pizza tmp =  si.createPizza(type);
		tmp.prepare();
		tmp.bake();
		tmp.cut();
		tmp.box();
		return tmp;
	}
}
