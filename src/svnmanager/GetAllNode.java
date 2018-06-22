package com.css.sword.svn.manager.service.svnVersion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

import com.css.sword.svn.manager.common.PlatformAESUtil;

public class GetAllNode {
    static List reuslttmp = new ArrayList();
    public static void main(String[] args) throws SVNException {
        //Map result = new GetAllNode().getNode("http://127.0.0.1/svn/qxgl");
       // List tmp =  new GetAllNode().getNodeOne("http://127.0.0.1/svn/bsvnOne","01","",1);
       //Map tmp = new GetAllNode().getNode("http://127.0.0.1/svn/bsvnOne");
       System.out.println("aaaaaaaa");
       //System.out.println("aaa");
    }
    
    public Map<String,List>  getNode(String ss) throws SVNException{
           SVNURL surl  = SVNURL.parseURIEncoded(ss);
           DAVRepositoryFactory.setup();
           SVNRepository repository = SVNRepositoryFactory.create(surl);
           ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager("admin", "admin".toCharArray());  
           repository.setAuthenticationManager(authManager);
           Map resultMap = new HashMap();
           itFile(repository,"",1,resultMap);
           System.out.println("啊啊啊啊");
           return resultMap;
       }
    public void itFile(SVNRepository repository,String url,int level,Map<String,List> allResult) throws SVNException{
        List result = new ArrayList();
           Collection a = repository.getDir(url, -1, null, (Collection)null);
           Iterator b = a.iterator();
           //List  tmp = new ArrayList();
           int pid = (level-1)*1000;
           int id = level*1000;
           while(b.hasNext()){
               Map tmp = new HashMap();
               SVNDirEntry c = (SVNDirEntry) b.next();
               if (c.getKind() == SVNNodeKind.DIR) {
                   System.out.println(c.getName());
                   System.out.println(c.getRevision());
                   System.out.println(c.getURL());
                   //result.add(c.getName());
                   tmp.put("caption", c.getName());
                   tmp.put("rpath", c.getURL());
                   tmp.put("level", level);
                   result.add(tmp);
                   tmp.put("pcode", pid++);
                   tmp.put("code", id++);
                   itFile(repository,c.getURL().toString().substring(29),level+1,allResult);
               }
           }
           if(allResult.get(level+"") != null){
               result.addAll(allResult.get(level+""));
               allResult.put(level+"", result);
           }else{
               allResult.put(level+"", result);
           }
       }
    
    public Map<String,List>  getTwoNode(String ss) throws SVNException{
        SVNURL surl  = SVNURL.parseURIEncoded(ss);
        DAVRepositoryFactory.setup();
        SVNRepository repository = SVNRepositoryFactory.create(surl);
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager("admin", "admin".toCharArray());  
        repository.setAuthenticationManager(authManager);
        Map resultMap = new HashMap();
        List  firstNode = itFileOneByOne(repository,"",1);
        if(firstNode != null && firstNode.size() > 0){
            resultMap.put("firstNode", firstNode);
            List twoNode = new ArrayList();
            for(int i = 0;i < firstNode.size();i++){
                Map tmp = (Map) firstNode.get(i);
                List  twonodetmp = itFileOneByOne(repository,tmp.get("path").toString().substring(ss.length()),2);
                if(twonodetmp != null && twonodetmp.size() > 0){
                    twoNode.addAll(twonodetmp);
                }
            }
            if(twoNode != null && twoNode.size() > 0){
                resultMap.put("twoNode", twoNode);
            }
        }
        //System.out.println("啊啊啊啊");
        return resultMap;
    }
    public List itFileOneByOne(SVNRepository repository,String url,int level) throws SVNException{
       List result = new ArrayList();
       Collection a = repository.getDir(url, -1, null, (Collection)null);
       Iterator b = a.iterator();
       //List  tmp = new ArrayList();
       int pid = (level-1)*1000;
       int id = level*1000;
       while(b.hasNext()){
           Map tmp = new HashMap();
           SVNDirEntry c = (SVNDirEntry) b.next();
           if (c.getKind() == SVNNodeKind.DIR) {
               System.out.println(c.getName());
               System.out.println(c.getRevision());
               String path = "";
               try{
                   System.out.println(java.net.URLDecoder.decode(c.getURL().toString(), "utf-8"));
                   path = java.net.URLDecoder.decode(c.getURL().toString(), "utf-8");
               }catch(Exception e){
                   e.printStackTrace();
               }
               //result.add(c.getName());
               tmp.put("Nname", c.getName());
               tmp.put("path", path);
               tmp.put("level", level);
               tmp.put("pid", pid++);
               tmp.put("id", id++);
               result.add(tmp);
           }
       }
    return result;
    }
    public List getNodeOne(String svndlzh,String svndlkl,String ss,String pcode,String ppath,int level,String ruuid) throws Exception{
        SVNURL surl  = SVNURL.parseURIEncoded(ss);
        DAVRepositoryFactory.setup();
        SVNRepository repository = SVNRepositoryFactory.create(surl);
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(svndlzh, PlatformAESUtil.decrypt(svndlkl).toCharArray());  
        repository.setAuthenticationManager(authManager); 
        List result = new ArrayList();
        Collection a = repository.getDir("", -1, null, (Collection)null);
        Iterator b = a.iterator();
        //List  tmp = new ArrayList();
        int id = level*1000;
        while(b.hasNext()){
            id++;
            Map tmp = new HashMap();
            SVNDirEntry c = (SVNDirEntry) b.next();
            if (c.getKind() == SVNNodeKind.DIR) {
                System.out.println(c.getName());
                //System.out.println(c.getRevision());
                String path = "";
                try{
                    System.out.println(java.net.URLDecoder.decode(c.getURL().toString(), "utf-8"));
                    path = java.net.URLDecoder.decode(c.getURL().toString(), "utf-8");
                }catch(Exception e){
                    e.printStackTrace();
                }
                //result.add(c.getName());
                tmp.put("caption", c.getName());
                tmp.put("repopath", c.getURL().toString());//);
                if(level == 1){
                    tmp.put("authPath", ppath+c.getName()+"]");
                }else{
                    tmp.put("authPath", ppath+"/"+c.getName()+"]");
                }
                tmp.put("ruuid", ruuid);
                tmp.put("code", id + "");
                tmp.put("pcode", pcode);
                tmp.put("level", level);
                result.add(tmp);
            }
        }
        return result;
    }
}
