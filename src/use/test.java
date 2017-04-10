package use;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String filePath = "E:\\java-study\\Java\\src\\use\\newone.txt";
		readTxtByScanner(filePath);*/
		
	}
	/*public static void readTxtFile(String filePath){
		double all=0;
		HashMap mapa= new HashMap();
        try {
                String encoding="GBK";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader  bufferedReader= new BufferedReader(new FileReader(file),5*1024*1024);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	String[] getint = lineTxt.split(" ");
                    	String getoneint = getint[1];
                    	//int a = Integer.parseInt(getoneint);
                    	//all+=a;
                    	mapa.put(getint[1],1);
                        System.out.println(lineTxt);
                    }
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        System.out.println(mapa.size());
     
    }*/
	/*public static void readTxtByScanner(String fileName) {
        FileInputStream fileInputStream = null; 
        Scanner scanner = null;
        
        try {
            fileInputStream = new FileInputStream(fileName);
            scanner = new Scanner(fileInputStream, "UTF-8");
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (scanner != null) {
                scanner.close();
            }
        }
        
    }*/

	 
	   

}
