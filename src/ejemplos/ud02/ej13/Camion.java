package ejemplos.ud02.ej13;

import java.util.ArrayList;
import java.util.Random;

public class Camion extends Thread {
	Random r = new Random();
	EntradaParking entrada;
	ArrayList<PlazaParking> plazaOcupada = new ArrayList<>();
	private int idCamion;
	
	public Camion (int id, EntradaParking e) {
		idCamion = id;
		entrada = e;		
	}
	
	public int getIdCamion() {
		return idCamion;
	}

	public void setIdCamion(int idCamion) {
		this.idCamion = idCamion;
	}

	@Override
	public void run() {
		//El coche pasa un tiempo circulando antes de intentar aparcar
		try {
			ParkingCamion.showMessage("INFO: El camión " + this.getIdCamion() + " está circulando");
			Thread.sleep(r.nextInt(10) * 1_000L);
			
			ParkingCamion.showMessage("INFO: El camión " + this.getIdCamion() + " llega a la entrada del parking");
			plazaOcupada = (ArrayList<PlazaParking>) entrada.getPlazaCamion(this);
			
			ParkingCamion.showMessage("ENTRADA: El camión " + this.getIdCamion() + " aparca en la plaza " + plazaOcupada.get(0).getnPlaza());
			Thread.sleep(r.nextInt(10) * 3_000L);
			
			ParkingCamion.showMessage("SALIDA: El camión " + this.getIdCamion() + " sale de la plaza " + plazaOcupada.get(0).getnPlaza());
			entrada.releasePlazaCamion(plazaOcupada);
						
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
