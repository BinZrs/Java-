
public class SimplePizzaFactory {
	Pizza pi;
	public Pizza createPizza(String type){
		//Pizza pi; //��������д���ֲ�����������������������գ����Իᱨ��
		if(type == "cheese"){
			 pi = new CheesePizza();
		}
		else if(type == "pepperoni"){
			 pi = new PepperoniPizza();
		}
		else if(type == "clam"){
			 pi = new ClamPizza();	
		}
		 return pi;
	}
}
