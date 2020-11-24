package ejemplos.ud02.ej13;

public class PlazaParking {
	int nPlaza = 0;
	boolean ocupado = false;
	Coche cocheAparcado = null;
	Camion camionAparcado = null;

	public PlazaParking (int n) {
		nPlaza = n;
	}
	
	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	public int getnPlaza() {
		return nPlaza;
	}

	public Coche getCocheAparcado() {
		return cocheAparcado;
	}

	public void setCocheAparcado(Coche cocheAparcado) {
		this.cocheAparcado = cocheAparcado;
	}

	public Camion getCamionAparcado() {
		return camionAparcado;
	}

	public void setCamionAparcado(Camion camionAparcado) {
		this.camionAparcado = camionAparcado;
	}

	public void setnPlaza(int nPlaza) {
		this.nPlaza = nPlaza;
	}

}
