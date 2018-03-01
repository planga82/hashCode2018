package es.main;

import java.io.IOException;
import java.util.ArrayList;

public class EscribeAFicheroResultado {

	
	public static void escribe(String file, ArrayList<Car> salida) throws IOException {
		ArrayList<String> lineasSalida = new ArrayList<>();
		
		for (Car car : salida) {
			String linea = String.valueOf(car.idViajesCompletados.size());
			ArrayList<Integer> rides = car.idViajesCompletados;
			for (Integer ride : rides) {
				linea = linea + " " + String.valueOf(ride);
			}			
			lineasSalida.add(linea);
		}
		
		Utils.writeFile(file, lineasSalida);
		
	}
}
