package ejemplos.ud02.ej13;

import java.util.ArrayList;
import java.util.List;

public class EntradaParking {
	Object entradaCoches = new Object();
	Object entradaCamiones = new Object();
	
	public PlazaParking getPlazaCoche(Coche c) {
		PlazaParking plaza = null;
		
		try {
			synchronized (entradaCoches) {	
				while ((plaza = ParkingCamion.getPlazaCoche()) == null) {
					ParkingCamion.cocheEsperando++;
					entradaCoches.wait();
					ParkingCamion.cocheEsperando--;
				}
				
				plaza.setOcupado(true);
				plaza.setCocheAparcado(c);
	
				ParkingCamion.mostrarParking();
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
		return plaza;
	}
	
	public List<PlazaParking> getPlazaCamion (Camion c) {
		ArrayList<PlazaParking> plazas = null;
		
		try {
			synchronized (entradaCamiones) {
				while ((plazas = (ArrayList<PlazaParking>) ParkingCamion.getPlazaCamion()) == null) {
					ParkingCamion.camionEsperando++;
					entradaCamiones.wait();
					ParkingCamion.camionEsperando--;
				}
				
				for (int i=0; i<plazas.size(); i++) {
					plazas.get(i).setOcupado(true);
					plazas.get(i).setCamionAparcado(c);
				}
								
				ParkingCamion.mostrarParking();
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
		return plazas;
	}
	
	public void releasePlazaCoche(PlazaParking plaza) {
		synchronized (entradaCoches) {	
			plaza.setOcupado(false);
			plaza.setCocheAparcado(null);
		
			ParkingCamion.mostrarParking();
		
			entradaCoches.notifyAll();
			
			synchronized (entradaCamiones) {
				if (ParkingCamion.camionEsperando > 0) {
				entradaCamiones.notifyAll();
				}
			}
		}
	}
	
	public void releasePlazaCamion(List<PlazaParking> plazas) {
		synchronized (entradaCamiones) {
			for (int i=0; i<plazas.size(); i++) {
				plazas.get(i).setOcupado(false);
				plazas.get(i).setCamionAparcado(null);
			}
		
			ParkingCamion.mostrarParking();
		
			entradaCamiones.notifyAll();
			
			synchronized (entradaCoches) {
				if (ParkingCamion.cocheEsperando > 0) {
					entradaCoches.notifyAll();
				}
			}
		}
	}
}
