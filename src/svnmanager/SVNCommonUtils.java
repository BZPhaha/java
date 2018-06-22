package com.css.sword.svn.manager.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class SVNCommonUtils implements PZCS{
	 static SwordLogUtils logger = SwordLogUtils.getLogger(SVNCommonUtils.class);
    private static final CacheUtils<Object> sshDatasCache = new CacheUtils< Object>(
            500, true);


    public static boolean isEmpty(Object obj) {
        boolean isEmpty = true;
        if (obj != null)
        {
            isEmpty = false;
            if (obj instanceof List)
            {
                isEmpty = ((List) obj).size() == 0;
            } else if (obj instanceof Map)
            {
                isEmpty = ((Map) obj).size() == 0;
            } else if (obj instanceof String)
            {
                isEmpty = ("".equals(obj) || "null".equals(obj) || "".equals(((String) obj).trim()));
            }
        }

        return isEmpty;
    }
    
    /**
     * 生成本地文件并将本地文件copy到远端服务器
     * @param userAuthInfo   写入文件的内容
     * @param pzcsMap 配置文件   currentyhdlzh--当前登录用户账号  filename--文件名 hostip--服务器IP 
     * yhdlzh--服务器登录账号  yhdlkl-- 服务器登录密码 serverfilepath--服务器文件路径（带文件名：/home/svn/csvn/data/conf/svn_auth_file）
     * @throws Exception
     */
    public static void copyFileToServer(String userAuthInfo,Map pzcsMap){
        
            try{
                File file;
                FileOutputStream fos = null;
                String suuid = (String)pzcsMap.get("suuid");
                String rootPath = getRootPath();

                //String path = SwordFileUtils.getTempFileDir();
                //String path1 = SwordFileUtils.getSwordRootPath();
                if(rootPath!=null && rootPath.length() > 0){
                    File fileDir = new File(rootPath+"/tmp");    
                    //如果不存在 则创建
                    if (!fileDir.exists()) {
                        fileDir.mkdirs();    
                    }
                    String fileName = (String)pzcsMap.get("filename")+SwordSequenceUtils.generateRandomString();
                    file = new File(rootPath+"/tmp/",fileName);
                    //如果存在，就删除 
                    if(file.exists()) 
                    {
                        file.delete();
                    }
                    file.createNewFile();
                    fos = new FileOutputStream(file, true);
                    fos.write(userAuthInfo.getBytes());
                    fos.flush();
                SSHUtil sshUtil = getSSH(pzcsMap);
                if(sshUtil != null){
                    sshUtil.upload(rootPath+"/tmp/"+fileName, (String)pzcsMap.get("serverfilepath")); 
                    //sshUitl.close();
                }
                if (fos != null) {
                    fos.close();
                }
                if(file.exists()) 
                {
                    file.delete();
                }
               }
            }catch(Exception e){
                e.printStackTrace();
            }
            
    }
    public static String getRootPath() throws SwordBaseCheckedException{
    	 String rootPath = null;
         String path = SwordFileUtils.getSwordRootPath();
         int lastNum = path.lastIndexOf("WEB-INF");
         if (lastNum != -1) {
             rootPath = path.substring(0, lastNum - 1);
         } else if (path.lastIndexOf("APP-INF") != -1) {
             rootPath = path.substring(0, path.lastIndexOf("APP-INF") - 1);
         } else {
             rootPath = path;
         }
         return rootPath;
    }
    //执行远程命令  如创建版本库    备份版本库和导入版本库
    public static String runcommd(String commd,Map pzcsMap) {
        try{
            String result = null;
            SSHUtil sshUtil = getSSH(pzcsMap);
            result = sshUtil.runCmd(commd, "utf-8");
            return result;
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
       }
    //将本地文件copy到远程服务器
    public static String copyFileToServers(Map pzcsMap){
        try {
            SSHUtil sshUtil = getSSH(pzcsMap);
            String result = null;
            String filePath = (String) pzcsMap.get("filePath");
           // String rootPath = getRootPath();
            sshUtil.upload(filePath, (String)pzcsMap.get("serverfilepath"));
            return result;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return e.getMessage();
        }
       
    }
  //将本地文件copy到远程服务器
    public static String copyFileToServers(InputStream st,Map pzcsMap){
        try {
            SSHUtil sshUtil = getSSH(pzcsMap);
            String result = null;
            sshUtil.upload(st, (String)pzcsMap.get("serverfilepath"));
            return result;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return e.getMessage();
        }
    }
    /**
     * 从svn服务器上下载文件到代码服务器
     * @param pzcsMap 配置文件   currentyhdlzh--当前登录用户账号  filename--文件名 hostip--服务器IP 
     * yhdlzh--服务器登录账号  yhdlkl-- 服务器登录密码 serverfilepath--服务器文件路径（带文件名：/home/svn/csvn/data/conf/svn_auth_file）
     * @throws Exception
     */
    public static void downFileFromServer(Map pzcsMap) {
        try{
            File file;
            FileOutputStream fos = null;
            String rootPath = getRootPath();

            //String path = SwordFileUtils.getTempFileDir();
            //String path1 = SwordFileUtils.getSwordRootPath();
            if(rootPath!=null && rootPath.length() > 0){
                File fileDir = new File(rootPath+"/dumps");    
                //如果不存在 则创建
                if (!fileDir.exists()) {    
                    fileDir.mkdirs();    
                }
                String filePath = (String) pzcsMap.get("filepath");
                SSHUtil sshUtil = getSSH(pzcsMap);
                if(sshUtil != null){
                    sshUtil.download((String)pzcsMap.get("serverfilepath"),filePath);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 连接ssh
     * @param pzcsMap
     * @return
     * @throws Exception
     */
    public static SSHUtil getSSH(Map<String, String> pzcsMap) {
        String suuid = (String)pzcsMap.get("suuid");
        Object sshtmp = sshDatasCache.get(suuid, 300000);
        SSHUtil sshUtil;
        if( sshtmp != null){
            sshUtil = (SSHUtil) sshtmp;
        }else{
          //连接远程服务器
            try{
                SshConfiguration conf = new SshConfiguration(); 
                conf.setHost((String)pzcsMap.get("hostip"));
                conf.setUsername((String)pzcsMap.get("yhdlzh")); 
                conf.setPassword(PlatformAESUtil.decrypt((String)pzcsMap.get("yhdlkl")));
                conf.setPort(22); 
                sshUtil = new SSHUtil(conf); 
                sshDatasCache.put(suuid, sshUtil);
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }
        return sshUtil;
    }
    /**通过删除文件夹的方式
     * 删除文件夹以及下面的所有文件
     * */
    public static void delFolder(String folderPath) {  
	     try { 
	    	logger.debug("开始删除文件夹:",folderPath); 
	        delAllFile(folderPath); //删除完里面所有内容  
	        String filePath = folderPath;  
	        filePath = filePath.toString();  
	        java.io.File myFilePath = new java.io.File(filePath);  
	        myFilePath.delete(); //删除空文件夹  
	     } catch (Exception e) {  
	       logger.debug("删除文件夹：",folderPath,"出错",e.getMessage());
	     }  
	}
	//删除所有文件
    public static boolean delAllFile(String path) {  
      boolean flag = false;  
      File file = new File(path);  
      if (!file.exists()) {  
        return flag;  
      }  
      if (!file.isDirectory()) {  
        return flag;  
      }  
      String[] tempList = file.list();  
      File temp = null;  
      for (int i = 0; i < tempList.length; i++) {  
         if (path.endsWith(File.separator)) {  
            temp = new File(path + tempList[i]);  
         } else {  
             temp = new File(path + File.separator + tempList[i]);  
         }  
         if (temp.isFile()) { 
       	 logger.debug("开始删除文件:",path); 
            temp.delete();  
         }  
         if (temp.isDirectory()) {  
            delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件  
            delFolder(path + "/" + tempList[i]);//再删除空文件夹  
            flag = true;  
         }
      }  
      return flag;  
    }
}
