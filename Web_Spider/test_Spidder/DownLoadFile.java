package test_Spidder;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * 下载网页，根据URL和网页类型生成需要保存的网页的文件名，去除URL中的非文件名字符
 * @author BZP
 *
 */
public class DownLoadFile {
	public String getFileNameByUrl(String url,String contentType){
		//移除http
		url = url.substring(7);
		System.out.println(url);
		//text/html
		if(contentType.indexOf("html") != -1){
			url = url.replaceAll("[\\?/:*|<>\"]", "_")+".html";
			return url;
		}
		//如application/pdf 类型
		else{
			return url.replaceAll("[\\?/:*|<>\"]", "_")+"."+contentType.substring(contentType.lastIndexOf("/")+1);
		}
	}
	/**
	 * 保存网页字节数组到本地文件，filePath为要保存的文件的相对地址
	 * @param data
	 * @param filepath
	 */
	private void saveToLocal(byte[] data, String filepath){
		try{
			DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(filepath)));
			for(int i = 0; i < data.length; i++){
				out.write(data[i]);
			}
			out.flush();
			out.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	//下载URL 指向的网页
	public String downloadFile(String url){
		String filePath = null;
		//1.生成HttpClient 对象并设置参数
		HttpClient httpClient = new HttpClient();
		//设置HTTP 连接超时5s
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		//2.生成GetMethod 对象并设置参数
		GetMethod getMethod = new GetMethod(url);
		//设置get请求超时5秒
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
		//设置请求重试处理 
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
		//3.执行 HTTP GET请求
		try{
			int statusCode = httpClient.executeMethod(getMethod);
			//判断访问的状态码
			if(statusCode != HttpStatus.SC_OK){
				System.err.println("Method failed: " + getMethod.getStatusLine());
				filePath = null;
			}
			//4.处理HTTP 响应内容
			byte[] responseBody = getMethod.getResponseBody();
			//根据网页URL 生成保存时的文件名
			filePath = "temp\\" + getFileNameByUrl(url,getMethod.getResponseHeader("Content-Type").getValue());
			saveToLocal(responseBody,filePath);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			getMethod.releaseConnection();
		}
		return filePath;
	}
}
