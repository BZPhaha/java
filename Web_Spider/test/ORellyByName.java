package test;

import java.net.InetAddress;

public class ORellyByName {
	public static void main(String[] args)
	{
		try {
			InetAddress address = InetAddress.getByName("www.baidu.com");
			System.out.println(address);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
