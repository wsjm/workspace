package com.keduo.test2;

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
		
//创建客户端对象
		Socket socket=new Socket("192.168.102.1", 9010);
		
		//2：发送到服务器,获取输出流+3：发送数据
		//System.out.println(socket.isClosed()+"**********");
		OutputStream outputStream=socket.getOutputStream();
		PrintWriter printWriter=new PrintWriter(outputStream);
		printWriter.println("Hello Server");
		printWriter.flush();
		//接受服务器端的信息
		InputStream inputStream=socket.getInputStream();
		Reader reader=new InputStreamReader(inputStream);
		BufferedReader bufferedReader=new BufferedReader(reader);
		String s1= bufferedReader.readLine();
		System.out.println("服务器端的信息:"+s1);
	}
	
}
