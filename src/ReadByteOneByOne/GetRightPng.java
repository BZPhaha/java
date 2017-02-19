package ReadByteOneByOne;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class GetRightPng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path =  "C:\\Users\\BZP\\Desktop\\反向\\rf.data";
		InputStream fin;
		try {
			fin = new FileInputStream(new File(path));
			//getContentFromInputStream(fin);
			getall(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void getall(InputStream fis){
		//BufferedInputStream bfs = new BufferedInputStream(fis);
		byte[] buffer1 = new byte[1];
        byte[] buffer2 = new byte[4];
		try {
			int ch = fis.read(buffer1);
			if(ch != -1){
				if(buffer1[0] ==0){
					ch = fis.read(buffer2);
					if(ch != -1){
						int size = ByteUtil.byte2int(buffer2);
						byte[] buffer3 = new byte[size];
						ch = fis.read(buffer3);
						if(ch != -1){
							byte2image(buffer3,"C:\\Users\\BZP\\Desktop\\反向\\"+ System.currentTimeMillis()+".png");	
							getall(fis);
						}
					}
				}
				else if(buffer1[0] == -1){
					ch = fis.read(buffer2);
	                if (ch != -1) {
	                    int size = ByteUtil.byte2int(buffer2);
	                    fis.skip(size);
	                    System.out.println("有删除");
	                    getall(fis);
	                }
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void getContentFromInputStream(InputStream fis) {
	    try {
	        byte[] buffer1 = new byte[1];
	        byte[] buffer2 = new byte[4];

	        // 1.1字节的标记位。0代表接下来的照片仍然可用，1代表接下来的照片已经被删除，2代表该物理文件接下来已经没有图片了。
	        //
	        //
	        // 2.4字节的size。标记照片的大小x。
	        //
	        //
	        // 3.x字节，照片文件本身。

	        // 先读取第一个字节
	        int ch = fis.read(buffer1);
	        if (ch != -1) {
	        	System.out.println("读取"+buffer1[0]);
	            // 如果照片可用
	            if (buffer1[0] == 0) {
	                // 读取4字节长度
	                ch = fis.read(buffer2);
	                if (ch != -1) {
	                    int size = ByteUtil.byte2int(buffer2);
	                    byte[] buffer3 = new byte[size];
	                    ch = fis.read(buffer3);
	                    if (ch != -1) {
	                        //FileManagerUtil.writeContentToFile("e:\\pict\\", System.currentTimeMillis() + ".jpg", buffer3);
	                    	System.out.println("执行代码");
	                        byte2image(buffer3,"C:\\Users\\BZP\\Desktop\\反向\\"+ System.currentTimeMillis()+".png");
	                        System.out.println("继续走");
	                       
	                        getContentFromInputStream(fis);
	                    }
	                }
	            }
	            // 被删除了
	            else if (buffer1[0] == 1) {
	                // 读取4字节长度
	                ch = fis.read(buffer2);
	                if (ch != -1) {
	                    int size = ByteUtil.byte2int(buffer2);
	                    fis.skip(size);
	                    System.out.println("有删除");
	                    getContentFromInputStream(fis);
	                }
	            }
	            // 到头了
	            else if (buffer1[0] == 2) {
	            	System.out.println("没有图片了");
	            }
	        }
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	    finally {
	        try {
	            if (fis != null) {
	                fis.close();
	            }
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }

	    }
	}
	public static void byte2image(byte[] data,String path){
	    if(data.length<3||path.equals("")) return;//判断输入的byte是否为空
	    try{
	    //FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));//打开输入流
	   // imageOutput.write(data, 0, data.length);//将byte写入硬盘
	    //imageOutput.close();
	    
	    OutputStream aa= new FileOutputStream(new File(path));
	    aa.write(data);
	    aa.close();
	    System.out.println("Make Picture success,Please find image in " + path);
	    } catch(Exception ex) {
	      System.out.println("Exception: " + ex);
	      ex.printStackTrace();
	    }
	  }
}
