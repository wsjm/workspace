package com.keduo.fuxi;

public enum Enum {
	//创建一个枚举类
	sing("唱歌"){
		@Override
		public void fh() {
			System.out.println("哈哈我是你的抽象方法");
		}
	},haha("叽叽"){
		@Override
		public void fh() {
			System.out.println("嗨嗨嗨 ");
			
		}
	};
	String name;
	private Enum(String name){
		this.name=name;
	}
	
public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

public abstract void fh();

}
