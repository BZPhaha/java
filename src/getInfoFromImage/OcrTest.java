package getInfoFromImage;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sourceforge.tess4j.Tesseract;

public class OcrTest {

 public static void getResult(int start,int end) {
	 
	 	//boolean isWord=str.matches("[a-zA-Z]+");
	 	//map.values().contains(Object)
       // String path = "C://Users//BZP//Desktop//yiyiyi.jpg";
	 Map<String, Integer> result =  new HashMap<String, Integer>();
        System.out.println("ORC Test Begin......");
        try {    
        	//Pattern p = Pattern.compile("^[A-Za-z]+$");
        	for(int j = start;j<end;j++){
        		//String filepath = "C://Users//BZP//Desktop//cap1//im"+j+".png";
        		int counut  = 0;
        		for(int i=0;i<36;i++)
            	{
            		//new test().testRotate(filepath,j,i,10*(i+1));
            		String path = "C://Users//BZP//Desktop//aaaa//d"+j+"og"+i+".png";  
            		File getfile = new File(path);
            		if(getfile.exists() && getfile.length() != 0) {  
            			String valCode = (new OCR().recognizeText(new File(path), "jpg")).trim();
            			//Matcher m = p.matcher(valCode);
            			//boolean isValid = m.matches();
            			if(valCode != null && !valCode.equals("")){
            				if(isLetter(valCode) && valCode.length() > 4){
            					if(!(result.keySet().contains(valCode))){
                        			result.put(valCode, 1);
                        		}
                        		else
                        		{
                        			if(counut > 20)
                        			result.put(valCode, 2);
                        		}
                        		System.out.println("结果为"+valCode);
            				}
                		}   
            			}
            		counut++;
            	}
        	}   
        	//File aa= new File("C://Users//BZP//Desktop//bzphaha.txt");
        	FileWriter fw = new FileWriter("C://Users//BZP//Desktop//bzphaha.txt", true);
        	//String line = System.getProperty("line.separator");
        	StringBuffer str = new StringBuffer();
        	Set set = result.entrySet();
        	Iterator iter = set.iterator();
        	while(iter.hasNext()){
        	Map.Entry entry = (Map.Entry)iter.next();
        	//System.out.println("长度为"+Integer.parseInt(entry.getValue().toString()));
        	if((Integer.parseInt(entry.getValue().toString())) > 1)
        		str.append((entry.getKey().toString()).trim()+" : "+entry.getValue()+"\r\n");
        	}
        	fw.write(str.toString());
        	fw.close();
        } catch (IOException e) {     
            e.printStackTrace();     
        } catch (Exception e) {  
            e.printStackTrace();  
        }       
        System.out.println("ORC Test End......");
    }  
	/* String tessPath = "C:\\Program Files (x86)\\Tesseract-OCR"; 
	 //loadDLL(tessPath);
	 loadDLL("liblept168.dll");
	 loadDLL("libtesseract302.dll");
	 String path = "C://Users//BZP//Desktop//im0.png";
	 File imageFile=new File(path);
	 if(!imageFile.exists()){
	System.out.println("图片不存在");
	 }
	// @SuppressWarnings("deprecation")
	Tesseract instance=new Tesseract();
	 instance.setDatapath("C:\\ProgramFiles(x86)\\Tesseract-OCR\\tessdata");//设置训练库的位置
	 instance.setLanguage("chi_sim");//中文识别
	 try {
		String result=instance.doOCR(imageFile);
		System.out.println("查看的结果为"+result);
	} catch (TesseractException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
 
 public static boolean isLetter(String str)
	{ 
	          java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[a-z]+"); 
	          java.util.regex.Matcher m = pattern.matcher(str);
	          return m.matches();     
	 }
 
 public static void loadDLL(String libFullName) {  
     try {  
         String nativeTempDir = System.getProperty("java.io.tmpdir");  
         InputStream in = null;  
         FileOutputStream writer = null;  
         BufferedInputStream reader = null;  
         File extractedLibFile = new File(nativeTempDir + File.separator + libFullName);  
         if (!extractedLibFile.exists()) {  
             try {  
                 in = Tesseract.class.getResourceAsStream("/" + libFullName);  
                 Tesseract.class.getResource(libFullName);  
                 reader = new BufferedInputStream(in);  
                 writer = new FileOutputStream(extractedLibFile);  
                 byte[] buffer = new byte[1024];  
                 while (reader.read(buffer) > 0) {  
                     writer.write(buffer);  
                     buffer = new byte[1024];  
                 }  
                 in.close();  
                 writer.close();  
                 System.load(extractedLibFile.toString());  
             } catch (IOException e) {  
                 e.printStackTrace();  
             } finally {  
                 if (in != null) {  
                     in.close();  
                 }  
                 if (writer != null) {  
                     writer.close();  
                 }  
             }  
         } else {  
             System.load(extractedLibFile.toString());  
         }  
     } catch (IOException e) {  
         //logger.error("初始化 " + libFullName + " DLL错误", e);  
    	 System.out.println("初始化 " + libFullName + " DLL错误");
    	 e.printStackTrace();
     }  
}

}