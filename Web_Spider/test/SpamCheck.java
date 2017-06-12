package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 判断是否是垃圾邮件
 * @author BZP
 *
 */
public class SpamCheck {
	public static final String BLACKHOLE = "sbl.spamhaus.org";
	
	public static void main(String[] args) throws UnknownHostException{
		if(isSpammer("220.181.111.188")){
			System.out.println("是垃圾邮件");
		}
		else{
			System.out.println("不是垃圾邮件");
		}
	}
	private static boolean isSpammer(String arg){
		try {
			InetAddress address = InetAddress.getByName(arg);
			byte[] quad = address.getAddress();
			String query = BLACKHOLE;
			for(byte octet : quad){
				int unsignedByte = octet < 0 ? (octet + 256) : octet;
				query = unsignedByte + "." + query;
			}
			
			System.out.println(query);
			InetAddress.getByName(query);
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}
	
}
