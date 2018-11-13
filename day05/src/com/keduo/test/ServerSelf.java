package com.keduo.test;
import java.net.*;
import java.io.*;
public class ServerSelf {

	public static void main(String[] args) throws Exception{
		//1: 创建服务器对象
		
			ServerSocket ss=new ServerSocket(9010);
			while(true){
//			2： 接收客户端（ip）
			Socket c=ss.accept();
			InetAddress ip=c.getInetAddress();
			System.out.println(ip);
//			3：获取客户端的数据
			InputStream in=c.getInputStream();
			Reader r=new InputStreamReader(in);
			BufferedReader br=new BufferedReader(r);
			System.out.println(br);
			String s=br.readLine();
			System.out.println(s);
			System.out.println("客户端的信息："+s);
//			4：可以给客户端反馈信息
			System.out.println(c.isClosed()+"&&&&&&&&&&&&&");
			OutputStream out=c.getOutputStream();
			PrintWriter pw=new PrintWriter(out);
			pw.write("hello,I am  Server");
			pw.flush();
			pw.close();
	
			//1:创建客户端对象
			Socket socket=new Socket("192.168.4.242",9010);
			//2：发送到服务器,获取输出流+3：发送数据
			System.out.println(socket.isClosed()+"**********");
			OutputStream outputStream=socket.getOutputStream();
			PrintWriter printWriter=new PrintWriter(out);
			pw.write("Hello Server");
			pw.flush();
			pw.close();
//			3：接口服务器给我反馈数据
			InputStream inputStream=socket.getInputStream();
			Reader reader=new InputStreamReader(in);
			BufferedReader bufferedReader=new BufferedReader(r);
			String messge=br.readLine();
			System.out.println(messge);
			}
	}
}
