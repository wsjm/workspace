package com.keduo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.FIELD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Column {
	 //�ֶ�����
	  public abstract String cname();
	  //�ֶ��Ƿ�Ϊ����  true��ʾΪ����
	  public abstract boolean isPk() default false;
}
