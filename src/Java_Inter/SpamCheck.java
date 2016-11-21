package Java_Inter;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SpamCheck {
	public static final String BLACKHOLE = "sbl.spamhaus.org";
	public static void main(String[] args) throws UnknownHostException{
		String[] args1 = {"127.0.0.1","207.34.56.23"};
		for(String arg : args1){
			if(isSpammer(arg)){
				System.out.println(arg + "is a kown spammer");
			}
			else{
				System.out.println(arg + "appears legitimate");
			}
		}
	}
	private static boolean isSpammer(String arg){
		try {
			InetAddress address = InetAddress.getByName(arg);
			byte[] quad = address.getAddress();
			String query = BLACKHOLE;
			for(byte octet : quad){
				int unsignedByte = octet < 0 ? octet + 256 : octet;
				query = unsignedByte + "." + query;
			}
			InetAddress.getByName(query);
			return true;
		} catch (UnknownHostException e) {
			// TODO: handle exception
			return false;
		}
	}
}
