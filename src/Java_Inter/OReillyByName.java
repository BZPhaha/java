package Java_Inter;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class OReillyByName {
	public static void main(String[] args){
		try {
			InetAddress address = InetAddress.getByName("www.baidu.com");
			System.out.println(address);
		} catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace(); 
		}
	}
}
