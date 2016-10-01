package com.imooc.proxy.jdkimpl;
import java.lang.reflect.Method;
import com.imooc.proxy.jdkimpl.InvocationHandler;
public class $Proxy0 implements com.imooc.proxy.Movable{
	public $Proxy0(InvocationHandler h) {
		this.h = h;
	}
	private InvocationHandler h;
	@Override
	public void move() {
	try{
	Method md = com.imooc.proxy.Movable.class.getMethod("move");
		h.invoke(this, md);
	}catch(Exception e) {e.printStackTrace();}
 	}
}