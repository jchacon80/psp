package ejemplos.ud02;

public class HelloThreadRunnable implements Runnable {

	Thread t;
	
	HelloThreadRunnable () {
		t = new Thread(this, "Nuevo thread");
		System.out.println("Creado hilo: " + t);
		t.start(); //arranca el nuevo hilo de ejecuci�n y ejecuta el m�todo run
	}
	
	@Override
	public void run() {
		System.out.println("Hola desde el hilo creado!");
		System.out.println("Hilo finalizando");
	}

}


