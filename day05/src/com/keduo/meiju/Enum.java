package com.keduo.meiju;

public enum Enum {

	sing("夏天"){

		@Override
		public void fh() {
			System.out.println("================");
		}
		
	},sss("狂三"){

		@Override
		public void fh() {
			// TODO Auto-generated method stub
			
		}
		
	},aaa("桐人"){

		@Override
		public void fh() {
			// TODO Auto-generated method stub
		}
	};
	String name;
	private Enum(String name ){
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
