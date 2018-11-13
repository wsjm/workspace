package com.keduo.test3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class TestProductXml {

	public static void main(String[] args)throws Exception {
		//获取 JAXBContext对象
		JAXBContext jc= JAXBContext.newInstance(Product.class);
		//获取Unmarshaller对象
		Unmarshaller ul=jc.createUnmarshaller();
		Product p=(Product)ul.unmarshal(TestProductXml.class.getResourceAsStream("/products.xml"));
	    System.out.println(p);
	    
	}

}
