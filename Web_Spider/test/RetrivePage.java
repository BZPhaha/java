package test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;





public class RetrivePage {
	@SuppressWarnings("deprecation")
	private static HttpClient httpCilent = new HttpClient();
	static{
		//httpCilent.getHostConfiguration().setProxy("localhost", 8088);
		
	}
	public static boolean downloadPage(String path) throws HttpException,IOException{
		InputStream input = null;
		OutputStream output = null;
		//得到post方法
		PostMethod postMethod = new PostMethod(path);
		//设置post方法的参数
		NameValuePair[] postData = new NameValuePair[2];
		//postData[0] = new NameValuePair("username","783535094@qq.com");
		//postData[1] = new NameValuePair("password","bzp199433");
		//postMethod.addParameters(postData);
		//执行，返回状态码
		int statusCode = httpCilent.executeMethod(postMethod);
		if(statusCode == HttpStatus.SC_OK){
			input = postMethod.getResponseBodyAsStream();
			System.out.println("aaa"+input.available());
			//获得文件名
			String fileName = path.substring(path.lastIndexOf('/')+1);
			//获得文件输出流
			
			output = new FileOutputStream(fileName);
			//输出文件
			int tempByte = -1;
			while((tempByte = input.read()) > 0){
				output.write(tempByte);
			}
			//关闭输入输出流
			if(input != null){
				input.close();
			}
			if(output != null){
				output.close();
			}
			return true;
		}
		if((statusCode == HttpStatus.SC_MOVED_TEMPORARILY) || (statusCode == HttpStatus.SC_MOVED_PERMANENTLY) || (statusCode == HttpStatus.SC_SEE_OTHER) || (statusCode == HttpStatus.SC_TEMPORARY_REDIRECT)){
		//读取新的URL地址
			Header header = postMethod.getResponseHeader("location");
			if(header != null){
				String newUrl = header.getValue();
				if(newUrl == null || newUrl.equals("")){
					newUrl = "/";
					PostMethod redirect = new PostMethod();
				}
			}
			return true;
		}
		return false;
	}
	public static void main(String[] args){
		try{
			RetrivePage.downloadPage("http://www.ccsfu.edu.cn");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
