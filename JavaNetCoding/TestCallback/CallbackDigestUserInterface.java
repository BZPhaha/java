package TestCallback;

import javax.xml.bind.DatatypeConverter;

public class CallbackDigestUserInterface {
	public static void receiveDigest(byte[] digest,String name){
		StringBuilder result = new StringBuilder(name);
		result.append(": ");
		result.append(DatatypeConverter.printHexBinary(digest));
		System.out.println("结果是"+result);
	}
	public static void main(String[] args){
		String[] filenames={"C:\\Users\\BZP\\Desktop\\111.txt"};
		for(String filename : filenames){
			CallbackDigest cb = new CallbackDigest(filename);
			Thread t = new Thread(cb);
			t.start();
		}
	}
}
