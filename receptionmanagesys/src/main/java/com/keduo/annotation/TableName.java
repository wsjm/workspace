package com.keduo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 自定义接口，用于注释实体类对应的表名
 * @author ztz
 *
 */
@Target(ElementType.TYPE)//类或接口注释
@Retention(RetentionPolicy.RUNTIME)//运行时生效
public @interface TableName {
	public abstract String tName();
}
