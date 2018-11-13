package test;

public class Number extends Thread {
	private Object object;

	public Number(Object object) {
		this.object = object;
	}

	@Override
	public void run() {

		synchronized (object) {
			for (int i = 1; i <= 52; i++) {
//					if (i == 52) {
//						break;
//					}
				System.out.print(i + " ");
					object.notifyAll();
				if (i%2==0) {
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

}
