package ejemplos.ud02;

public class MutualExclusion {

	public static void main(String[] args) throws InterruptedException {
		int n = Integer.parseInt(args[0]);
		TwoMutex hilos[];
		Object lock1 = new Object();
		Object lock2 = new Object();
		System.out.println("Creando " + n + " hilos");
		
		hilos = new TwoMutex[n];
		for (int i=0; i<n; i++) {
			hilos[i] = new TwoMutex(lock1, lock2);
			hilos[i].start();
		}
		
		for (int i=0; i<n; i++) {
			hilos[i].join();
		}
		
		System.out.println("C1 = " + GlobalVar.c1);
		System.out.println("C2 = " + GlobalVar.c2);
	}

}
