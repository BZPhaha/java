package Java_Inter;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GetfromUrl {
	public static void main(String[] args){
		try {
			URL u = new URL("http://www.lolcats.com");
			InputStream in = u.openStream();
			int c;
			while((c = in.read()) != -1){
				System.out.println(c);
			}
			in.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
}
