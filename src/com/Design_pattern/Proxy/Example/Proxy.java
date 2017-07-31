package com.Design_pattern.Proxy.Example;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;

public class Proxy {
	public static Object newProxyInstance( Class inface,InvocationHandler handler) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		String rt = "\r\n";
		
		String methodStr = "";
		for(Method m : inface.getMethods()){
			methodStr += "@Override" +rt+
			"	public void " +m.getName()+"() {" +rt+
			"try{"+rt+
			"Method md = "+inface.getName() + ".class.getMethod(\""+m.getName()+"\");"+rt+
			"handler.invoke(this,md);"+rt+
			"}catch(Exception e){"+rt+
			" e.printStackTrace();}"+rt+
			"	} " ;
		}
		String str = "package com.Design_pattern.Proxy.Example;" +rt+
		"import java.lang.reflect.Method;"+rt+
		"import com.Design_pattern.Proxy.Example.InvocationHandler;"+rt+
		"	 /** " +rt+
		"	 * 通过聚合进行代理 " +rt+
		"	 * @author BZP " +rt+
		"	 * " +rt+
		"	 */ " +rt+
		" public class $Proxy0 implements "+ inface.getName()+" { " +rt+
			"private InvocationHandler handler;" +rt+
		"	public $Proxy0(InvocationHandler handler) {" +rt+
		"		super();" +rt+
		"		this.handler = handler;" +rt+
		"	}" +rt+
			methodStr+rt+
		"}";
	String filename = System.getProperty("user.dir")+"/bin/com/Design_pattern/Proxy/Example/$Proxy0.java";
	File file = new File(filename);
	FileUtils.writeStringToFile(file, str);
	//System.out.println(filename);
	//编译
	//拿到编译器
	JavaCompiler complier = ToolProvider.getSystemJavaCompiler();
	StandardJavaFileManager fileMgr = complier.getStandardFileManager(null, null, null);
	//
	Iterable units = fileMgr.getJavaFileObjects(filename);
	//编译任务
	CompilationTask t = complier.getTask(null, fileMgr, null, null, null, units);
	t.call();
	fileMgr.close();
	//load到内存中
	ClassLoader cl = ClassLoader.getSystemClassLoader();
	Class c = cl.loadClass("com.Design_pattern.Proxy.Example.$Proxy0");
	
	Constructor ctr = c.getConstructor(InvocationHandler.class);
	return ctr.newInstance(handler);
	
	}
}
