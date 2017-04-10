package getInfoFromImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Readword {
	public static void main(String[] args){
		//File f = new File("C://Users//BZP//Desktop//aaaa//d0og0.png");
		getImageGRB("C://Users//BZP//Desktop//aaaa//d0og0.png");
	}
	public void getInfo(String filePath){
		/*byte[] bbb =  new byte[10240];
		try {
				InputStream a = new FileInputStream(f);
				a.read(bbb);
				//System.out.println(bbb[0]);
				for (int i = 0; i < bbb.length; i++) {
					System.out.println(Integer.toBinaryString(bbb[i]));	
				}
				
			}*/
		File f = new File("C://Users//BZP//Desktop//aaaa//d0og0.png");
		FileInputStream fis;  
        try  
        {  
            fis = new FileInputStream(f);  
            byte[] b;  
            b = new byte[fis.available()];  
            StringBuilder str = new StringBuilder();// 不建议用String  
            fis.read(b);  
            for (byte bs : b)  
            {  
            	System.out.println(Integer.toBinaryString(bs));
                str.append(Integer.toBinaryString(bs));// 转换为二进制  
            }  
            System.out.println("二进制为"+str);  
            File apple = new File("C://Users//BZP//Desktop//cccc//1.png");// 把字节数组的图片写到另一个地方  
            FileOutputStream fos = new FileOutputStream(apple);  
            fos.write(b);  
            fos.flush();  
            fos.close();  
        }
		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		/*BufferedImage bi;      
        try {      
            bi = ImageIO.read(f);     
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "png", baos);  //经测试转换的图片是格式这里就什么格式，否则会失真  
            byte[] bytes = baos.toByteArray();
            for (int i = 0; i < bytes.length; i++) {
            	System.out.print(bytes[i]);
			}
            //  bi.getData();
            //ByteArrayOutputStream baos = new ByteArrayOutputStream();      
            //System.out.println("二进制位"+bi.getType());
        } catch (IOException e) {      
            e.printStackTrace();      
        } */
	}
	
	
	public static int[][] getImageGRB(String filePath) {
        File file  = new File(filePath);
        int[][] result = null;
        if (!file.exists()) {
             return result;
        }
        try {
             BufferedImage bufImg = ImageIO.read(file);
             int height = bufImg.getHeight();
             int width = bufImg.getWidth();
             result = new int[width][height];
             System.out.println("长"+width+"宽"+height);
             for (int i = 0; i < width; i++) {
                  for (int j = 0; j < height; j++) {
                	  	//bufImg.get
                        result[i][j] = bufImg.getRGB(i, j) & 0xFFFFFF;
                        System.out.println(bufImg.getRGB(i, j) & 0xFFFFFF); 
                  }
             }
             
        } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
        }
        
        return result;
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
