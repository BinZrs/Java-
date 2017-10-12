
public class SimplePizzaFactory {
	Pizza pi;
	public Pizza createPizza(String type){
		//Pizza pi; //不能这样写，局部变量等这个函数结束被回收，所以会报错。
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
