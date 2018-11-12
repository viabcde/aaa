package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		final IActor actor =new Actor();
		IActor proxyActor = (IActor)Proxy.newProxyInstance(actor.getClass().getClassLoader(), actor.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
					    Object ReturnValue = null;
						Float money=(Float) args[0];
						if("basicAct".equals(method.getName())){
							if(money>10000){
								ReturnValue = method.invoke(actor, money/2);
							}
						}
						if("DangerAct".equals(method.getName())){
							if(money>50000){
								ReturnValue = method.invoke(actor, money/3);
							}
						}
						return ReturnValue;
					}
				});
		proxyActor.basicAct(20000);
		proxyActor.DangerAct(60000);
		
	}

}
