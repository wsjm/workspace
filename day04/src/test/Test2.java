package test;

import test.Number;
import test.Char;

public class Test2 {
	public static void main(String[] args) {
		Object object = new Object();
	Number number = new Number(object);
	number.start();
	Char char1 = new Char(object);
	char1.start();
}

	

}
