/**
 * 
 */
/**
 * @author BZP
 *
 *jdk动态代理实现
 *自己实现动态代理
 *思路
 *1.声明一段源码（动态产生代理）；
 *2.编译源码（JDK Compiler API ），产生新的类（代理类）
 *3.将这个类load到内存中，产生一个新得对象（代理对象）
 *4.return 代理对象
 */
package com.Design_pattern.Proxy.JkdProxy;