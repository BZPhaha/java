package TestCallback;

import java.io.IOException;
import java.net.URL;

import nu.xom.MalformedURIException;

public class ContentGetter {
	public static void main(String[] args){
		try {
			URL u = new URL("http://www.baidu.com");
			Object o = u.getContent();
			System.out.println("I got a " + o.getClass().getName());
		} catch (MalformedURIException e) {
			// TODO: handle exception
			System.err.println("this is not a url");
		}
		catch (IOException ex )
		{
			System.err.println(ex);
		}
	}
}
