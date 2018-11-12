package proxy;

public class Actor implements IActor {

	@Override
	public void basicAct(float money){
		System.out.println("1W只能基本表演"+money);
	}

	@Override
	public void DangerAct(float money){
		System.out.println("5w危险表演"+money);
	}
}