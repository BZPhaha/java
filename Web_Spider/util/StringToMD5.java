package util;

public class StringToMD5 {
	public static String getMD5(byte[] source){
		String s = null;
		//用来将字节转换为十六进制表示的字符
		char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(source);
			//md5计算结果是一个128位的长整数。
			byte tmp[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			for(int i = 0; i < 16;i++){
				byte byte0 = tmp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];//取字节中高4位的数字转换。
				str[k++] = hexDigits[byte0 & 0xf];
			}
			s = new String(str);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return s;
	}
}
