package com.imooc.proxy.jdkimpl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

import com.imooc.proxy.Car;

/*
 * 模拟JDK动态代理的功能
 * 动态代理实现思路：
 * 1. 声明一段源码（动态产生代理）
 * 至于视频中演示动态代理的产生（生成java文件、编译class、load到内存）是为了更好的让大家理解产生代理的过程。当然你也可以用开元框架ASM、Javassist等 动态的在内存中创建等同.class的字节码，根据相应的字节码转换为class，然后再创建实例。
 * 2. 编译源码（JDK Compiler API)，产生新的类（代理类）
 * 3. 将这个类load到内存当中，产生一个新的对象（代理对象）
 * 4. return代理对象
 */
public class Proxy {
	
	public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception {
		
		//1. 声明一段源码（动态产生代理）。就是一段源码的字符串		
		String rt ="\r\n";
		String methodStr="";
		//1.2 动态获取代理目标方法，拼接到源码中（静态时为move()）
		for (Method m: infce.getMethods()) {
		methodStr += 
				"	@Override" + rt +
				"	public void " + m.getName()+ "() {" + rt +
				"	try{" + rt +
				"	Method md = " + infce.getName() + ".class.getMethod(\""
								+ m.getName() + "\");" + rt +
				"		h.invoke(this, md);" + rt +						
				"	}catch(Exception e) {e.printStackTrace();}" + rt +
				" 	}";
		}
		
		//1.1 动态传入代理目标类infce, 拼接到源码中（静态时为Movable）
		String str = 				
		"package com.imooc.proxy.jdkimpl;" + rt +
		"import java.lang.reflect.Method;" + rt +
		"import com.imooc.proxy.jdkimpl.InvocationHandler;"  + rt +
		"public class $Proxy0 implements "+ infce.getName() + "{" + rt +
		"	public $Proxy0(InvocationHandler h) {" + rt +
		"		this.h = h;" + rt +
		"	}" + rt +
		"	private InvocationHandler h;" + rt +
		methodStr + rt +
		"}";
		
		//2. 编译源码（JDK Compiler API)，产生新的类（代理类）
		//2.1 先生成一个Java类源码
		String filename = System.getProperty("user.dir")+"\\bin\\com\\imooc\\proxy\\jdkimpl\\$Proxy0.java";
		System.out.println(filename);
		File file = new File(filename);
		FileUtils.writeStringToFile(file, str);
		
		//2.2 拿到编译器
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		//文件管理器
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		//获取文件
		Iterable units = fileMgr.getJavaFileObjects(filename);
		//编译任务
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		//进行编译
		t.call();
		fileMgr.close();
		
		//3 load class到内存
		ClassLoader cl =  ClassLoader.getSystemClassLoader();
		Class clazz = cl.loadClass("com.imooc.proxy.jdkimpl.$Proxy0");
		
		Constructor ctr =clazz.getConstructor(InvocationHandler.class);
		return ctr.newInstance(h);
	}

}
