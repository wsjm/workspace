package com.keduo.meiju;

public class Test {
	public static void main(String[] args) {
		 Enum[] enums= Enum.values();
		Enum enum1=Enum.sing;
		enum1.fh();
		System.out.println(Enum.sing.name());
		for (Enum enum2 : enums) {
			System.out.println(enum2.getName());
		}
	}

}
