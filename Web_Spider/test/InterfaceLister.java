package test;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class InterfaceLister {

	public static void main(String[] args) throws SocketException{
		// TODO Auto-generated method stub
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while(interfaces.hasMoreElements()){
			NetworkInterface ni = interfaces.nextElement();
			System.out.println(ni);
		}
		NetworkInterface eth0 = NetworkInterface.getByName("lo");
		Enumeration address = eth0.getInetAddresses();
		while(address.hasMoreElements()){
			System.out.println("aaa"+address.nextElement());
		}
	}

}
