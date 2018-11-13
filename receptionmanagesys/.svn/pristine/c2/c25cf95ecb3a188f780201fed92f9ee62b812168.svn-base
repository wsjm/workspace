package com.keduo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 用于注释属性对应的表字段名
 * @author ztz
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldName {
	public abstract String fName();
	public abstract boolean isPrimaryKey() default false;
}
