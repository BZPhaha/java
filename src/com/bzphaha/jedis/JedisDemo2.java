package com.bzphaha.jedis;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;



public class JedisDemo2 {
	@Test
	/**
	 * Jedis的实例测试
	 */
	public void demo1(){
		//1.设置IP地址和端口
		Jedis jedis = new Jedis("192.168.126.128",6379);
		jedis.auth("bzp199433");
		//2.保存数据
		jedis.set("name", "bzphaha");
		//3.获取数据
		 String value=jedis.get("name");
		System.out.println(value);
		//4.释放 资源
		jedis.close();
	}
	@Test
	/**
	 * 连接池的配置对象
	 */
	public void demo2(){
		JedisPoolConfig config = new JedisPoolConfig();
		//设置最大连数
		config.setMaxTotal(30);
		//设置最大空闲连接数
		config.setMaxIdle(10);
		//获得连接池
		JedisPool jedisPool = new JedisPool(config,"192.168.126.128",6379);
		Jedis jedis = null;
		try{
			//通过连接池获得连接
			 jedis = jedisPool.getResource();
			 jedis.auth("bzp199433");
			 //设置数据
			 jedis.set("name", "张三");
			 //获取数据
			 String value = jedis.get("name");
			 System.out.println(value);
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			if(jedis != null){
				jedis.close();
			}
			if(jedisPool != null){
				jedisPool.close();
			}
		}
	}
}
