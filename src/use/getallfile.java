package use;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class getallfile {
	public static void main(String[] args) {
		File file = new File("E:\\root"); 
         System.out.println(print(file));
    }
    public static long print(File f){
    	long a=0;
        if(f!=null){
            if(f.isDirectory()){
                File[] fileArray=f.listFiles();
                if(fileArray!=null){
                    for (int i = 0; i < fileArray.length; i++) {
                        //递归调用
                        print(fileArray[i]);
                    }
                }
            }
            else{
            	if(f.length() > a){
            		a  = f.length();
            	}
                System.out.println(f+"aaaaaaa"+a);
            }
        }
        return a;
    }
}
