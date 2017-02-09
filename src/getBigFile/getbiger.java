package getBigFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 查找最大的文件
 * @author BZP
 *
 */

public class getbiger {
	private static ArrayList<String> filelist = new ArrayList<String>();
	 
	 public static void main(String[] args) throws Exception {
	    
	    String filePath = "E:\\java-study\\Java\\source\\root";
	    getFiles(filePath);
	 } 
	 /*
	  * 通过递归得到某一路径下所有的目录及其文件
	  */
	 static void  getFiles(String filePath){
	StringBuilder getbig = new StringBuilder();
	double getbiggg=new Double(0);
	  File root = new File(filePath);
	    File[] files = root.listFiles();
	    for(File file:files){     
	     if(file.isDirectory()){
	      /*
	       * 递归调用
	       */
	      getFiles(file.getAbsolutePath());
	      filelist.add(file.getAbsolutePath());
	      //System.out.println("显示"+filePath+"下所有子目录及其文件"+file.getAbsolutePath());
	     }else{
	    	 try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String lineTxt= new String();
				StringBuilder sss= new StringBuilder();
				while((lineTxt = br.readLine()) != null){
                    sss.append(lineTxt);
                    System.out.println("值为"+lineTxt+"路径为"+file.getAbsolutePath());
                    double aa=Double.parseDouble(lineTxt);
                    if(aa>getbiggg){
                    	getbiggg = aa;
                    }
                }
				//System.out.println("当前的长度为"+sss.toString().length()+"之前的长度为"+getbig.toString().length());
				int a=0;
				if(sss.toString().compareTo(getbig.toString()) > 1){
					getbig=new StringBuilder();
					getbig.append(sss);
					//System.out.println("最大的值为"+getbig.toString()+"路径为"+file.getAbsolutePath());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      //System.out.println("显示"+filePath+"下所有子目录"+file.getAbsolutePath());
	     }     
	    }
	    System.out.println("最大值为"+getbiggg);
	    //return getbig.toString();
	 }
	 
	 /**
	  * 
	  * 参考代码
	  */
	 /**
	  *  static void getFiles(String filePath){
  File root = new File(filePath);
    File[] files = root.listFiles();
    for(File file:files){     
     if(file.isDirectory()){
      /*
       * 递归调用
       */
	 /**
      getFiles(file.getAbsolutePath());
      filelist.add(file.getAbsolutePath());
      System.out.println("显示"+filePath+"下所有子目录及其文件"+file.getAbsolutePath());
     }else{
      System.out.println("显示"+filePath+"下所有子目录"+file.getAbsolutePath());
     }     
    }
	  */
	 
	 
}
