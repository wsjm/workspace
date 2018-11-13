package com.keduo.xml;





import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {
public static void main(String[] args) throws Exception{
	//1.先创建SAXRader对象
	SAXReader saxReader=new SAXReader();
	//2.获得xml对应的Document
	Document  d= saxReader.read(Test.class.getResourceAsStream("/user.xml"));
	//3/获取xml的根元素
	Element e=d.getRootElement();
	//System.out.println(e);
	//4.获取根元素下面的子元素
	Iterator<Element> es= e.elementIterator();
	//5.遍历所有的元素
	while (es.hasNext()) {
		Element element = es.next();
		//System.out.println(element);
	//通过标签的名字获得标签
		Element nameE=element.element("name");
		//System.out.println(nameE);
		//同时获取他里面的值
		String name= nameE.getText();
		System.out.println(name);
		//根据标签的名字获取标签
		Element agElement=element.element("age");
		Element password=element.element("password");
		Element sex=element.element("sex");
		String age= agElement.getText();
		String password1=password.getText();
		Attribute attribute= nameE.attribute("id");
		if(sex!=null||attribute!=null) {
			String sex1=sex.getText();
			System.out.println(sex1);
			//获取标签上面的属性
			
			String s1= attribute.getText();
			System.out.println("id ="+s1);
		}
		
		
		System.out.println(age);
		System.out.println(password1);
		
		
		
	}
}
}
