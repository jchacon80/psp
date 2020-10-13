package ejemplos.ud02;

public class HelloThread extends Thread {
	
	@Override
	public void run() {
		System.out.println("Hola desde el hilo creado!");
	}

}
