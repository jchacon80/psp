package ejemplos.ud02.ej13;

import java.util.Random;

public class Coche extends Thread {
	Random r = new Random();
	EntradaParking entrada;
	PlazaParking plazaOcupada = null;
	private int idCoche;
	
	public Coche (int id, EntradaParking e) {
		idCoche = id;
		entrada = e;
	}
	
	public int getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(int idCoche) {
		this.idCoche = idCoche;
	}

	@Override
	public void run() {
		//El coche pasa un tiempo circulando antes de intentar aparcar
		try {
			ParkingCamion.showMessage("INFO: El coche " + this.getIdCoche() + " está circulando");
			Thread.sleep(r.nextInt(10) * 1_000L);
			
			ParkingCamion.showMessage("INFO: El coche " + this.getIdCoche() + " llega a la entrada del parking");
			plazaOcupada = entrada.getPlazaCoche(this);
			
			ParkingCamion.showMessage("ENTRADA: El coche " + this.getIdCoche() + " aparca en la plaza " + plazaOcupada.getnPlaza());
			Thread.sleep(r.nextInt(10) * 3_000L);
			
			ParkingCamion.showMessage("SALIDA: El coche " + this.getIdCoche() + " sale de la plaza " + plazaOcupada.getnPlaza());
			entrada.releasePlazaCoche(plazaOcupada);
						
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		
		
	}
	

	
	
}
