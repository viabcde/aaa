package proxy;

public class Actor implements IActor {

	@Override
	public void basicAct(float money){
		System.out.println("1Wֻ�ܻ�������"+money);
	}

	@Override
	public void DangerAct(float money){
		System.out.println("5wΣ�ձ���"+money);
	}
}