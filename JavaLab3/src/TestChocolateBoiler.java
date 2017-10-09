
/**
 * 测试单例模式ChocolateBoiler类
 * @author Administrator
 *
 */

public class TestChocolateBoiler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChocolateBoiler cho = ChocolateBoiler.getuniqueInstance();
		cho.fill();
		cho.boil();
		cho.drain();
		cho.boil();
	}

}
