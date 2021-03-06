package ejemplos.ud01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ProcessCommunication {

	public static void main(String[] args) throws IOException {
		
		//final String commands[] = {"cmd.exe", "/c", "ping -n 3 google.com"};
		final String commands[] = {"cmd", "/C", "dir"};
		
		Process process = new ProcessBuilder(commands).start();
		InputStream is = process.getInputStream();
		//InputStreamReader isr = new InputStreamReader(is);
		//InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
		InputStreamReader isr = new InputStreamReader(is, "Cp850");
		
		BufferedReader br = new BufferedReader(isr);
		String line;
		
		while ((line = br.readLine()) != null) {
			System.out.println(line);

		}
		
		// Esperamos que el proceso termine
		try {
			int exitValue = process.waitFor();
			System.out.println("\nC�digo de salida: "+ exitValue);
		} catch (InterruptedException e) {
			e.printStackTrace(System.err);
			Thread.currentThread().interrupt();
		}
	}
}


