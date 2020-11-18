package ejemplos.ud02;

public class TwoMutex extends Thread {
	
	private Object mutex1;
	private Object mutex2;
	
	public TwoMutex (Object lock1, Object lock2) {
		mutex1 = lock1;
		mutex2 = lock2;
	}
	
	public void inc1() {
		for (int i=0; i<10000; i++) {
		synchronized (mutex1) {
				GlobalVar.c1++;
			}
		}
	}
	
	public void inc2() {
		for (int i=0; i<10000; i++) {
		synchronized (mutex2) {
				GlobalVar.c2++;
			}
		}
	}
	
	@Override
	public void run() {
		inc1();
		inc2();
	}
}
