package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {
	//属性上的注解
	public abstract String Fname();
	//判断是否为主键
	public abstract boolean isPK() default false;
}
