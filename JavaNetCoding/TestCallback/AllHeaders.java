package TestCallback;

import java.net.URL;
import java.net.URLConnection;

public class AllHeaders {
	public static void main(String[] args){
		try {
			URL u = new URL("http://www.baidu.com");
			URLConnection uc = u.openConnection();
			for(int j = 1;;j++){
				String header = uc.getHeaderField(j);
				if(header == null ){
					break  ;
				}
				System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
