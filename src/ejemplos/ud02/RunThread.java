package ejemplos.ud02;

public class RunThread {

	public static void main(String[] args) {
		
		new HelloThread().start(); //Crea y arranca un nuevo hilo
		System.out.println("Hola desde el hilo principal");
		System.out.println("Hilo finalizando");

	}

}
