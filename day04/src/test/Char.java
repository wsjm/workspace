package test;

public class Char extends Thread {
	private Object object;
	// �ж�ִ�м��εļ�����

	public Char(Object object) {
		this.object = object;
	}

	@Override
	public synchronized void run() {
		for (char i = 'A'; i <='Z'; i++) {
		synchronized (object) {
			System.out.print(i+" ");
			object.notifyAll();
			try {
				object.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			

		}

	}

}