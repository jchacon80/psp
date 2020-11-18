package ejemplos.ud02;

public class Alumno extends Thread {
	Bienvenida saludo;
	int i;
	
	public Alumno(Bienvenida bienvenida, int i) {
		this.saludo = bienvenida;
		this.i = i;
	}
	
	@Override
	public void run() {
		System.out.println("Alumno: " + this.i + " llegó");
		try {
			Thread.sleep(1000);
			saludo.saludarProfesor();
		} catch (InterruptedException ex) {
			System.err.println("Thread alumno interrumpido");
			Thread.currentThread().interrupt();
			System.exit(-1);
		}
	}
}
