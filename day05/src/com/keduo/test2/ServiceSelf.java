package com.keduo.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.*;

public class ServiceSelf {
public static void main(String[] args) throws Exception {
	//创建服务器对象
	ServerSocket serverSocket=new ServerSocket(9010);
	//接受客户端ip
	Socket s=serverSocket.accept();
	InetAddress ip= s.getInetAddress();
	System.out.println(ip);
	//获取客户端的数据
	InputStream in=s.getInputStream();
	Reader reader=new InputStreamReader(in);
	BufferedReader bufferedReader=new BufferedReader(reader);
	//System.out.println(bufferedReader);
	String s1=bufferedReader.readLine();
	System.out.println("客户端的信息:"+s1);
//反馈给客户端信息
	OutputStream outputStream=s.getOutputStream();
	PrintWriter printWriter=new PrintWriter(outputStream);
	printWriter.println("哈哈哈");
	printWriter.flush();
}
}
