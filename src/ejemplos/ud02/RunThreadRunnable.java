package ejemplos.ud02;

public class RunThreadRunnable {

	public static void main(String[] args) {
		
		new HelloThreadRunnable(); //Crea un nuevo hilo de ejecución
		System.out.println("Hola desde el hilo principal");
		System.out.println("Proceso acabando");
	}

}


