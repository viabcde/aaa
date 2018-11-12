package proxyExtend;
import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
public class Client {
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		final Actor actor =new Actor();
		Actor proxyActor = (Actor)Enhancer.create(actor.getClass(), 
					new MethodInterceptor() {						
						@Override
						public Object intercept(Object proxy, Method method, Object[] args,
								MethodProxy methodproxy) throws Throwable {
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