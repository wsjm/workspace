package test2;

public class Char1 extends Thread{
private static Object q;
private static int num;
 public Char1(Object q) {
	this.q=q;
}
	@Override
	public void run() {
		Char2();
		Num2();
	}
	//��ӡA-Z
	public static void Char2(){
		for(int i=1;i<=1000;i++){
			synchronized(q){
			for (char j = 'A'; j < 'Z'; j++) {
				System.out.print(j+"\t");
			}
			}
		}
	}
	//��ӡ1-26000֮������ֲ��Ҵ�ӡ1000��
	public static void Num2() {
		for (int i = 0; i < 1000; i++) {
			synchronized (q) {
				for(int j=1;j<=26;j++){
					System.out.print(j);
					
				}
				System.out.println(num++);
				System.out.println();
			}
		}
		
	}
	
	
}
