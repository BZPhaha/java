package com.css.sword.svn.manager.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

/**
*利用jsch.jar进行远程服务器的文件上传与下载，以及命令的执行
*/
public class SSHUtil { 
     
    private ChannelSftp channelSftp; 
     
    private ChannelExec channelExec; 
     
    private Session session = null; 
     
    private int timeout = 60000; 
     
    private static final Logger LOG = Logger.getLogger(SSHUtil.class); 
    /*public static void main(String[] args) { 
        SshConfiguration conf = new SshConfiguration(); 
        conf.setHost("192.168.201.129"); 
        conf.setUsername("bzp"); 
        //conf.setPublicKeyPath("C:/Users/BZP/Desktop/gitlab/bzpce");
        conf.setPassword("bzp199433");
        conf.setPort(22); 
        try { 
            SSHUtil sshUitl = new SSHUtil(conf); 
            sshUitl.upload("C:/Users/BZP/Desktop/gitlab/testgit/svn-sql.txt", "/home/bzp/Documents/"); 
           // sshUitl.download("/home/test.txt", "testData/test.txt"); 
          //  sshUitl.runCmd("java -version", "UTF-8"); 
            sshUitl.close(); 
            System.out.println("上传成功");
        } catch (Exception e) { 
            e.printStackTrace(); 
       } 
    }*/
     
    public SSHUtil(SshConfiguration conf) throws Exception 
    { 
        //免密登录----尚未成功
        /*LOG.info("尝试连接到....host:" + conf.getHost() + ",username:" + conf.getUsername() + ",port:" + conf.getPort()); 
        JSch jsch = new JSch();
        String pubKeyPath = conf.getPublicKeyPath();//"C:\\Users\\yutao\\.ssh\\id_rsa";
        jsch.addIdentity(pubKeyPath);
        String username = conf.getUsername() ;//"yutao";
        String host = conf.getHost(); //"192.168.116.131";
        Session session=jsch.getSession(username, host, 22);//为了连接做准备
        session.setConfig("StrictHostKeyChecking", "no");
        session.setTimeout(timeout);
        session.connect();*/
        
        
        
        //密码登陆
        LOG.info("尝试连接到....host:" + conf.getHost() + ",username:" + conf.getUsername() + ",password:" + conf.getPassword() + ",port:" + conf.getPort()); 
        JSch jsch = new JSch(); // 创建JSch对象  
        session = jsch.getSession(conf.getUsername(), conf.getHost(), conf.getPort()); // 根据用户名，主机ip，端口获取一个Session对象  
        session.setPassword(conf.getPassword()); // 设置密码  
        Properties config = new Properties(); 
        config.put("StrictHostKeyChecking", "no"); 
        session.setConfig(config); // 为Session对象设置properties  
        session.setTimeout(timeout); // 设置timeout时间  
        session.connect(); // 通过Session建立链接  
    }
    /**
     * 下载文件
     * @param src 服务器路径
     * @param dst 本地路径
     * @throws Exception
     */
    public void download(String src, String dst) throws Exception 
    { 
        channelSftp = (ChannelSftp)session.openChannel("sftp"); 
        channelSftp.connect(); 
        channelSftp.get(src, dst);
        //channelSftp.get(src, dst, new FileProgressMonitor(), ChannelSftp.OVERWRITE); 
        channelSftp.quit();
    }
    /**
     * 上传文件
     * @param src  本地路径
     * @param dst  服务器文件路径
     * @throws Exception
     */
    public void  upload(String src, String dst) throws Exception 
    { 
        channelSftp = (ChannelSftp)session.openChannel("sftp"); 
        channelSftp.connect(); 
        channelSftp.put(src, dst);
        //channelSftp.put(src, dst, new FileProgressMonitor(), ChannelSftp.OVERWRITE); 
        channelSftp.quit(); 
    }
    /**
     * 上传文件
     * @param src  本地路径
     * @param dst  服务器文件路径
     * @throws Exception
     */
    public void  upload(InputStream src, String dst) throws Exception 
    { 
        channelSftp = (ChannelSftp)session.openChannel("sftp"); 
        channelSftp.connect(); 
        channelSftp.put(src, dst);
        //channelSftp.put(src, dst, new FileProgressMonitor(), ChannelSftp.OVERWRITE); 
        channelSftp.quit(); 
    }
     
    public String runCmd(String cmd, String charset) throws Exception 
    { 
        channelExec = (ChannelExec)session.openChannel("exec"); 
        channelExec.setCommand(cmd); 
        channelExec.setInputStream(null); 
        channelExec.setErrStream(System.err); 
        channelExec.connect(); 
        //InputStream in = channelExec.getInputStream(); 
        InputStream in = channelExec.getErrStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, Charset.forName(charset))); 
        String buf = null; 
        StringBuilder sresult = new StringBuilder();
        while ((buf = reader.readLine()) != null) 
        { 
            sresult.append(buf);
            //System.out.println(buf); 
        } 
        reader.close(); 
        channelExec.disconnect(); 
        return sresult.toString();
    } 
     
    public void close() 
    { 
        session.disconnect(); 
    } 
} 