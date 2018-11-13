package com.keduo.fuxi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceSelf {
public static void main(String[] args) throws Exception {
	//先创建服务器对象
	ServerSocket serverSocket=new ServerSocket(9090);
	//接受客户端数据(ip)
	Socket socket=serverSocket.accept();
	InetAddress ip= socket.getInetAddress();
	System.out.println(ip);
	InputStream inputStream=socket.getInputStream();
	Reader reader=new InputStreamReader(inputStream);
	BufferedReader bufferedReader=new BufferedReader(reader);
	String s1=bufferedReader.readLine();
	System.out.println("客户端发出的信息是:"+s1);
	
	//反馈客户端信息
	OutputStream outputStream=socket.getOutputStream();
	PrintWriter printWriter=new PrintWriter(outputStream);
	printWriter.println("你好！！我是你的服务器...");
	printWriter.flush();
	
}
}
