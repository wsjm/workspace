package com.keduo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.FIELD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Column {
	 //字段名字
	  public abstract String cname();
	  //字段是否为主键  true表示为主键
	  public abstract boolean isPk() default false;
}
