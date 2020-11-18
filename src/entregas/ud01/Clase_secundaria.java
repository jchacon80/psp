package entregas.ud01;
/*Clase creada para realizar preguntas al usuario e interpretarlas ; 
 *los metodos alquilada y tiempoPasado estan creadas de forma no funcional
 *@version 1.3
 *@Enrique Albors
 */
import java.util.Scanner;

public class Clase_secundaria {

	// Se encargará de mostrar las opciones del menú , ademas de una pequeña cortina
	//separadora
	public static void muestraMenu() {
		
		System.out.println("Las opciones son : \n Alquilar \n Devolver \n Consultar \n Salir");
		System.out.println("*******************************************************************");
	}

	/*Metodo que devuelve falso o verdadero en base a un aleatorio de dos opciones
	 * */
	public static String alquilada() {
		
		boolean opcion = false;
		opcion = Math.random() < 0.5;
		if (opcion == true)
			return " no se puede alquilar";
		else
			return " la pelicula está disponible";
	}

	/*Metodo que devuelve falso o verdadero en base a un aleatorio de dos opciones
	 * */
	public static String tiempoPasado() {
		boolean opcion = false;
		opcion = Math.random() < 0.5;
		if (opcion == true)
			return " Devolucion sin sobrecostes";
		else
			return " Debe pagar un sobrecoste por haberse pasado ";

	}

	/*Metodo main , se realizan las impresiones por pantalla y se recibe la información que 
	 * será tratada , solo contemplamos 3 opciones aparte de la de Salir . 
	 * */
	public static void main(String[] args) {
		

		// declaración de variables
		Scanner teclado = new Scanner(System.in);
		String op = "hola";
		String peli = "";
		String alquiler;
		String espaciador = "################################################";

		// Impresión de saludo al usuario
		System.out.println("Bienvenido a BlockBuster ¿En que puedo ayudarle?");

		// Mientras que no se introduzca la palabra "Salir" , el bucle seguirá
		// desarrollandose
		while (!op.equalsIgnoreCase("Salir")) {

			muestraMenu();

			op = teclado.next();

			switch (op) {

			case "Alquilar":
				System.out.println("Introduzca el nombre de la pelicula ...");
				teclado = new Scanner(System.in);
				alquiler = teclado.next();
				System.out.println("Pelicula registrada en el archivo de alquileres");
				System.out.println(espaciador);
				break;

			case "Devolver":
				System.out.println("Introduzca el codigo de barras");
				teclado = new Scanner(System.in);
				int codigo = teclado.nextInt();
				System.out.println(tiempoPasado());
				System.out.println(espaciador);
				break;

			case "Consultar":
				System.out.println("Introduzca el nombre de la pelicula");
				teclado = new Scanner(System.in);
				peli = teclado.next();
				System.out.println(peli + alquilada());
				System.out.println(espaciador);
				break;

			case "Salir":
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Comando no implementado");
				break;

			}

		}

	}

}