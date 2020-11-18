package ejemplos.ud02;

public class RunThread {

	public static void main(String[] args) {
		
		new HelloThread().start(); //Crea y arranca un nuevo hilo
		try{
			Thread.sleep(100);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
			// Restore interrupted state...
		    Thread.currentThread().interrupt();

		}
		System.out.println("Hola desde el hilo principal");
		System.out.println("Hilo finalizando");

	}

}
