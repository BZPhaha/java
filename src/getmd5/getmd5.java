package getmd5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class getmd5 {
	
	public static String getMd5(String plainText) {  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(plainText.getBytes());  
            byte b[] = md.digest();  
  
            int i;  
  
            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < b.length; offset++) {  
                i = b[offset];  
                if (i < 0)  
                    i += 256;  
                if (i < 16)  
                    buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            //32位加密  
            return buf.toString();  
            // 16位的加密  
            //return buf.toString().substring(8, 24);  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
            return null;  
        }  
    } 
	public static void main(String args[]){
		StringBuilder ss = new StringBuilder();
		ss.append("20170209bzphaha1");
		for(int i = 1001; i < 1000000000;i++){
			ss.append(i);
			String getmd = getMd5(ss.toString());
			//System.out.println("前6位为"+getmd.substring(0, 6));
			if(getmd.substring(0, 6).equals("000000")){
				System.out.println("当前值为"+getmd);
			}
		}
		//System.out.println(getMd5("bzp"));
	}
}
