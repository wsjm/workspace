package com.keduo.fuxi;

public class Test {
public static void main(String[] args) {
	Enum enum1=Enum.sing;
	System.out.println(enum1.name());
	Enum[] enums =enum1.values();
	for (Enum enum2 : enums) {
		System.out.println(enum2.getName());
	}
}
}
