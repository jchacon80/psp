package ejemplos.ud03;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class ReceptorDatagramSocket {

	public static void main(String[] args) {
		try {
			System.out.println("Creando socket datragram");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			DatagramSocket socket = new DatagramSocket(addr);
			
			System.out.println("Recibiendo mensaje");
			byte[] message = new byte[25];
			DatagramPacket datagram1 = new DatagramPacket(message, 25);
			socket.receive(datagram1);
			
			System.out.println("Mensaje recibido: " + new String(message));
			
			System.out.println("Enviando mensaje");
			InetAddress addr2 = InetAddress.getByName("localhost");
			DatagramPacket datagram2 = new DatagramPacket(message, message.length, addr2, 5556);
			socket.send(datagram2);
			
			System.out.println("Mensaje enviado");
			
			System.out.println("Cerrando el socket datagram");
			socket.close();
			
			System.out.println("Terminado");			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
