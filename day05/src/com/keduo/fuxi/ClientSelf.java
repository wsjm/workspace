package com.keduo.fuxi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSelf {
public static void main(String[] args) throws Exception {
	//先创建客户端对象
	Socket socket=new Socket("192.168.102.1", 9090);
	//Socket socket=new Socket("192.168.102.1", 9090);
	//发送数据到服务器端
	OutputStream outputStream=socket.getOutputStream();
	PrintWriter printWriter=new PrintWriter(outputStream);
	printWriter.println("hello  服务器  ，你在干嘛啊!!");
	printWriter.flush();
	//接受服务器端的信息
	InputStream inputStream=socket.getInputStream();
	Reader reader=new InputStreamReader(inputStream);
	BufferedReader bufferedReader=new BufferedReader(reader);
	String s1= bufferedReader.readLine();
	System.out.println("服务器端的信息是:"+s1);
}
}
